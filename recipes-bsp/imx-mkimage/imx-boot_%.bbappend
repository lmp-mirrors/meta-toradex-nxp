# Create symbolic link rather than copying mkimage_uboot
compile_mx8m_prepend() {
    rm -rf ${BOOT_STAGING}/mkimage_uboot
}
compile_mx8m_append() {
    rm -rf ${BOOT_STAGING}/mkimage_uboot
    lnr ${STAGING_DIR_NATIVE}/${bindir}/mkimage ${BOOT_STAGING}/mkimage_uboot
}
