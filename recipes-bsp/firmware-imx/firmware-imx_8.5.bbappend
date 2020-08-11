PV = "8.8"
LIC_FILES_CHKSUM = "file://COPYING;md5=228c72f2a91452b8a03c4cab30f30ef9"
SRC_URI[md5sum] = "eabb27d28bba375a9f14d6306c07af5f"
SRC_URI[sha256sum] = "5ca1f8b6e6b191594d17ac7b51c38cdbc2ff808d15568ab4b0bbeb5dc6c621f6"

PACKAGES =+ "${PN}-xcvr ${PN}-xuvi"

do_install_append () {
    mv ${D}${base_libdir}/firmware/xcvr/ ${D}${base_libdir}/firmware/imx/xcvr/

    mv ${D}${base_libdir}/firmware/xuvi/ ${D}${base_libdir}/firmware/imx/xuvi/
}

FILES_${PN}-xcvr = "${base_libdir}/firmware/imx/xcvr/"
FILES_${PN}-xuvi = "${base_libdir}/firmware/imx/xuvi/"
