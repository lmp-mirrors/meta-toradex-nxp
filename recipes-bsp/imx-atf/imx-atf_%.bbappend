FILESEXTRAPATHS:prepend := "${THISDIR}/files/:"
ATF_SYS_PWR_FULL_CTRL ?= "0"
EXTRA_OEMAKE += 'SYS_PWR_FULL_CTRL=${ATF_SYS_PWR_FULL_CTRL}'
SRC_URI:append:tdx = " \
	file://0001-Revert-Add-NXP-s-SoCs-partition-reboot-support.patch \
	file://0001-feat-imx9-add-full-system-power-control-option.patch \
"
