FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"
require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI = " \
    git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
    file://defconfig \
"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

inherit toradex-kernel-localversion
# Make sure to override LOCALVERSION in linux-imx.inc
LOCALVERSION = "-${TDX_VERSION}"
PV_append = "+git${SRCPV}"

SRCREV = "5c643afa32bee5141224919d63a0fafa955cf709"
SRCBRANCH = "toradex_4.14-2.3.x-imx"
SRCREV_use-head-next = "${AUTOREV}"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
