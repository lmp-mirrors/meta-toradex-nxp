#include conf/tdx_version.conf
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-4.1-2.0.x:"

#LOCALVERSION = "-${PR}"
#PR = "${TDX_VER_INT}"

SRCREV = "b1555bfbf38818bc6fed8d921b55b7b207249c53"
SRCBRANCH = "toradex_4.1-2.0.x-imx"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "toradex_4.1-2.0.x-imx-next"
