PV_tdx = "2.2+git${SRCPV}"
SRCBRANCH_tdx = "toradex_imx_5.4.70_2.3.0"
SRCREV_tdx = "2fa8c6349e9a1d965757d44f05a6c72687850b77"
SRCREV_use-head-next_tdx = "${AUTOREV}"
SRC_URI_tdx = "git://git.toradex.com/imx-atf.git;protocol=https;branch=${SRCBRANCH}"

EXTRA_OEMAKE_append_tdx = " \
    BUILD_STRING="${SRCBRANCH}-g${@'${SRCPV}'.replace('AUTOINC+', '')}" \
"
EXTRA_OEMAKE_append_verdin-imx8mm = " \
    IMX_BOOT_UART_BASE=0x30860000 \
"
EXTRA_OEMAKE_append_verdin-imx8mp = " \
    IMX_BOOT_UART_BASE=0x30880000 \
"
