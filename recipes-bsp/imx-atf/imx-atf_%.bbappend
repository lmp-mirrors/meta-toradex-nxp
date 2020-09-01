PV = "2.2+git${SRCPV}"
SRCBRANCH = "toradex_imx_5.4.24_2.1.0"
SRCREV = "9f183affc0221dac69fa2599ac91b9abad2c4465"
SRCREV_use-head-next = "${AUTOREV}"
SRC_URI = "git://git.toradex.com/imx-atf.git;protocol=https;branch=${SRCBRANCH} \
           file://0001-Allow-BUILD_STRING-to-be-set-in-.revision-file.patch \
"

EXTRA_OEMAKE_append_verdin-imx8mm = " \
    IMX_BOOT_UART_BASE=0x30860000 \
"
