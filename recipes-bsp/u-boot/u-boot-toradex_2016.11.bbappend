require recipes-bsp/u-boot/u-boot-toradex-env.inc

LOCALVERSION = "-${TDX_VER_ITEM}"

SRCREV = "72e849dcfa4aa883589ae38a068d8e443c73837a"
SRCBRANCH = "2016.11-toradex"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "2016.11-toradex-next"

# defaults
TDX_VER_ITEM ??= "0"
