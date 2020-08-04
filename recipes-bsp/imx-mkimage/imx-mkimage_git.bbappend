SRCBRANCH = "imx_5.4.24_2.1.0"
SRCREV = "6745ccdcf15384891639b7ced3aa6ce938682365"

REV_CHIP ?= "B0"
REV_CHIP_mx8qxpc0 = "C0"

do_compile () {
    cd ${S}
    oe_runmake clean
    oe_runmake bin
    oe_runmake -C iMX8M -f soc.mak mkimage_imx8
    oe_runmake -C iMX8QM REV=${REV_CHIP} -f soc.mak imx8qm_dcd.cfg.tmp
    oe_runmake -C iMX8QX REV=${REV_CHIP} -f soc.mak imx8qx_dcd.cfg.tmp
}
