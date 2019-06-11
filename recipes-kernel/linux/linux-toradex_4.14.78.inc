# Copyright 2017-2018 NXP
# Copyright 2018 Toradex AG
# Released under the MIT license (see COPYING.MIT for the terms)

LOCALVERSION = "-${TDX_VER_ITEM}"

KERNEL_SRC ?= "git://git.toradex.com/linux-toradex.git;protocol=https"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"

SRCREV = "0234542c934563959a9272f57bb5c13c5774beaa"
SRCBRANCH = "toradex_imx_4.14.78_1.0.0_ga-bring_up"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "toradex_imx_4.14.78_1.0.0_ga-bring_up"
