SECO_CHIP ?= "qmb0"
SECO_CHIP_mx8qxp = "qxb0"
SECO_CHIP_mx8qxpc0 = "qxc0"

SECO_FIRMWARE = "mx8${SECO_CHIP}-ahab-container.img"

SRCBRANCH = "imx_5.4.24_2.1.0"
SRCREV = "6745ccdcf15384891639b7ced3aa6ce938682365"

REV_CHIP ?= "B0"
REV_CHIP_imx8qxpc0mek = "C0"
REV_CHIP_imx8qxpc0lpddr4arm2 = "C0"
REV_CHIP_mx8qxpc0 = "C0"

compile_mx8m() {
    bbnote 8MQ/8MM boot binary build
    for ddr_firmware in ${DDR_FIRMWARE_NAME}; do
        bbnote "Copy ddr_firmware: ${ddr_firmware} from ${DEPLOY_DIR_IMAGE} -> ${BOOT_STAGING} "
        cp ${DEPLOY_DIR_IMAGE}/${ddr_firmware}               ${BOOT_STAGING}
    done
    cp ${DEPLOY_DIR_IMAGE}/signed_*_imx8m.bin                ${BOOT_STAGING}
    cp ${DEPLOY_DIR_IMAGE}/u-boot-spl.bin-${MACHINE}-${UBOOT_CONFIG} ${BOOT_STAGING}/u-boot-spl.bin
    cp ${DEPLOY_DIR_IMAGE}/${BOOT_TOOLS}/${UBOOT_DTB_NAME}   ${BOOT_STAGING}
    cp ${DEPLOY_DIR_IMAGE}/${BOOT_TOOLS}/u-boot-nodtb.bin-${MACHINE}-${UBOOT_CONFIG} ${BOOT_STAGING}/u-boot-nodtb.bin
    cp ${DEPLOY_DIR_IMAGE}/${BOOT_TOOLS}/mkimage_uboot       ${BOOT_STAGING}
    cp ${DEPLOY_DIR_IMAGE}/${BOOT_TOOLS}/${ATF_MACHINE_NAME} ${BOOT_STAGING}/bl31.bin
    cp ${DEPLOY_DIR_IMAGE}/${UBOOT_NAME}                     ${BOOT_STAGING}/u-boot.bin
}
compile_mx8() {
    bbnote 8QM boot binary build
    cp ${DEPLOY_DIR_IMAGE}/${BOOT_TOOLS}/${SC_FIRMWARE_NAME} ${BOOT_STAGING}/scfw_tcm.bin
    cp ${DEPLOY_DIR_IMAGE}/${BOOT_TOOLS}/${ATF_MACHINE_NAME} ${BOOT_STAGING}/bl31.bin
    cp ${DEPLOY_DIR_IMAGE}/${UBOOT_NAME}                     ${BOOT_STAGING}/u-boot.bin
    cp ${DEPLOY_DIR_IMAGE}/${SECO_FIRMWARE}                  ${BOOT_STAGING}
}
compile_mx8x() {
    bbnote 8QX boot binary build
    cp ${DEPLOY_DIR_IMAGE}/${SECO_FIRMWARE}                  ${BOOT_STAGING}
    cp ${DEPLOY_DIR_IMAGE}/${BOOT_TOOLS}/${SC_FIRMWARE_NAME} ${BOOT_STAGING}/scfw_tcm.bin
    cp ${DEPLOY_DIR_IMAGE}/${BOOT_TOOLS}/${ATF_MACHINE_NAME} ${BOOT_STAGING}/bl31.bin
    cp ${DEPLOY_DIR_IMAGE}/${UBOOT_NAME}                     ${BOOT_STAGING}/u-boot.bin
}
do_compile() {
    compile_${SOC_FAMILY}
    # mkimage for i.MX8
    for target in ${IMXBOOT_TARGETS}; do
        bbnote "building ${SOC_TARGET} - ${target}"
        make SOC=${SOC_TARGET} REV=${REV_CHIP} dtbs=${UBOOT_DTB_NAME} ${target}
        if [ -e "${BOOT_STAGING}/flash.bin" ]; then
            cp ${BOOT_STAGING}/flash.bin ${S}/${BOOT_CONFIG_MACHINE}-${target}
        fi
    done
}
deploy_mx8() {
    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0644 ${BOOT_STAGING}/${SECO_FIRMWARE} ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0755 ${S}/${TOOLS_NAME}               ${DEPLOYDIR}/${BOOT_TOOLS}
}
deploy_mx8x() {
    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0644 ${BOOT_STAGING}/${SECO_FIRMWARE} ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0755 ${S}/${TOOLS_NAME}               ${DEPLOYDIR}/${BOOT_TOOLS}
}
