include conf/tdx_version.conf

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-4.4:"

LOCALVERSION = "-${TDX_VER_ITEM}"

SRCREV = "c2be367662f77746eeeb21bb5ea9ed275551ffd1"
SRCBRANCH = "toradex_vf_4.4"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "toradex_vf_4.4-next"
