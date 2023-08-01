FILESEXTRAPATHS:prepend := "${THISDIR}/files/:"
SRC_URI:append:tdx = " \
	file://0001-Revert-Add-NXP-s-SoCs-partition-reboot-support.patch \
"

EXTRA_OEMAKE:append:tdx = " \
    BUILD_STRING="${SRCBRANCH}-g${@'${SRCPV}'.replace('AUTOINC+', '')}" \
"
