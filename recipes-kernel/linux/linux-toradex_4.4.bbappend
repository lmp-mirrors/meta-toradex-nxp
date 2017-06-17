include conf/tdx_version.conf

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-4.4:"

LOCALVERSION = "-${PR}"
PR = "${TDX_VER_INT}"

SRCREV = "c1d5fe2d54551b95b812143d94d8168da2220dd8"
SRCBRANCH = "toradex_vf_4.4"
