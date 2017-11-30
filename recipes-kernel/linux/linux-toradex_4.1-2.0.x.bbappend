#include conf/tdx_version.conf
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-4.1-2.0.x:"

#LOCALVERSION = "-${PR}"
#PR = "${TDX_VER_INT}"

SRCREV = "18717e2b1ca9b0fbf8bafa2717719e1f2c8f1114"
SRCBRANCH = "toradex_4.1-2.0.x-imx"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "toradex_4.1-2.0.x-imx-next"
