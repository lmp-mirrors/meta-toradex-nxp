FILESEXTRAPATHS_prepend := "${THISDIR}/alsa-state/:"

# make this machine specific, as we have different codecs with different settings
PACKAGE_ARCH_tdx = "${MACHINE_ARCH}"

SRC_URI_append_mx8m_tdx = " \
    file://asound-dev.conf \
    file://asound-dahlia.conf \
    file://asound-dev.state \
    file://asound-dahlia.state \
"

FILES_${PN} += "${sysconfdir}/asound-*.conf"

do_install_append_mx8m_tdx () {
    # Remove the default asound.conf, we need set up asound.conf dynamically
    # at runtime to support both dev/dahlia boards.
    rm -f ${D}${sysconfdir}/asound.conf
    rm -f ${D}${localstatedir}/lib/alsa/asound.state
    install -m 0644 ${WORKDIR}/asound-*.conf ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/asound-*.state ${D}${localstatedir}/lib/alsa
}

# Invalidate the default pkg_postinst in oe-core, this ensures our ontarget
# postinst to be the only one to run during package installation.
pkg_postinst_${PN}_mx8m_tdx () {
}

pkg_postinst_ontarget_${PN}_mx8m_tdx () {
    if grep -q "Development" /proc/device-tree/model; then
        board="dev"
    else
        board="dahlia"
    fi

    mv /etc/asound-$board.conf /etc/asound.conf
    mv /var/lib/alsa/asound-$board.state /var/lib/alsa/asound.state
    rm -f /etc/asound-*.conf
    rm -f /var/lib/alsa/asound-*.state
}
