require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Real-time Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://rename_define.patch \
           file://cond_resched.patch \
           file://patch-3.14.61-rt64-acpi-removed.patch.gz \
           file://0001-fix-build.patch \
           file://0003-no-split-ptlocks.patch \
           file://0004-imx-sdma-channel-use-raw-spinlock.patch \
           file://defconfig \
"

# two patches taken from here:
# rename_define.patch https://github.com/Freescale/linux-fslc/commit/d379e64ca4fc535334a02dc0314cba6e50f4b720.patch
# cond_resched.patch  https://github.com/Freescale/linux-fslc/commit/e211cb68dd3c951b104ff0b47dbaed2c8b8d2399.patch

LOCALVERSION = "-v2.6b2-rt"
SRCBRANCH = "toradex_imx_3.14.52_1.1.0_ga"
SRCREV = "7c83cef87116c0b2aaaf867f406831643306d3d1"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx6|mx7)"
