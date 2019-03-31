require recipes-bsp/u-boot/u-boot-toradex-env.inc

LOCALVERSION = "-${TDX_VER_ITEM}"

SRCREV = "83a53c1c0c6fd813bd655b4f88fd07bf798e11d7"
SRCBRANCH = "2016.11-toradex"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "2016.11-toradex-next"

# defaults
TDX_VER_ITEM ??= "0"
