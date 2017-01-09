require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-v2.7b1"
SRCBRANCH = "toradex_4.1-2.0.x-imx-next"
SRCREV = "bf923b9cb22d7ea2806abf0d06baa52f6a69e749"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx7|mx6)"
