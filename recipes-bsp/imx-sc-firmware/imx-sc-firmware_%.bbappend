FILESEXTRAPATHS_prepend := "${THISDIR}/imx-sc-firmware:"

SRC_URI += " \
     file://mx8qm-apalis-scfw-tcm.bin \
     file://mx8qm-a0-apalis-scfw-tcm.bin \
     file://mx8qx-colibri-scfw-tcm.bin \
"

do_patch[prefuncs] += "do_cp_scfw"
do_cp_scfw () {
    cp ${WORKDIR}/*-scfw-tcm.bin ${S}/
}
