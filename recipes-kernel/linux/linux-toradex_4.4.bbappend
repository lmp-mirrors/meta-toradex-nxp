include conf/tdx_version.conf

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-4.4:"

LOCALVERSION = "-${PR}"
PR = "${TDX_VER_INT}"

SRCREV = "c9bd85a938f780f586a6522c55e3ca07354bdcb9"
SRCBRANCH = "toradex_vf_4.4-next"
