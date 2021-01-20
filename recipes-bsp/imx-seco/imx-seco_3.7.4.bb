# Copyright 2019-2020 NXP

SUMMARY = "NXP i.MX SECO firmware"
DESCRIPTION = "NXP IMX SECO firmware"
SECTION = "base"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=cf3f9b8d09bc3926b1004ea71f7a248a"
FSL_EULA_FILE_MD5SUM_LA_OPT_NXP_SOFTWARE_LICENSE_V17 = "cf3f9b8d09bc3926b1004ea71f7a248a"
FSL_EULA_FILE_MD5SUMS_append = " \
    ${FSL_EULA_FILE_MD5SUM_LA_OPT_NXP_SOFTWARE_LICENSE_V17} \
"

inherit fsl-eula-unpack deploy

SRC_URI = "${FSL_MIRROR}/${BP}.bin;fsl-eula=true"

SRC_URI[md5sum] = "f0e20216f27f2f44ac809634c5291be5"
SRC_URI[sha256sum] = "2ed8177e48c8e33f742b3a642805be56a5ef56df78b1b29e10518552154da2bc"

do_compile[noexec] = "1"

do_install[noexec] = "1"

SECO_CHIP ?= "UNSUPPORTED"
SECO_CHIP_mx8qm ?= "qmb0"
SECO_CHIP_mx8qxp = "qxb0"
SECO_CHIP_mx8qxpc0 = "qxc0"
SECO_FIRMWARE_NAME_mx8phantomdxl = "qxb0"
SECO_FIRMWARE_NAME_mx8dxl        = "dxla0"

SECO_FIRMWARE_NAME = "mx8${SECO_CHIP}-ahab-container.img"

addtask deploy after do_install
do_deploy () {
    # Deploy i.MX8 SECO firmware files
    install -m 0644 ${S}/firmware/seco/${SECO_FIRMWARE_NAME} ${DEPLOYDIR}
}


COMPATIBLE_MACHINE = "(mx8)"
COMPATIBLE_MACHINE_mx8m = "(^$)"
