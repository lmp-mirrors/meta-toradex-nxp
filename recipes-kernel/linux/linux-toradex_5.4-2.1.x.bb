FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"
require recipes-kernel/linux/linux-imx.inc

python () {
    # Explicitly set KERNEL_FEATURES to empty, since we dont support KMETA yet.
    kernel_features = d.getVar('KERNEL_FEATURES')
    if kernel_features:
        d.setVar('KERNEL_FEATURES', '')
}

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"
SUMMARY_append_preempt-rt = "Real-Time Linux kernel for Toradex Freescale i.MX based modules"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI = " \
    git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
    file://defconfig \
"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

inherit toradex-kernel-localversion
LINUX_VERSION = "5.4.47"
# skip, as with use-head-next LINUX_VERSION might be set wrongly
KERNEL_VERSION_SANITY_SKIP_use-head-next = "1"

# Make sure to override LOCALVERSION in linux-imx.inc
LOCALVERSION = "-${TDX_VERSION}"
PV_append = "+git${SRCPV}"

SRCREV = "9e7307657fc1b86fc652abd32676b516fc28fe23"
SRCBRANCH = "toradex_5.4-2.1.x-imx"
SRCREV_use-head-next = "${AUTOREV}"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"

###############################################################################
# Apply the RT patch and change the configuration to use PREMPT_RT when the
# preempt-rt override is set.
###############################################################################

# patches get moved into the 'older' directory when superseeded, so provide
# both possible storage locations.
MIRRORS_append_preempt-rt = "${KERNELORG_MIRROR}/linux/kernel/projects/rt/5.4/older/ ${KERNELORG_MIRROR}/linux/kernel/projects/rt/5.4/"
SRC_URI_append_preempt-rt = " \
    ${KERNELORG_MIRROR}/linux/kernel/projects/rt/5.4/older/patch-5.4.47-rt28.patch.xz;name=rt-patch \
"
# This patches do currently not apply but are likely needed or we get
# runtime bugs.
#    file://0001-imx_sc_thermal-prevent-BUG-with-rt-patch.patch \
#    file://0002-ddr-perf-prevent-BUG-with-rt-patch.patch \
#

SRC_URI[rt-patch.md5sum] = "032a1eee60e746fe32a3aa73604bc3e4"
SRC_URI[rt-patch.sha256sum] = "dadc1379e816e8a23f09713884f8889f0177f291974487f33efc9a646082c562"

kernel_do_configure_append_preempt-rt() {
    # switch to use PREEMPT_RT
    kernel_configure_variable PREEMPT_NONE n
    kernel_configure_variable PREEMPT_VOLUNTARY n
    kernel_configure_variable PREEMPT n
    kernel_configure_variable PREEMPT_RT y
    oe_runmake olddefconfig
}