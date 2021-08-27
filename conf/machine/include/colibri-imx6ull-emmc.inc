IMAGE_CLASSES_append = " image_type_tezi"
IMAGE_FSTYPES_append = " teziimg"
# The payload offsets are given in number of 512 byte blocks.
OFFSET_BOOTROM_PAYLOAD = "2"
TORADEX_PRODUCT_IDS = "0062"
TORADEX_FLASH_TYPE = "emmc"

WIC_CREATE_EXTRA_ARGS_append = " --no-fstab-update"

MACHINE_NAME = "Colibri-iMX6ULL-eMMC"

PREFERRED_PROVIDER_u-boot-default-script = "u-boot-distro-boot"

# MACHINEOVERRIDES_append_upstream = ":use-mainline-bsp"

UBOOT_MAKE_TARGET_colibri-imx6ull-emmc = "u-boot.imx"
UBOOT_ENTRYPOINT_colibri-imx6ull-emmc = "0x81000000"
UBOOT_DTB_LOADADDRESS_colibri-imx6ull-emmc = "0x82100000"
UBOOT_DTBO_LOADADDRESS_colibri-imx6ull-emmc = "0x87000000"

TEZI_EXTERNAL_KERNEL_DEVICETREE_BOOT = "colibri-imx6ull_parallel-rgb_vga_overlay.dtbo colibri-imx6ull_ad7879_overlay.dtbo"
# This config will be enabled when respective overlays will be added to the upstream.
# TEZI_EXTERNAL_KERNEL_DEVICETREE_BOOT_use-mainline-bsp = "colibri-imx6ull_parallel-rgb_vga_overlay.dtbo colibri-imx6ull_ad7879_overlay.dtbo display-vga_overlay.dtbo"

PREFERRED_PROVIDER_virtual/kernel = "linux-toradex"
PREFERRED_PROVIDER_virtual/kernel_preempt-rt = "linux-toradex"
PREFERRED_PROVIDER_virtual/kernel_use-mainline-bsp = "linux-toradex-mainline"
PREFERRED_PROVIDER_virtual/kernel_use-mainline-bsp_preempt-rt = "linux-toradex-mainline"
PREFERRED_PROVIDER_virtual/dtb_use-mainline-bsp = "device-tree-overlays-mainline"
