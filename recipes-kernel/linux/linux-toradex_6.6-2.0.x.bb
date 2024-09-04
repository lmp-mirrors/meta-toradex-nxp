FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"
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
SRCREV_meta-toradex-bsp = "88ef0deeac0802682ce42d9ea096578833a0f0f7"
SRCREV_meta-toradex-bsp:use-head-next = "${AUTOREV}"

S = "${WORKDIR}/git"

KCONFIG_MODE="--alldefconfig"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

inherit kernel-yocto kernel pkgconfig toradex-kernel-deploy-config toradex-kernel-localversion

export DTC_FLAGS = "-@"

KERNEL_VERSION_SANITY_SKIP = "1"
do_kernel_configcheck[noexec] = "1"

DEPENDS += "bc-native"
COMPATIBLE_MACHINE = "mx8-nxp-bsp"

LINUX_VERSION = "6.6.23"
SRCBRANCH = "toradex_6.6-2.0.x-imx"
SRCREV_machine = "5545cedda0e3b4e7282069d74a94db292b0c0eb6"
SRCREV_machine:use-head-next = "${AUTOREV}"

###############################################################################
# Apply the RT patch and change the configuration to use PREMPT_RT when the
# preempt-rt override is set.
###############################################################################

SUMMARY:preempt-rt = "Real-time Linux kernel for Toradex Freescale i.MX based modules"

MIRRORS:append:preempt-rt = "\
    ${KERNELORG_MIRROR}/linux/kernel/projects/rt/6.6/older/ \
    ${KERNELORG_MIRROR}/linux/kernel/projects/rt/6.6/ \
"

SRC_URI:append:preempt-rt = " \
    ${KERNELORG_MIRROR}/linux/kernel/projects/rt/6.6/older/patch-6.6.23-rt28.patch.xz;name=rt-patch \
"

SRC_URI[rt-patch.sha256sum] = "a4fb0a6532988a1ca68ed1c8bf06d11db621563624cf4e2577638c6d71022551"

LINUX_KERNEL_TYPE:preempt-rt = "preempt-rt"
LINUX_VERSION:preempt-rt = "6.6.23-rt28"

# The downloaded RT patch doesn't have a upstream status tag
ERROR_QA:remove:preempt-rt = "patch-status"
