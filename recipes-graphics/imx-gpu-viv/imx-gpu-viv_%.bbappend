#update to 6.2.4.p2.3
PV = "6.2.4.p2.3-aarch32"
PV_aarch64 = "6.2.4.p2.3-aarch64"
LIC_FILES_CHKSUM = "file://COPYING;md5=6dfb32a488e5fd6bae52fbf6c7ebb086"
SRC_URI = "${FSL_MIRROR}/${PN}-${PV}.bin;fsl-eula=true"
MD5SUM = "d5529f8b6a6db1714f996a0de0b0858a"
SHA256SUM = "832d75095d746083bab13cefb0ab27e2da3930eadc215b8f2994d8cd02e387ab"
MD5SUM_aarch64 = "9a58192b56e2ed0737a29cd59e52734b"
SHA256SUM_aarch64 = "041da1d3495d8e8485f08d56a8f5db4a1a9a75a510adb10c65d83be7c3281e80"
SRC_URI[md5sum] = "${MD5SUM}"
SRC_URI[sha256sum] = "${SHA256SUM}"

# prevent pulling *-dev by packaging needed *.so in regular packages, not
# in imx-gpu-viv-dev.
INSANE_SKIP_libclc-imx += "dev-so"
FILES_libclc-imx = "${libdir}/libCLC${SOLIBS} ${libdir}/libLLVM_viv${SOLIBS}"
FILES_libvulkan-imx = "${libdir}/vulkan/libvulkan_VSI${SOLIBS} ${libdir}/libSPIRV_viv${SOLIBS}"
