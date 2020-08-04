require recipes-bsp/u-boot/u-boot.inc
require u-boot-toradex-common_${PV}.inc

SUMMARY = "U-Boot bootloader with support for Toradex i.MX 8 series SoMs"

B = "${WORKDIR}/build"

PROVIDES += "u-boot"
DEPENDS_append = " dtc-native"

SRC_URI_append_use-mainline-bsp_colibri-imx8x = " file://0001-colibri-imx8x-modify-device-tree-name-for-mainline-u.patch"

BOOT_TOOLS = "imx-boot-tools"
