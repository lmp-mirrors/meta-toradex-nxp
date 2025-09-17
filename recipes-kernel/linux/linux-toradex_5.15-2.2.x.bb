FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"
require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"
SUMMARY:preempt-rt = "Real-Time Linux kernel for Toradex Freescale i.MX based modules"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRC_URI = " \
    git://git.toradex.com/linux-toradex.git;protocol=https;branch=${SRCBRANCH};name=machine \
"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

inherit toradex-kernel-deploy-config toradex-kernel-localversion
LINUX_VERSION = "5.15.191"
# skip, as with use-head-next LINUX_VERSION might be set wrongly
KERNEL_VERSION_SANITY_SKIP = "1"

SRCBRANCH = "toradex_5.15-2.2.x-imx"
SRCREV_machine = "88e9f1ec02f87bb86c41152f0b18eec78d0fbfeb"
SRCREV_machine:use-head-next = "${AUTOREV}"

def get_linux_base_version(d):
    linux_version = d.getVar('LINUX_VERSION')
    if '-rt' in linux_version:
        return linux_version.split('-rt')[0]
    return linux_version

CVE_VERSION = "${@get_linux_base_version(d)}"

DEPENDS += "bc-native"
COMPATIBLE_MACHINE = "mx8-nxp-bsp"

KBUILD_DEFCONFIG:mx8-nxp-bsp ?= "toradex_defconfig"

export DTC_FLAGS = "-@"

###############################################################################
# Apply the RT patch and change the configuration to use PREMPT_RT when the
# preempt-rt override is set.
###############################################################################

# patches get moved into the 'older' directory when superseeded, so provide
# both possible storage locations.
MIRRORS:append:preempt-rt = "${KERNELORG_MIRROR}/linux/kernel/projects/rt/5.15/older/ ${KERNELORG_MIRROR}/linux/kernel/projects/rt/5.15/"
SRC_URI:append:preempt-rt = " \
    file://0001-Revert-Revert-ARM-9113-1-uaccess-remove-set_fs-imple.patch \
    file://0002-arch-arm-Kconfig-prepare-for-rt-patch.patch \
    ${KERNELORG_MIRROR}/linux/kernel/projects/rt/5.15/older/patch-5.15.191-rt88.patch.xz;name=rt-patch \
    file://0004-Revert-arch-arm-Kconfig-prepare-for-rt-patch.patch \
    file://0005-Revert-Revert-Revert-ARM-9113-1-uaccess-remove-set_f.patch \
    file://preempt-rt.scc \
    file://preempt-rt-less-latency.scc \
"

SRC_URI[rt-patch.sha256sum] = "31f9b5df63d252cab38a7d644dadbd59ef2ac3450ef4bc5c84fa60ca3b66cc04"
