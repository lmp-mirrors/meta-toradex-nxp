include conf/tdx_version.conf

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-4.4:"

LOCALVERSION = "-${PR}"
PR = "${TDX_VER_INT}"

SRCREV = "e0f2806138a4eeb3c31abe0e0e767d0f6d9a13a3"
SRCBRANCH = "toradex_vf_4.4"
