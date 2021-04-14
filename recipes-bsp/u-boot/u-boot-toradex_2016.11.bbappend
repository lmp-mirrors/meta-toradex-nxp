require recipes-bsp/u-boot/u-boot-toradex-env.inc

LOCALVERSION = "-${TDX_VER_ITEM}"

SRCREV = "1e8dc5e388e692e657c4cfb4a883b73cde9997bc"
SRCBRANCH = "2016.11-toradex"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "2016.11-toradex-next"

# defaults
TDX_VER_ITEM ??= "0"
