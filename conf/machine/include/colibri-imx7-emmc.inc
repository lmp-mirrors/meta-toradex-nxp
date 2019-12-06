IMAGE_CLASSES += "image_type_tezi"
IMAGE_FSTYPES += "teziimg"
# The payload offsets are given in number of 512 byte blocks.
OFFSET_BOOTROM_PAYLOAD = "2"
TORADEX_PRODUCT_IDS = "0039"
TORADEX_FLASH_TYPE = "emmc"

MACHINE_NAME = "Colibri-iMX7-eMMC"

MACHINE_BOOT_FILES = "boot.scr"
IMAGE_BOOT_FILES_append = " ${MACHINE_BOOT_FILES}"
WKS_FILE_DEPENDS_append = " u-boot-distro-boot"

MACHINE_FIRMWARE_remove = "firmware-imx-epdc"

PREFERRED_PROVIDER_virtual/kernel_preempt-rt = "linux-toradex-rt"

KERNEL_DEVICETREE_use-mainline-bsp = "imx7d-colibri-emmc-eval-v3.dtb"
