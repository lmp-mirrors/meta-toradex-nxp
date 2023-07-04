require recipes-bsp/u-boot/u-boot.inc
require recipes-bsp/u-boot/u-boot-toradex-common_${PV}.inc

SUMMARY = "U-Boot bootloader with support for Toradex i.MX 8 series SoMs"

B = "${WORKDIR}/build"

PROVIDES += "u-boot"
DEPENDS += "bc-native dtc-native python3-setuptools-native"

BOOT_TOOLS = "imx-boot-tools"

SRCREV = "7bd2074193e156358adc5b5065c690371cf78231"
