require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Real-time Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           https://github.com/Freescale/linux-fslc/commit/d379e64ca4fc535334a02dc0314cba6e50f4b720.patch;name=rename_define.patch \
           https://github.com/Freescale/linux-fslc/commit/e211cb68dd3c951b104ff0b47dbaed2c8b8d2399.patch;name=cond_resched.patch \
           file://patch-3.14.61-rt64-acpi-removed.patch.gz \
           file://0001-fix-build.patch \
           file://0003-no-split-ptlocks.patch \
           file://0004-imx-sdma-channel-use-raw-spinlock.patch \
           file://defconfig \
"

SRC_URI[rename_define.patch.md5sum] = "efae6dd8a584fd02888f5c9bae8461cd"
SRC_URI[rename_define.patch.sha256sum] = "4aec310ce68114d7025db33f5b766acae454c77407cb57ffd3fa53e7b9a85488"

SRC_URI[cond_resched.patch.md5sum] = "1316f67ec098639048c8d1c28af2a150"
SRC_URI[cond_resched.patch.sha256sum] = "40e5db88b03b98d81ea672ee70af7d02ed3cf39104ebfa5a193000fc3adad489"

LOCALVERSION = "-v2.6b2-rt"
SRCBRANCH = "toradex_imx_3.14.52_1.1.0_ga-next"
SRCREV = "9ace52b11aca9bbb657a35612c72c83c85b7e92c"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx6|mx7)"

