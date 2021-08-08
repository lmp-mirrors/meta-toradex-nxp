PV = "2.2+git${SRCPV}"
SRCBRANCH = "toradex_imx_5.4.70_2.3.0"
SRCREV = "835a8f67b2ca7aa3f2d05d6e6a1a51f7e1147266"
SRCREV_use-head-next = "${AUTOREV}"
SRC_URI = "git://git.toradex.com/imx-atf.git;protocol=https;branch=${SRCBRANCH}"

EXTRA_OEMAKE:append = " \
    BUILD_STRING="${SRCBRANCH}-g${@'${SRCPV}'.replace('AUTOINC+', '')}" \
"
EXTRA_OEMAKE:append:verdin-imx8mm = " \
    IMX_BOOT_UART_BASE=0x30860000 \
"
EXTRA_OEMAKE:append:verdin-imx8mp = " \
    IMX_BOOT_UART_BASE=0x30880000 \
"
