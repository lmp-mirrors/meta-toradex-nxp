require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-v2.6a1"
SRCBRANCH = "toradex_imx_3.14.52_1.1.0_ga"
SRCREV = "32d17d80640a2625842649cead8ba9578d02f759"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx7)"

# use the defconfig in the sources for now. I'm to lazy to manage the config in two places
do_configure_prepend () {
    cp ${S}/arch/arm/configs/colibri_imx7_defconfig ${WORKDIR}/defconfig
}
