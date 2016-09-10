require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Toradex Colibri VFxx Computer on Modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-v2.6.1b1"
SRCBRANCH = "toradex_vf_4.4"
SRCREV = "9b8bd3d738db0921c5b8886fef477dfd5d91f997"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
