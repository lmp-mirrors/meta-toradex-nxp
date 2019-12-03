require recipes-kernel/linux/linux-toradex_4.14-2.0.x.bb
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-rt-4.14-2.0.x:"

SUMMARY = "Real-Time Linux kernel for Toradex Freescale i.MX based modules"

# patches get moved into the 'older' directory when superseeded, so provide
# both possible storage locations.
MIRRORS += "${KERNELORG_MIRROR}/linux/kernel/projects/rt/4.14/older/ ${KERNELORG_MIRROR}/linux/kernel/projects/rt/4.14/"
SRC_URI += " \
    ${KERNELORG_MIRROR}/linux/kernel/projects/rt/4.14/older/patch-4.14.126-rt62.patch.xz;name=rt-patch \
    file://0001-imx_sc_thermal-prevent-BUG-with-rt-patch.patch \
    file://0002-ddr-perf-prevent-BUG-with-rt-patch.patch \
"

SRC_URI[rt-patch.md5sum] = "47f2bb663112711d7270902e7e42cd16"
SRC_URI[rt-patch.sha256sum] = "496d2e788eb878c828dedda35e1def95c3e922ed4f010593fb8f0fcc523834ff"
