require recipes-kernel/linux/linux-toradex_4.14-2.0.x.bb
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-rt-4.14-2.0.x:"

SUMMARY = "Real-Time Linux kernel for Toradex Freescale i.MX based modules"

# patches get moved into the 'older' directory when superseeded, so provide
# both possible storage locations.
MIRRORS += "${KERNELORG_MIRROR}/linux/kernel/projects/rt/4.14/older/ ${KERNELORG_MIRROR}/linux/kernel/projects/rt/4.14/"
SRC_URI += " \
    file://0001-sources-prepare-for-rt-patch.patch \
    ${KERNELORG_MIRROR}/linux/kernel/projects/rt/4.14/older/patch-4.14.155-rt70.patch.xz;name=rt-patch \
    file://0003-Revert-sources-prepare-for-rt-patch.patch \
    file://0001-imx_sc_thermal-prevent-BUG-with-rt-patch.patch \
    file://0002-ddr-perf-prevent-BUG-with-rt-patch.patch \
"

SRC_URI[rt-patch.md5sum] = "39e7b169bd4d8dc9eb6690575c6582ed"
SRC_URI[rt-patch.sha256sum] = "5220a902427063cd428208d8df7181d36677a6f7cf7908bb66cc2031c6257686"
