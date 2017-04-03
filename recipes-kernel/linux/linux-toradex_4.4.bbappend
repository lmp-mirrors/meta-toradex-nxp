include conf/tdx_version.conf

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-4.4:"

LOCALVERSION = "-${PR}"
PR = "${TDX_VER_INT}"

SRCREV = "7cfa3211be32063f41fc49573c6047f96d47c841"
SRCBRANCH = "toradex_vf_4.4"
