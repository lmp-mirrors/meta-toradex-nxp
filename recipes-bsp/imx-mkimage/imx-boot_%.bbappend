SRCBRANCH = "imx_4.14.78_1.0.0_ga"
SRCREV = "2cf091c075ea1950afa22a56e224dc4e448db542"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += " \
    file://0001-add-board-support-for-DCD-memory-timings.patch \
    file://0002-add-memory-timings-for-Apalis-iMX8.patch \
"

# Cope with i.MX8 / i.MX8X A0 Silicon DCD name
DCD_NAME_mx8qma0 = "imx8qm_*dcd.cfg.tmp"
export DCD_BOARD = "apalis-imx8"
DCD_COPY = "false"
DCD_COPY_mx8qma0 = "true"

deploy_mx8() {
    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
    if [ "${DCD_COPY}" = "true" ]; then
        install -m 0644 ${BOOT_STAGING}/${DCD_NAME}          ${DEPLOYDIR}/${BOOT_TOOLS}
    fi
    install -m 0644 ${BOOT_STAGING}/mx8qm-ahab-container.img ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0755 ${S}/${TOOLS_NAME}                       ${DEPLOYDIR}/${BOOT_TOOLS}
}
deploy_mx8x() {
    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0644 ${BOOT_STAGING}/mx8qx-ahab-container.img ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0755 ${S}/${TOOLS_NAME}                       ${DEPLOYDIR}/${BOOT_TOOLS}
}
