require recipes-bsp/u-boot/u-boot-toradex-env.inc
include conf/tdx_version.conf

LOCALVERSION = "-${TDX_VER_ITEM}"

SRCREV = "0ed64e49e556096972e0a85e8f4db287b4ed9bdc"
SRCBRANCH = "2016.11-toradex"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "2016.11-toradex-next"

