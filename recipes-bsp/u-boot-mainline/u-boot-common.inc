HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"
DEPENDS += "flex-native bison-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
PE = "1"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "77f6e2dd0551d8a825bab391a1bd6b838874bcd4"

SRC_URI = "git://git.denx.de/u-boot.git"

# patches in flight
SRC_URI += " \
    file://0001-usb-limit-USB_MAX_XFER_BLK-to-256.patch \
    file://0002-misc-imx8-add-sc_misc_get_temp.patch \
    file://0003-thermal-add-i.MX8-thermal-driver.patch \
    file://0004-imx-imx8dx-qxp-enable-thermal.patch \
    file://0005-misc-imx8-add-sc_rm_set_master_sid.patch \
    file://0006-MLK-14938-8-imx8-Add-SMMU-setup-to-Soc-codes.patch \
    file://0007-apalis-imx8-enable-smmu-setup.patch \
    file://0008-MLK-16087-imx8qm-qxp-Disable-kernel-FDT-nodes-for-th.patch \
    file://0009-MLK-16560-1-imx8-Configure-sids-based-on-iommu-prope.patch \
    file://0010-apalis-imx8-enable-of_system_setup.patch \
    file://0011-MLK-17205-1-video-imx-hdp-Adding-support-for-HDP-fir.patch \
    file://0012-MLK-17205-2-video-imx-hdp-Adding-HDP-firmware-loadin.patch \
    file://0013-MLK-17205-3-video-imx-hdp-Adding-configs-for-HDP-fir.patch \
    file://0014-apalis-imx8-enable-hdp-firmware-loading.patch \
    \
    file://0001-imx8-cpu-fix-warning-for-cpu_imx_get_temp.patch \
    file://0002-video-fsl_dcu_fb-refactor-init-functions.patch \
    file://0003-video-fsl_dcu_fb-add-DM_VIDEO-support.patch \
    file://0004-ARM-dts-colibri_vf-Add-dcu0-node.patch \
    file://0005-colibri_vf-enable-DM_VIDEO.patch \
    file://0006-colibri-apalis-tegra-drop-DFU-support.patch \
    file://0007-colibri-apalis-imx-drop-DFU-support.patch \
    \
    file://0001-video-mxsfb-fix-mxsfb-fbdev-binding-issues.patch \
    file://0002-ARM-dts-colibri_imx7-Fix-lcdif-node-definition.patch \
    file://0003-configs-colibri_imx7-enable-DM_VIDEO.patch \
    file://0004-colibri-imx6ull-support-building-with-DM_VIDEO-y.patch \
    file://0005-ARM-dts-colibri-imx6ull-extend-lcdif-node.patch \
    file://0006-configs-colibri-imx6ull-switch-to-DM_VIDEO.patch \
"

S = "${WORKDIR}/git"
