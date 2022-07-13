FILESEXTRAPATHS:prepend := "${THISDIR}/files/:"
SRC_URI:append:tdx = " \
	file://0001-Revert-Add-NXP-s-SoCs-partition-reboot-support.patch \
	file://0002-imx8m-hab.c-work-around-gcc-12.1-false-positives.patch \
"

EXTRA_OEMAKE:append:tdx = " \
    BUILD_STRING="${SRCBRANCH}-g${@'${SRCPV}'.replace('AUTOINC+', '')}" \
"
EXTRA_OEMAKE:append:verdin-imx8mm = " \
    IMX_BOOT_UART_BASE=0x30860000 \
"
EXTRA_OEMAKE:append:verdin-imx8mp = " \
    IMX_BOOT_UART_BASE=0x30880000 \
"
