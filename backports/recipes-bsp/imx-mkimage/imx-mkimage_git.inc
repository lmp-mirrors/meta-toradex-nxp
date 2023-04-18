# Copyright 2017-2020 NXP

DEPENDS = "zlib-native openssl-native"

SRCBRANCH = "imx_5.4.70_2.3.0"
SRC_URI = "git://github.com/nxp-imx/imx-mkimage.git;protocol=https;branch=${SRCBRANCH} \
           file://0001-mkimage_fit_atf-fix-fit-generator-node-naming.patch \
           file://0001-iMX8M-soc.mak-use-native-mkimage-from-sysroot.patch \
"

SRCREV = "6a315dbc608f90d630bf34024679f682054a5bea"
S = "${WORKDIR}/git"

BOOT_TOOLS = "imx-boot-tools"
SYSROOT_DIRS += "/boot"
