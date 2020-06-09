#update to 6.2.4.p4.8
PV = "6.2.4.p4.8-aarch32"
PV_aarch64 = "6.2.4.p4.8-aarch64"
LIC_FILES_CHKSUM = "file://COPYING;md5=fd4b227530cd88a82af6a5982cfb724d"
MD5SUM_arm = "0e18ffca4b9c648fb41586fa53647541"
SHA256SUM_arm = "2804c3d7b8fdd0db6659735cc55b33e7fe749b823ccd9a5ee37b1ccf764ae928"
MD5SUM_aarch64 = "6937d91f3133a63b6e5bb33951c8c2e8"
SHA256SUM_aarch64 = "72c5338003322a4ebf4d28e38f48b3014fcd116bd54d1b42924aa3be32888bd0"
SRC_URI[md5sum] = "${MD5SUM}"
SRC_URI[sha256sum] = "${SHA256SUM}"

# prevent pulling *-dev by packaging needed *.so in regular packages, not
# in imx-gpu-viv-dev.
INSANE_SKIP_libclc-imx += "dev-so"

do_install_prepend() {
    if [ "${USE_WL}" = "yes" ]; then
        backend=wl
    elif [ "${USE_X11}" = "yes" ]; then
        backend=x11
    fi

    # in the 6.2.4.p4.8 this file wasn't backend specific
    [ ! -e ${S}/gpu-core/usr/lib/libGL-${backend}.so ] &&
        cp ${S}/gpu-core/usr/lib/libGL.so ${S}/gpu-core/usr/lib/libGL-${backend}.so
}

# in the 6.2.4.p4.8 gbm_viv.so is installed, so it must also be packaged
FILES_libgbm-imx_mx8 = "${libdir}/libgbm*${SOLIBS} ${libdir}/gbm_viv${SOLIBS}"
