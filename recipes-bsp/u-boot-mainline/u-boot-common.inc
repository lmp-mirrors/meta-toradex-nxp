HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"
DEPENDS += "flex-native bison-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
PE = "1"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "b4ee6daad7a2604ca9466b2ba48de86cc27d381f"

SRC_URI = "git://git.denx.de/u-boot.git"

SRC_URI += " \
    file://0001-imx-Use-a-convenient-default-value-for-SYS_MALLOC_F_.patch \
    file://0003-usb-limit-USB_MAX_XFER_BLK-to-256.patch \
    file://0004-apalis_imx6-add-device-tree-to-makefile.patch \
    file://0005-colibri-imx6ull-fix-usb-host-mode.patch \
    file://0006-net-fec_mxc-not-access-reserved-register-on-i.MX8.patch \
    file://0007-imx-fix-building-for-i.mx8-without-spl.patch \
    file://0008-board-toradex-add-colibri-imx8qxp-2gb-wb-it-v1.0b-mo.patch \
    file://0009-board-toradex-drop-support.arm-maintainer-email.patch \
    file://0010-misc-imx8-add-sc_misc_get_temp.patch \
    file://0011-thermal-add-i.MX8-thermal-driver.patch \
    file://0012-imx8-cpu-get-temperature-when-print-cpu-desc.patch \
    file://0013-imx-imx8dx-qxp-enable-thermal.patch \
    file://0014-arm-dts-imx8qm-add-lpuart1-lpuart2-lpuart3-lpuart4.patch \
    file://0015-arm-dts-imx8qm-add-support-for-i2c0-i2c1-i2c2-i2c3-a.patch \
    file://0016-clk-imx8qm-fix-usdhc2-clocks.patch \
    file://0017-imx8qm-fix-cpu-frequency-reporting.patch \
    file://0018-imx8-fuse-fix-fuse-driver.patch \
    file://0019-board-toradex-add-apalis-imx8qm-4gb-wb-it-v1.0b-modu.patch \
"
S = "${WORKDIR}/git"
