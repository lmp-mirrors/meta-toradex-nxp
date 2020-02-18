require recipes-kernel/linux/linux-toradex_4.14-2.3.x.bb
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-rt-4.14-2.3.x:"

SUMMARY = "Real-Time Linux kernel for Toradex Freescale i.MX based modules"

# patches get moved into the 'older' directory when superseeded, so provide
# both possible storage locations.
MIRRORS += "${KERNELORG_MIRROR}/linux/kernel/projects/rt/4.14/older/ ${KERNELORG_MIRROR}/linux/kernel/projects/rt/4.14/"
SRC_URI += " \
    ${KERNELORG_MIRROR}/linux/kernel/projects/rt/4.14/older/patch-4.14.170-rt74.patch.xz;name=rt-patch \
    file://0001-imx_sc_thermal-prevent-BUG-with-rt-patch.patch \
    file://0002-ddr-perf-prevent-BUG-with-rt-patch.patch \
"

SRC_URI[rt-patch.md5sum] = "8e8f522f820f34f64098cbaf77acaa71"
SRC_URI[rt-patch.sha256sum] = "ad070f4076e82c268538a05c7beb8970db8dd4b4ee2bcf22c3d2aa44e89a5f0a"
