require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc
include conf/tdx_version.conf

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-${PR}"
PR = "${TDX_VER_INT}"

SRCBRANCH = "toradex_4.1-2.0.x-imx"
SRCREV = "ba2f75f559bc54406e8938ab5be722298fe7166c"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx7|mx6)"
