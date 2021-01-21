PV = "2.2+git${SRCPV}"
SRCBRANCH = "toradex_imx_5.4.70_2.3.0"
SRCREV = "7f1187ba31cc1624f7dadd98998e010cb229926a"
SRCREV_use-head-next = "${AUTOREV}"
SRC_URI = "git://git.toradex.com/imx-atf.git;protocol=https;branch=${SRCBRANCH}"

EXTRA_OEMAKE_append = " \
    BUILD_STRING="${SRCBRANCH}-g${@'${SRCPV}'.replace('AUTOINC+', '')}" \
"
EXTRA_OEMAKE_append_verdin-imx8mm = " \
    IMX_BOOT_UART_BASE=0x30860000 \
"
EXTRA_OEMAKE_append_verdin-imx8mp = " \
    IMX_BOOT_UART_BASE=0x30880000 \
"
