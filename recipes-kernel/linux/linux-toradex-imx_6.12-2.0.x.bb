FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"

SUMMARY = "Linux kernel for Toradex Freescale i.MX 64bit based modules"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM ?= "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

require recipes-kernel/linux/linux-imx.inc

SRC_URI = " \
    git://git.toradex.com/linux-toradex.git;protocol=https;branch=${SRCBRANCH};name=machine \
    ${KCONFIG_REPO};protocol=https;type=kmeta;name=meta-toradex-bsp;branch=main;destsuffix=${KMETA} \
    file://nxp-imx.cfg \
"

KCONFIG_REPO = "git://git.toradex.com/linux-toradex-kconfig.git"
KMETA = "kernel-meta-toradex-bsp"
SRCREV_meta-toradex-bsp = "78c70bc57ab5a8efb3cebd86624539fd5e9c2a45"
SRCREV_meta-toradex-bsp:use-head-next = "${AUTOREV}"

S = "${WORKDIR}/git"

KCONFIG_MODE = "--alldefconfig"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

inherit kernel-yocto kernel pkgconfig toradex-kernel-deploy-config toradex-kernel-localversion

export DTC_FLAGS = "-@"

KERNEL_VERSION_SANITY_SKIP = "1"
do_kernel_configcheck[noexec] = "1"

DEPENDS += "bc-native"
COMPATIBLE_MACHINE = "(mx8-nxp-bsp|mx9-nxp-bsp)"

LINUX_VERSION = "6.12.49"
SRCBRANCH = "toradex_6.12-2.0.x-imx"
SRCREV_machine = "ba6cdcdc9ad9cbff84ef6fdc0b426c5eb37d7926"
SRCREV_machine:use-head-next = "${AUTOREV}"

###############################################################################
# Apply the RT patch and change the configuration to use PREMPT_RT when the
# preempt-rt override is set.
###############################################################################

SUMMARY:preempt-rt = "Real-time Linux kernel for Toradex Freescale i.MX based modules"

MIRRORS:append:preempt-rt = "\
    ${KERNELORG_MIRROR}/linux/kernel/projects/rt/6.12/older/ \
    ${KERNELORG_MIRROR}/linux/kernel/projects/rt/6.12/ \
"

SRC_URI:append:preempt-rt = " \
    ${KERNELORG_MIRROR}/linux/kernel/projects/rt/6.12/older/patch-6.12.49-rt13.patch.xz;name=rt-patch \
"

SRC_URI[rt-patch.sha256sum] = "6d4b325649b74c443a7f9577dc5a3972e9f46316aac2538cab0ff5944685c361"

LINUX_KERNEL_TYPE:preempt-rt = "preempt-rt"
LINUX_VERSION:preempt-rt = "6.12.49-rt13"

# The downloaded RT patch doesn't have a upstream status tag
ERROR_QA:remove:preempt-rt = "patch-status"
