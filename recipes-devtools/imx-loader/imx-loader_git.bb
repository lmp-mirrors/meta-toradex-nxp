SUMMARY = "USB/UART loader for i.MX51/53/6x/7 and Vybrid"
SECTION = "base"
HOMEPAGE = "https://github.com/boundarydevices/imx_usb_loader"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

DEPENDS = "libusb1-native"

SRCREV = "d4d978927f9835d5583ad6d1e00cd9d3138947ab"
SRC_URI = "git://github.com/boundarydevices/imx_usb_loader.git;protocol=git;branch=master"

S = "${WORKDIR}/git/"

PR = "r1"

#we want imx_usb binary to run on a 32-bit architecture, on x86_64 this requires the 32-bit compatibility libs
EXTRA_OEMAKE_class-native = "CC='${CC} -m32' CXX='${CXX} -m32'"

BBCLASSEXTEND = "native"

do_install () {
    oe_runmake DESTDIR=${D} install
}
