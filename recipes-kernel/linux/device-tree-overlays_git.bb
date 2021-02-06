SUMMARY = "Toradex BSP device tree overlays"
DESCRIPTION = "Toradex BSP device tree overlays from within layer."

SRC_URI = "git://git.toradex.com/device-tree-overlays.git;branch=${SRCBRANCH};protocol=https"

SRCBRANCH = "toradex_5.4-2.3.x-imx"

SRCREV = "3079c64e090a583f316bf802d1d26298d0b2fcc5"
SRCREV_use-head-next = "${AUTOREV}"

PV = "${SRCBRANCH}+git${SRCPV}"

inherit devicetree

S = "${WORKDIR}/git/overlays"

COMPATIBLE_MACHINE = ".*(mx[678]).*"

# we have dtbo's in arm and arm64 architecture, set the include paths
# to include both architectures.
KERNEL_INCLUDE = " \
    ${STAGING_KERNEL_DIR}/arch/arm/boot/dts \
    ${STAGING_KERNEL_DIR}/arch/arm/boot/dts*/* \
    ${STAGING_KERNEL_DIR}/arch/arm64/boot/dts \
    ${STAGING_KERNEL_DIR}/arch/arm64/boot/dts/* \
    ${STAGING_KERNEL_DIR}/scripts/dtc/include-prefixes \
"
