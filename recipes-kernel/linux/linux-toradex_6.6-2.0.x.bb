FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"
require linux-toradex.inc

SRC_URI:append = " \
    file://nxp-imx.cfg \
"

LINUX_VERSION = "6.6.23"
SRCBRANCH = "toradex_6.6-2.0.x-imx"
SRCREV_machine = "5545cedda0e3b4e7282069d74a94db292b0c0eb6"
SRCREV_machine:use-head-next = "${AUTOREV}"
