require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc
include conf/tdx_version.conf

SUMMARY = "Real-Time Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH}"

SRC_URI += " \
    https://www.kernel.org/pub/linux/kernel/projects/rt/4.1/older/patch-4.1.40-rt48.patch.gz;name=rt-patch \
    file://0001-cgroup-defs.h-add-missing-include.patch \
    file://0001-fix-build.patch \
    file://0002-no-split-ptlocks.patch \
    file://0003-Work-around-CPU-stalls-in-the-imx-sdma-driver.patch \
    file://0004-export-swait-locked-functions.patch \
    file://defconfig \
"
SRC_URI[rt-patch.md5sum] = "085046ef6cecd45b7fcd9f2dfd9e7f1b"
SRC_URI[rt-patch.sha256sum] = "3960999107c3a06eb9cc92c5b649a725b9d8f354a430cdf4f28305f6c8547d6a"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-${PR}"
PR = "${TDX_VER_INT}-rt"

SRCBRANCH = "toradex_4.1-2.0.x-imx"
SRCREV = "82f0f4f012a646a735d6b44de77b7c9d0712c714"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx7|mx6)"
