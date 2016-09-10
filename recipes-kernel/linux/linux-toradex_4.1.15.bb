require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-v2.6.1b1"
SRCBRANCH = "toradex_imx_4.1.15_1.0.0_ga"
SRCREV = "bef7a90406b663a74aaaf06bdccc56285d9fe93c"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx7)"
