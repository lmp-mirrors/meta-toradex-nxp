SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM ?= "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

require recipes-kernel/linux/linux-imx.inc

SRC_URI = " \
    git://git.toradex.com/linux-toradex.git;protocol=https;branch=${SRCBRANCH};name=machine \
    ${KCONFIG_REPO};protocol=https;type=kmeta;name=meta-toradex-bsp;branch=main;destsuffix=${KMETA} \
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

