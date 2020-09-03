IMAGE_CLASSES_append = " image_type_tezi"
IMAGE_FSTYPES_append = " teziimg"
TORADEX_PRODUCT_IDS = "0027 0028 0029 0035"
# The payload offsets are given in number of 512 byte blocks.
OFFSET_BOOTROM_PAYLOAD = "2"
OFFSET_SPL_PAYLOAD = "138"

MACHINE_NAME = "Apalis-iMX6"

IMAGE_BOOT_FILES_append = " boot.scr-${MACHINE};boot.scr"
WKS_FILE_DEPENDS_append = " u-boot-distro-boot"

KERNEL_DEVICETREE += "imx6q-apalis-ixora-v1.2.dtb"
KERNEL_DEVICETREE_use-mainline-bsp += " \
    imx6q-apalis-eval.dtb \
    imx6q-apalis-ixora-v1.1.dtb \
"

PREFERRED_PROVIDER_virtual/kernel = "linux-toradex"
PREFERRED_PROVIDER_virtual/kernel_preempt-rt = "linux-toradex"
PREFERRED_PROVIDER_virtual/kernel_use-mainline-bsp = "linux-toradex-mainline"
PREFERRED_PROVIDER_virtual/kernel_use-mainline-bsp_preempt-rt = "linux-toradex-mainline"
PREFERRED_PROVIDER_virtual/dtb_use-mainline-bsp = "device-tree-overlays-mainline"

PREFERRED_PROVIDER_u-boot-default-script = "u-boot-distro-boot"
UBOOT_SUFFIX = "img"

MACHINE_FIRMWARE_remove = "firmware-imx-epdc"
