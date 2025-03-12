LICENSE:tdx = "BSD-3-Clause"
LIC_FILES_CHKSUM:tdx = "file://LICENSE.txt;md5=b66f32a90f9577a5a3255c21d79bc619"

IMX_OEI_SRC:tdx = "git://git.toradex.com/imx-oei-toradex.git;protocol=https"
SRCBRANCH:tdx = "main"
SRCREV:tdx = "${AUTOREV}"

# Disable debug prints
EXTRA_OEMAKE:remove = "DEBUG=1"
