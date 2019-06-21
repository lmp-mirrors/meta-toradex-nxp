ATF_MACHINE_NAME_mx8qxp = "bl31-imx8qx.bin"
SRCBRANCH = "imx_4.14.98_2.0.0_ga"
SRCREV = "dd0234001713623c79be92b60fa88bc07b07f24f"

deploy_mx8() {
    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0644 ${BOOT_STAGING}/mx8qm-ahab-container.img ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0755 ${S}/${TOOLS_NAME}                       ${DEPLOYDIR}/${BOOT_TOOLS}
}
deploy_mx8x() {
    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0644 ${BOOT_STAGING}/mx8qx-ahab-container.img ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0755 ${S}/${TOOLS_NAME}                       ${DEPLOYDIR}/${BOOT_TOOLS}
}
