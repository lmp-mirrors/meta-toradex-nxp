require recipes-bsp/u-boot/u-boot-toradex-env.inc
include conf/tdx_version.conf

LOCALVERSION = "-${TDX_VER_ITEM}"

SRCREV = "5c2d46b32533cd873c7d821d9842905c9ef48765"
SRCBRANCH = "2016.11-toradex"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "2016.11-toradex-next"

