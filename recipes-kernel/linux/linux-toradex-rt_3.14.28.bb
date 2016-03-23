require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://0001-ARM-imx6q-drop-unnecessary-semicolon.patch \
           file://0002-ARM-clk-imx6q-fix-video-divider-for-rev-T0-1.0.patch \
           file://0003-ARM-imx6sl-Disable-imx6sl-specific-code-when-imx6sl-.patch \
           file://0004-mmc-sdhci-esdhc-imx-Fixup-runtime-PM-conditions-duri.patch \
           file://0005-Revert-net-fec-fix-the-warning-found-by-dma-debug.patch \
           file://patch-3.14.28-rt25-acpi-removed.patch.gz \
           file://0001-fix-build.patch \
           file://0002-fix-build-with-rt-enabled.patch \
           file://0003-no-split-ptlocks.patch \
           file://0004-imx-sdma-channel-use-raw-spinlock.patch \
           file://defconfig"

LOCALVERSION = "-v2.6b1-rt"
SRCBRANCH = "toradex_imx_3.14.28_1.0.0_ga"
SRCREV = "0bb38d19090dc611c8bc9c18e770620c73f7563c"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx6)"
