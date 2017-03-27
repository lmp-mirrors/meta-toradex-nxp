SUMMARY = "U-boot bootloader fw_printenv/setenv utils"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"
SECTION = "bootloader"
PROVIDES = "u-boot-fw-utils"
RPROVIDES_${PN} = "u-boot-fw-utils"
DEPENDS = "mtd-utils"

include conf/tdx_version.conf

COMPATIBLE_MACHINE = "(apalis-imx6|colibri-imx6|colibri-imx7|colibri-vf)"
DEFAULT_PREFERENCE_apalis-imx6 = "1"
DEFAULT_PREFERENCE_colibri-imx6 = "1"
DEFAULT_PREFERENCE_colibri-imx7 = "1"
DEFAULT_PREFERENCE_colibri-vf = "1"

FILESPATHPKG =. "git:"

SRCREV = "c77a50386f672d6846df1a20295129fb66044779"
SRCBRANCH = "2016.11-toradex-next"
SRC_URI = " \
    git://git.toradex.com/u-boot-toradex.git;protocol=git;branch=${SRCBRANCH} \
    file://fw_env.config \
"
SRC_URI_append_mx6 = " file://fw_unlock_mmc.sh "

PV = "2016.11"
PR = "${TDX_VER_INT}-gitr${@d.getVar("SRCREV", False)[0:7]}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CC="${CC}" STRIP="${STRIP}"'

INSANE_SKIP_${PN} = "already-stripped ldflags"

inherit pkgconfig uboot-config

do_compile () {
    oe_runmake ${UBOOT_MACHINE}
    oe_runmake env
}

do_install () {
    install -d ${D}${base_sbindir} ${D}${sysconfdir}
    install -m 755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_printenv
    ln -s fw_printenv ${D}${base_sbindir}/fw_setenv
    install -m 644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/
}

do_install_append_mx6() {
    install -d ${D}${sysconfdir}/profile.d/
    install -m 0644 ${WORKDIR}/fw_unlock_mmc.sh ${D}${sysconfdir}/profile.d/fw_unlock_mmc.sh
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
