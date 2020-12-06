compile_mx8m_append() {
    # Create symbolic link rather than copying mkimage_uboot
    rm -rf ${BOOT_STAGING}/mkimage_uboot
    lnr ${STAGING_DIR_NATIVE}/${bindir}/mkimage ${BOOT_STAGING}/mkimage_uboot
}
