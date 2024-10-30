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
SRCREV_meta-toradex-bsp = "440dd720d042e9e057c29aa439270e6398944abf"
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

LINUX_VERSION = "6.6.54"
SRCBRANCH = "toradex_6.6-2.1.x-imx"
SRCREV_machine = "f543ea57a26695955c073e42fd68dbe073ea16b6"
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
    ${KERNELORG_MIRROR}/linux/kernel/projects/rt/6.6/older/patch-6.6.53-rt44.patch.xz;name=rt-patch \
"

SRC_URI[rt-patch.sha256sum] = "2f275f591bce00c6f2e36783a346ab41da4f5ee03abfb4962320e1fde1dad3bb"

LINUX_KERNEL_TYPE:preempt-rt = "preempt-rt"
LINUX_VERSION:preempt-rt = "6.6.53-rt44"

# The downloaded RT patch doesn't have a upstream status tag
ERROR_QA:remove:preempt-rt = "patch-status"
