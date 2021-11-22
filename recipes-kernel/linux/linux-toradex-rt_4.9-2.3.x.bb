require recipes-kernel/linux/linux-toradex_4.9-2.3.x.bb
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-rt-4.9-2.3.x:"

SUMMARY = "Real-Time Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI += " \
    https://www.kernel.org/pub/linux/kernel/projects/rt/4.9/older/patch-4.9.220-rt143.patch.xz;name=rt-patch \
    file://0001-ARM-imx6-cpuidle-Use-raw_spinlock_t.patch \
    file://0002-mm-Work-around-the-oops-below-by-disabling-split-ptl.patch \
"

SRC_URI[rt-patch.md5sum] = "dc00267b39b9b257ca7b5252e7389840"
SRC_URI[rt-patch.sha256sum] = "ce42db14bce8afabf84babbb60db662b839e497cecd9a0559d3fc0566ff3d282"

SRCREV = "93458a0ecf099f1fe74abebdc601923b02dcfff6"
SRCBRANCH = "toradex_4.9-2.3.x-imx"
