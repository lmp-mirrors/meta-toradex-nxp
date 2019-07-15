require recipes-bsp/u-boot/u-boot-toradex-env.inc

LOCALVERSION = "-${TDX_VER_ITEM}"

SRCREV = "a26e924efbf998711f56911ddd8419f95eca09b9"
SRCBRANCH = "2016.11-toradex"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "2016.11-toradex-next"

# defaults
TDX_VER_ITEM ??= "0"
