require recipes-kernel/linux/linux-imx.inc
include conf/tdx_version.conf

SUMMARY = "Linux kernel with real-time patch for Toradex Colibri VFxx Computer on Modules"

SRC_URI = " \
    git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
    https://www.kernel.org/pub/linux/kernel/projects/rt/4.4/older/patch-4.4.138-rt155.patch.xz;name=rt-patch \
    file://defconfig \
"

SRC_URI[rt-patch.md5sum] = "77d6867ad455e28225faafb8ceb999ea"
SRC_URI[rt-patch.sha256sum] = "f2e6b4bda77840ecbe7d2b30ad72ed6056c3562a4b5d25e4b15d7f377c81d342"

KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-${PR}"
PR = "${TDX_VER_ITEM}"

SRCREV = "c2be367662f77746eeeb21bb5ea9ed275551ffd1"
SRCBRANCH = "toradex_vf_4.4"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "toradex_vf_4.4-next"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
