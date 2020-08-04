# get additional scfw binaries provided in:
SCFW_TDX_SRC ?= "git://github.com/toradex/i.MX-System-Controller-Firmware.git"

SRC_URI += "${SCFW_TDX_SRC};branch=master;protocol=https;fsl-eula=true"

SRCREV = "1f184f12405d681d23b77cf5bac66110b9d34ddf"
SRCREV_use-head-next = "${AUTOREV}"

do_patch[prefuncs] += "do_cp_scfw"
do_cp_scfw () {
	cp ${WORKDIR}/git/src/scfw_export_*/build_*/*-scfw-tcm.bin ${S}/
}

# get the matching SCFW for NXP's boards for the 5.4.24-2.1.0 BSP
PV = "1.5.0"
SRC_URI[md5sum] = "e939f40ca655afbdedabfae73863e6da"
SRC_URI[sha256sum] = "18ef3717180ef034c1a3418d7342803f2727e4e09531e0a5db13e6f5244f2058"
LIC_FILES_CHKSUM = "file://COPYING;md5=228c72f2a91452b8a03c4cab30f30ef9"
