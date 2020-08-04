FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append = " \
    file://0001-plat-imx8mm-provide-uart-base-as-build-option.patch \
    file://0001-Revert-Add-NXP-s-SoCs-partition-reboot-support.patch \
"

PV = "2.2+git${SRCPV}"
SRCBRANCH = "imx_5.4.24_2.1.0"
SRCREV = "b0a00f22b09c13572d3e87902a1069dee34763bd"

EXTRA_OEMAKE_append_verdin-imx8mm = " \
    IMX_BOOT_UART_BASE=0x30860000 \
"
