PV = "1.5.0+git${SRCPV}"
SRCBRANCH = "imx_4.14.78_1.0.0_ga"
SRCREV = "d6451cc1e162eff89b03dd63e86d55b9baa8885b"

PLATFORM_mx8qxp  = "imx8qxp"

# imx-atf 1.5 uses bl31-imx8qxp.bin, 2.0 will use bl31-imx8qx.bin for a
# platform specific filename. Provide both for now, so that the user of
# the file need not care.
do_deploy_append_mx8qxp () {
    install -Dm 0644 ${S}/build/${PLATFORM}/release/bl31.bin ${DEPLOYDIR}/${BOOT_TOOLS}/bl31-imx8qx.bin
}
