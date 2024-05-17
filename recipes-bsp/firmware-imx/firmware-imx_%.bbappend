# create symlinks for the amphion vpu fw where older kernel
# try to load them from.
do_install:append () {
    install -d ${D}${nonarch_base_libdir}/firmware/vpu
    ln -sf ../amphion/vpu/vpu_fw_imx8_dec.bin ${D}${nonarch_base_libdir}/firmware/vpu/
    ln -sf ../amphion/vpu/vpu_fw_imx8_enc.bin ${D}${nonarch_base_libdir}/firmware/vpu/
}
FILES:${PN}-vpu-amphion:append = " ${nonarch_base_libdir}/firmware/vpu/vpu_fw_imx8*"
