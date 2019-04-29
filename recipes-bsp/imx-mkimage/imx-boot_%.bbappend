SRCBRANCH = "imx_4.14.78_1.0.0_ga"
SRCREV = "2cf091c075ea1950afa22a56e224dc4e448db542"

# Cope with i.MX8 / i.MX8X A0 Silicon DCD name
DCD_NAME_mx8qma0 = "imx8qm_dcd.cfg.tmp"
DCD_COPY = "false"
DCD_COPY_mx8qma0 = "true"

deploy_mx8() {
    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
    if [ "${DCD_COPY}" = "true" ]; then
        install -m 0644 ${BOOT_STAGING}/${DCD_NAME}              ${DEPLOYDIR}/${BOOT_TOOLS}
    fi
    install -m 0644 ${BOOT_STAGING}/mx8qm-ahab-container.img ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0755 ${S}/${TOOLS_NAME}                       ${DEPLOYDIR}/${BOOT_TOOLS}
}
deploy_mx8x() {
    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0644 ${BOOT_STAGING}/mx8qx-ahab-container.img ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0755 ${S}/${TOOLS_NAME}                       ${DEPLOYDIR}/${BOOT_TOOLS}
}
