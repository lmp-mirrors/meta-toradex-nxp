SECTION = "USB"
SUMMARY = "Fix for USB suspend resume on Vybrid"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PR = "r1"

inherit allarch systemd

SRC_URI = " \
    file://usb-suspend.sh \
    file://usb-resume.sh \
    file://usb-suspend.service \
    file://usb-resume.service \
"

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${WORKDIR}/usb-suspend.sh ${D}/${bindir}/
    install -m 0755 ${WORKDIR}/usb-resume.sh ${D}/${bindir}/

    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/usb-suspend.service ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/usb-resume.service ${D}${systemd_unitdir}/system
}

FILES_${PN} += " \
    ${systemd_unitdir}/system \
"

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "usb-suspend.service usb-resume.service"
SYSTEMD_AUTO_ENABLE_vf = "enable"
SYSTEMD_AUTO_ENABLE = "disable"
