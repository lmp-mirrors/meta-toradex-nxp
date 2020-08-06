#update to 6.4.0.p2.4
PV = "6.4.0.p2.4-aarch32"
PV_aarch64 = "6.4.0.p2.4-aarch64"
LIC_FILES_CHKSUM = "file://COPYING;md5=228c72f2a91452b8a03c4cab30f30ef9"
MD5SUM_arm = "cd5e9ba9247aa0da5d97b0f030e2ede1"
SHA256SUM_arm = "9cc4c6594083f5970bc394a698a0a8ed0c7f2a1a753dfbf25cb0be5ab8bdcbd5"
MD5SUM_aarch64 = "633029434f0ccc0e8a6b01d92cae95b2"
SHA256SUM_aarch64 = "a295f41a6346c507fc8a677c26ecf9b2f416735e32e6d0734516ef5363027720"
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

    if [ "${IS_MX8}" = "1" ]; then
	# delete the unversioned .so files and symlinks
	rm ${S}/gpu-core/usr/lib/libvulkan*.so ${S}/gpu-core/usr/lib/libvulkan*.so.1

	# delete all unneeded .so files
	WANTED=$(ls ${S}/gpu-core/usr/lib/libvulkan-${backend}.so.*)
	mv ${WANTED} wanted
	rm ${S}/gpu-core/usr/lib/libvulkan-*.so.*
	mv wanted ${WANTED}

	# create the .so symlinks
	ln -fs $(basename ${WANTED}) ${S}/gpu-core/usr/lib/libvulkan-${backend}.so
	ln -fs $(basename ${WANTED}) ${S}/gpu-core/usr/lib/libvulkan_VSI.so.1
    fi
}

FILES_libopencl-imx_append = " ${libdir}/libOpenCL${REALSOLIBS}"
INSANE_SKIP_libopencl-imx += "dev-so"

FILES_libopenvx-imx_append = " \
    ${libdir}/libOpenVX*${REALSOLIBS} \
    ${libdir}/libOvx*${REALSOLIBS} \
    ${libdir}/libovx*${REALSOLIBS} \
"
INSANE_SKIP_libopenvx-imx += "dev-so"

FILES_libvulkan-imx_append = " ${libdir}/libvulkan*${REALSOLIBS}"
INSANE_SKIP_libvulkan-imx += "dev-so"
