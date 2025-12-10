inherit toradex-devicetree

SRCBRANCH = "toradex_6.12-2.0.x-imx"
SRCREV = "12c1b68718d79d89f68f863942d85c45551c3add"
SRCREV:use-head-next = "${AUTOREV}"

# we have dtbo's in arm and arm64 architecture, set the include paths
# to include both architectures.
KERNEL_INCLUDE = " \
    ${STAGING_KERNEL_DIR}/arch/arm/boot/dts \
    ${STAGING_KERNEL_DIR}/arch/arm/boot/dts*/* \
    ${STAGING_KERNEL_DIR}/arch/arm64/boot/dts \
    ${STAGING_KERNEL_DIR}/arch/arm64/boot/dts/* \
    ${STAGING_KERNEL_DIR}/scripts/dtc/include-prefixes \
"

COMPATIBLE_MACHINE = "(mx8-nxp-bsp|mx9-nxp-bsp)"
