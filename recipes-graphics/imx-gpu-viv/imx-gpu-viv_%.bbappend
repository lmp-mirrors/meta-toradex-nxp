#update to 6.2.4.p4.0
PV = "6.2.4.p4.0-aarch32"
PV_aarch64 = "6.2.4.p4.0-aarch64"
LIC_FILES_CHKSUM = "file://COPYING;md5=80c0478f4339af024519b3723023fe28"
SRC_URI = "${FSL_MIRROR}/${BPN}-${PV}.bin;fsl-eula=true"
MD5SUM_arm = "83c40f63358dd3bd9bbc1cd7521bf8fe"
SHA256SUM_arm = "5abfc3b24c1f9d02970064898fb30da705b67bc7e967dbfbf0525c1cc60f2491"
MD5SUM_aarch64 = "a937571f6ecf85bdff1dfb3b6c834ed0"
SHA256SUM_aarch64 = "1eb4ebe2fa11d8fb7beb8fc7046bb57093fd416d0a401608d78cd48b65624fcd"
SRC_URI[md5sum] = "${MD5SUM}"
SRC_URI[sha256sum] = "${SHA256SUM}"

# prevent pulling *-dev by packaging needed *.so in regular packages, not
# in imx-gpu-viv-dev.
INSANE_SKIP_libclc-imx += "dev-so"
FILES_libclc-imx = "${libdir}/libCLC${SOLIBS} ${libdir}/libLLVM_viv${SOLIBS}"
FILES_libvulkan-imx = "${libdir}/vulkan/libvulkan_VSI${SOLIBS} ${libdir}/libSPIRV_viv${SOLIBS}"
