SCFW_TDX_SRC ?= "git://github.com/toradex/i.MX-System-Controller-Firmware.git"

SRC_URI += "${SCFW_TDX_SRC};branch=master;protocol=https;fsl-eula=true"

SRCREV = "7400edfa2a94be81693b3411dd0cfd9d01449e77"
SRCREV_use-head-next = "${AUTOREV}"

do_patch[prefuncs] += "do_cp_scfw"
do_cp_scfw () {
	cp ${WORKDIR}/git/src/scfw_export_*/build_*/*-scfw-tcm.bin ${S}/
}
