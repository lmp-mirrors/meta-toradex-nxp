# This bbappend can be dropped once we use NXP downstream 6.12 kernel
FILESEXTRAPATHS:prepend := "${THISDIR}/kernel-module-isp-vvcam/:"
SRC_URI += "file://0001-vvcam-dwe-platform_driver-remove-make-compatible-wit.patch;patchdir=${WORKDIR}/git"
