# Copyright (C) 2012-2016 Freescale Semiconductor
# Copyright 2017-2018 NXP
# Copyright (C) 2018 O.S. Systems Software LTDA.
SECTION = "base"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=6dfb32a488e5fd6bae52fbf6c7ebb086"

SRCBRANCH ?= "master"
SRC_URI = " \
    ${FSL_MIRROR}/firmware-imx-${PV}.bin;fsl-eula=true \
"

SRC_URI[md5sum] = "b8ae7cdd2a648168f1c90471ca87f6ba"
SRC_URI[sha256sum] = "63ec62f5d229cbed00918c8449173933f1c9d594c59396b8dd217e94f47138b0"

S = "${WORKDIR}/firmware-imx-${PV}"

inherit fsl-eula-unpack
