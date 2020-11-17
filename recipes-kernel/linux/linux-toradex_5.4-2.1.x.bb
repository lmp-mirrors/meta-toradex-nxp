FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"
require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"
SUMMARY_append_preempt-rt = "Real-Time Linux kernel for Toradex Freescale i.MX based modules"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI = " \
    git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH};name=machine \
"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

inherit toradex-kernel-localversion
LINUX_VERSION = "5.4.74"
# skip, as with use-head-next LINUX_VERSION might be set wrongly
KERNEL_VERSION_SANITY_SKIP_use-head-next = "1"

# Make sure to override LOCALVERSION in linux-imx.inc
LOCALVERSION = "-${TDX_VERSION}"

SRCREV = "43672b04da88582315ad1e0106e4aed349676f0d"
SRCBRANCH = "toradex_5.4-2.1.x-imx"
SRCREV_machine = "8bb9d758833ea1d0622277981b5225980ba0a42d"
SRCREV_machine_use-head-next = "${AUTOREV}"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"

KBUILD_DEFCONFIG_apalis-imx6 ?= "apalis_imx6_defconfig"
KBUILD_DEFCONFIG_colibri-imx6 ?= "colibri_imx6_defconfig"
KBUILD_DEFCONFIG_colibri-imx6ull ?= "colibri-imx6ull_defconfig"
KBUILD_DEFCONFIG_mx7 ?= "colibri_imx7_defconfig"
KBUILD_DEFCONFIG_mx8 ?= "defconfig"

###############################################################################
# Apply the RT patch and change the configuration to use PREMPT_RT when the
# preempt-rt override is set.
###############################################################################

# patches get moved into the 'older' directory when superseeded, so provide
# both possible storage locations.
MIRRORS_append_preempt-rt = "${KERNELORG_MIRROR}/linux/kernel/projects/rt/5.4/older/ ${KERNELORG_MIRROR}/linux/kernel/projects/rt/5.4/"
SRC_URI_append_preempt-rt = " \
    ${KERNELORG_MIRROR}/linux/kernel/projects/rt/5.4/older/patch-5.4.74-rt42.patch.xz;name=rt-patch \
    file://preempt-rt.scc \
"
# This patches do currently not apply but are likely needed or we get
# runtime bugs.
#    file://0001-imx_sc_thermal-prevent-BUG-with-rt-patch.patch \
#    file://0002-ddr-perf-prevent-BUG-with-rt-patch.patch \
#

SRC_URI[rt-patch.md5sum] = "edea05c93607c823405cb93554ec7fa0"
SRC_URI[rt-patch.sha256sum] = "d01dbd660c50f5e085a42a03ad734c747d5b0a4d035dc6aa64ce692bf42d1386"
