FILESEXTRAPATHS:prepend := "${THISDIR}/alsa-state/:"

#make this machine specific, as we have different codecs with different settings
PACKAGE_ARCH:tdx = "${MACHINE_ARCH}"
