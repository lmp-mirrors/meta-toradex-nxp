IMAGE_CLASSES_append = " image_type_tezi"
IMAGE_FSTYPES_append = " teziimg"
# The payload offsets are given in number of 512 byte blocks.
OFFSET_BOOTROM_PAYLOAD = "2"
TORADEX_PRODUCT_IDS = "0039"
TORADEX_FLASH_TYPE = "emmc"

MACHINE_NAME = "Colibri-iMX7-eMMC"

MACHINEOVERRIDES_append_upstream = ":use-mainline-bsp"

MACHINE_FIRMWARE_remove = "firmware-imx-epdc"
MACHINE_FIRMWARE_remove_use-mainline-bsp = "firmware-imx-vpu-imx6q firmware-imx-vpu-imx6d"

PREFERRED_PROVIDER_virtual/kernel = "linux-toradex"
PREFERRED_PROVIDER_virtual/kernel_preempt-rt = "linux-toradex"
PREFERRED_PROVIDER_virtual/kernel_use-mainline-bsp = "linux-toradex-mainline"
PREFERRED_PROVIDER_virtual/kernel_use-mainline-bsp_preempt-rt = "linux-toradex-mainline"
PREFERRED_PROVIDER_virtual/dtb_use-mainline-bsp = "device-tree-overlays-mainline"

KERNEL_DEVICETREE_append_use-nxp-bsp = " \
    imx7d-colibri-emmc-iris.dtb \
    imx7d-colibri-emmc-iris-v2.dtb \
"
KERNEL_DEVICETREE_append_use-mainline-bsp = " \
    imx7d-colibri-emmc-aster.dtb \
"

PREFERRED_PROVIDER_u-boot-default-script = "u-boot-distro-boot"

TEZI_EXTERNAL_KERNEL_DEVICETREE_BOOT = "colibri-imx7_lcd-vga_overlay.dtbo colibri-imx7_ad7879_overlay.dtbo"
TEZI_EXTERNAL_KERNEL_DEVICETREE_BOOT_use-mainline-bsp = "colibri-imx7_parallel-rgb_overlay.dtbo colibri-imx7_ad7879_overlay.dtbo display-vga_overlay.dtbo"

UBOOT_BINARY_colibri-imx7-emmc = "u-boot.imx"
UBOOT_DTB_LOADADDRESS_colibri-imx7-emmc = "0x82000000"
UBOOT_DTBO_LOADADDRESS_colibri-imx7-emmc = "0x87000000"
UBOOT_ENTRYPOINT_colibri-imx7-emmc = "0x81000000"
UBOOT_MAKE_TARGET = "u-boot.imx"
UBOOT_SUFFIX_${MACHINE} = "imx"
