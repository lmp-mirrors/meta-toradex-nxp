SCFW_TDX_SRC ?= "git://github.com/toradex/i.MX-System-Controller-Firmware.git"

SRC_URI += "${SCFW_TDX_SRC};branch=master;protocol=https"

SRCREV = "38b48d5b308c8ca97677ebba075acc94bc71e0ce"

do_patch[prefuncs] += "do_cp_scfw"
do_cp_scfw () {
	cp ${WORKDIR}/git/src/scfw_export_*/build_*/*-scfw-tcm.bin ${S}/
}
