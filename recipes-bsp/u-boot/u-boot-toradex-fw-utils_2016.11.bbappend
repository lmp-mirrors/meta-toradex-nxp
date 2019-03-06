FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRCREV = "02735f400478c6e9afc432fda1149abef630657c"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "2016.11-toradex-next"
SRC_URI += "file://fw_unlock_mmc.sh"

PV = "2016.11+git${SRCPV}"
LOCALVERSION ?= "-${TDX_VER_ITEM}"

S = "${WORKDIR}/git"

install_unlock_emmc() {
    install -d ${D}${sysconfdir}/profile.d/
    install -m 0644 ${WORKDIR}/fw_unlock_mmc.sh ${D}${sysconfdir}/profile.d/fw_unlock_mmc.sh
}

do_install_append_apalis-imx6() {
    install_unlock_emmc
}

do_install_append_colibri-imx6() {
    install_unlock_emmc
}

do_install_append_colibri-imx7-emmc() {
    install_unlock_emmc
}

# defaults
TDX_VER_ITEM ??= "0"
