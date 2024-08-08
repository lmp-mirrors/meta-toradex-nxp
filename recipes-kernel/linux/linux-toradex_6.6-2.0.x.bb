require linux-toradex.inc

LINUX_VERSION = "6.6.23"
SRCBRANCH = "toradex_6.6-2.0.x-imx"
SRCREV_machine = "2a6bf0a9a4064ebb85956d658121e918bd6aeeb1"
SRCREV_machine:use-head-next = "${AUTOREV}"

