require recipes-kernel/linux/linux-imx.inc
include conf/tdx_version.conf

SUMMARY = "Linux kernel with real-time patch for Toradex Colibri VFxx Computer on Modules"

SRC_URI = " \
    git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
    https://www.kernel.org/pub/linux/kernel/projects/rt/4.4/older/patch-4.4.220-rt197.patch.xz;name=rt-patch \
    file://defconfig \
"

SRC_URI[rt-patch.md5sum] = "5f370aaf4f8e6e1345def1ec74b1eee0"
SRC_URI[rt-patch.sha256sum] = "3bb20e617b68b822d7e659b551e9c24ad01ac91d47dbb5b974235d67893f0daf"

KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-${PR}"
PR = "${TDX_VER_ITEM}"

SRCREV = "6f01eb5bf8e8110ab5f3a8e7b0f3abf19a205e4b"
SRCBRANCH = "toradex_vf_4.4"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "toradex_vf_4.4-next"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
