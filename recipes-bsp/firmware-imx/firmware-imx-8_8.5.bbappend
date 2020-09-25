PV = "8.8"
LIC_FILES_CHKSUM = "file://COPYING;md5=228c72f2a91452b8a03c4cab30f30ef9"
SRC_URI[md5sum] = "eabb27d28bba375a9f14d6306c07af5f"
SRC_URI[sha256sum] = "5ca1f8b6e6b191594d17ac7b51c38cdbc2ff808d15568ab4b0bbeb5dc6c621f6"

PREFIX = "${@bb.utils.contains('DISTRO_FEATURES','usrmerge','/usr','',d)}"

FILES_${PN} += " \
	${PREFIX}/lib/firmware/imx/hdmi/hdmitxfw.bin \
	${PREFIX}/lib/firmware/imx/hdmi/hdmirxfw.bin \
	${PREFIX}/lib/firmware/imx/hdmi/dpfw.bin \
"

unset do_install[noexec]

do_install_append () {
	install -d ${D}${PREFIX}/lib/firmware/imx/hdmi
	install -m 0644 ${S}/firmware/hdmi/cadence/hdmitxfw.bin ${D}${PREFIX}/lib/firmware/imx/hdmi/
	install -m 0644 ${S}/firmware/hdmi/cadence/hdmirxfw.bin ${D}${PREFIX}/lib/firmware/imx/hdmi/
	install -m 0644 ${S}/firmware/hdmi/cadence/dpfw.bin ${D}${PREFIX}/lib/firmware/imx/hdmi/
}
