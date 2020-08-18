require u-boot-toradex-common.inc
require recipes-bsp/u-boot/u-boot.inc

B = "${WORKDIR}/build"

PROVIDES += "u-boot"

DEPENDS += "bc-native dtc-native"

BOOT_TOOLS = "imx-boot-tools"


nand_padding () {
    # pad the end of U-Boot with 0x00 up to the the end of the CSF area
    #PAD_END=$(echo -n "0x"; od -X  -j 0x24 -N 4 u-boot.imx | sed -e '/................/!d' -e 's/........\(.*\)/\1/')
    #PAD_END=$(( $PAD_END - 0x400 ))
    #objcopy -I binary -O binary --pad-to $PAD_END u-boot.imx u-boot.imx.zero-padded
    # assume that the above never need more than 10k of padding and skip the
    # shell magic to get a correct size.
    dd bs=10k count=1 if=/dev/zero | cat u-boot.imx - > u-boot.imx.zero-padded

    # U-Boot is flashed 1k into a NAND block, create a binary which prepends
    # U-boot with 1k of zeros to ease flashing
    dd bs=1024 count=1 if=/dev/zero | cat - u-boot.imx.zero-padded > u-boot-nand.imx
}

do_compile_append_colibri-imx6ull () {
    nand_padding
}

do_compile_append_colibri-imx7 () {
    nand_padding
}
