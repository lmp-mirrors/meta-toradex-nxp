inherit toradex-devicetree

SRCBRANCH = "toradex_6.6-2.2.x-imx"
SRCREV = "ae5a494c9f04b77b058d4a5bfa9eb09eeaa4d7de"
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

COMPATIBLE_MACHINE = ".*(mx[6789]).*"
