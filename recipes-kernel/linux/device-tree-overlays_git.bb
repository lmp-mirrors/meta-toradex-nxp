inherit toradex-devicetree

SRCBRANCH = "toradex_5.4-2.3.x-imx"
SRCREV = "eb56c932d1bbd7cbc6005f484cd1977e840ace17"
SRCREV_use-head-next = "${AUTOREV}"

# we have dtbo's in arm and arm64 architecture, set the include paths
# to include both architectures.
KERNEL_INCLUDE = " \
    ${STAGING_KERNEL_DIR}/arch/arm/boot/dts \
    ${STAGING_KERNEL_DIR}/arch/arm/boot/dts*/* \
    ${STAGING_KERNEL_DIR}/arch/arm64/boot/dts \
    ${STAGING_KERNEL_DIR}/arch/arm64/boot/dts/* \
    ${STAGING_KERNEL_DIR}/scripts/dtc/include-prefixes \
"

COMPATIBLE_MACHINE = ".*(mx[678]).*"
