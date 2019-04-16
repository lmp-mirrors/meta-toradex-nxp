require recipes-kernel/linux/linux-toradex_4.9-2.3.x.bb
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-rt-4.9-2.3.x:"

SUMMARY = "Real-Time Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI += " \
    file://revert_aio_fix_spectre_gadget_in_lookup_ioctx.patch \
    file://revert_futex_ensure_that_futex_address_is_aligned_in_handle_futex_death.patch \
    file://revert_futex_rt_mutex_restructure_rt_mutex_finish_proxy_lock.patch \
    https://www.kernel.org/pub/linux/kernel/projects/rt/4.9/older/patch-4.9.146-rt125.patch.xz;name=rt-patch \
    file://0002-mm-Work-around-the-oops-below-by-disabling-split-ptl.patch \
"

SRC_URI[rt-patch.md5sum] = "b7869d612f2572191ed45c796bde7abe"
SRC_URI[rt-patch.sha256sum] = "925106e44f4bd5213bd38d29bcc0cfdda670fca20600357b15ac576d286ab445"

SRCREV = "d899927728beca8357a5b4120b690cb3c1d80844"
SRCBRANCH = "toradex_4.9-2.3.x-imx"
