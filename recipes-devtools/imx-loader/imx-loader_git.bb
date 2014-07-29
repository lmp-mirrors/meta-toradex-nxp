DESCRIPTION = "USB/UART loader for i.MX51/53/6x and Vybrid"
SECTION = "base"
HOMEPAGE = "https://github.com/boundarydevices/imx_usb_loader"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "libusb1-native"

SRCREV = "09377bd5b8d04d4b20ef70bb0c56cf3de4500746"
SRC_URI = "git://github.com/toradex/imx_loader.git;protocol=git;branch=master"

S = "${WORKDIR}/git/"

PR = "r1"

#we want mkfs.ubifs binary to run on a 32 bit architecture, on x86-64 this requires the 32 bit compatibility libs
#FIXME: this does not work, currently we have to compile the 32bit binary on a 32bit machine
#EXTRA_OEMAKE_class-native = "'CC=${CC}' 'RANLIB=${RANLIB}' 'AR=${AR}' 'CFLAGS=${CFLAGS} -I${S}/include -DWITHOUT_XATTR -m32' 'BUILDDIR=${S}'"

BBCLASSEXTEND = "native"

do_install () {
    oe_runmake DESTDIR=${D} install
}
