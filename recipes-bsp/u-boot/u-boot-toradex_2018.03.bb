SUMMARY = "U-Boot bootloader with support for Toradex i.MX8 SoM"
require recipes-bsp/u-boot/u-boot.inc
require recipes-bsp/u-boot/u-boot-toradex-initial-env.inc
require u-boot-toradex-common_${PV}.inc

PROVIDES += "u-boot"
DEPENDS_append = " dtc-native"

SRC_URI_append_apalis-imx8a0 = " file://0001-Revert-apalis-imx8-fused-modules-boot-from-emmc.patch"

BOOT_TOOLS = "imx-boot-tools"

UBOOT_NAME_mx6 = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
UBOOT_NAME_mx7 = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
UBOOT_NAME_mx8 = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
