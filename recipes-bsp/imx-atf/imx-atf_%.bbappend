PV = "2.2+git${SRCPV}"
SRCBRANCH = "toradex_imx_5.4.24_2.1.0"
SRCREV = "0a236bda5e863b523371e039ca7178d8340992f5"
SRCREV_use-head-next = "${AUTOREV}"
SRC_URI = "git://git.toradex.com/imx-atf.git;protocol=https;branch=${SRCBRANCH}"

EXTRA_OEMAKE_append_verdin-imx8mm = " \
    IMX_BOOT_UART_BASE=0x30860000 \
    BUILD_STRING="${SRCBRANCH}-g${@'${SRCPV}'.replace('AUTOINC+', '')}" \
"
EXTRA_OEMAKE_append_verdin-imx8mp = " \
    IMX_BOOT_UART_BASE=0x30880000 \
    BUILD_STRING="${SRCBRANCH}-g${@'${SRCPV}'.replace('AUTOINC+', '')}" \
"
