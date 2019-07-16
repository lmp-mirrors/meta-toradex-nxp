LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

UBOOT_SRC ?= "git://git.toradex.com/u-boot-toradex.git;protocol=https"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"

SRCREV = "25f68add54118b931df462333d869da4a21ef774"
SRCBRANCH = "toradex_imx_v2018.03_4.14.78_1.0.0_ga-bringup"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "toradex_imx_v2018.03_4.14.78_1.0.0_ga-bringup"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

LOCALVERSION ?= "-${SRCBRANCH}"

COMPATIBLE_MACHINE = "(mx8)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
