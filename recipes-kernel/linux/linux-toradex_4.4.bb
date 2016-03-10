require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Toradex Colibri VFxx Computer on Modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-v2.6b1"
SRCBRANCH = "toradex_vf_4.4-next"
SRCREV = "a892c86d9498144ca1306f6a308a68b96d5aef88"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
