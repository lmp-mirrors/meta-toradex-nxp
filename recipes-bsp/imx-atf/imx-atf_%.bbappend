PV = "2.2+git${SRCPV}"
SRCBRANCH = "toradex_imx_5.4.24_2.1.0"
SRCREV = "8565561292a82a7d3da9c31694def4db426085b7"
SRCREV_use-head-next = "${AUTOREV}"
SRC_URI = "git://git.toradex.com/imx-atf.git;protocol=https;branch=${SRCBRANCH}"

EXTRA_OEMAKE_append_verdin-imx8mm = " \
    IMX_BOOT_UART_BASE=0x30860000 \
"
