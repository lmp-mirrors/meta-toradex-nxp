SUMMARY = "i.MX Optional Execution Image for Toradex Hardware"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b66f32a90f9577a5a3255c21d79bc619"

SRC_URI = "${IMX_OEI_SRC};branch=${SRCBRANCH}"
IMX_OEI_SRC ?= "git://git.toradex.com/imx-oei-toradex.git;protocol=https"
SRCBRANCH = "main"
SRCREV = "0e079ed04cd95846866b004b247b9da3b0cc8742"
SRCREV:use-head-next = "${AUTOREV}"

require dynamic-layers/arm-toolchain/recipes-bsp/imx-oei/imx-oei.inc
