IMAGE_CLASSES += "image_type_tezi"
IMAGE_FSTYPES += "teziimg"
# The payload offsets are given in number of 512 byte blocks.
OFFSET_BOOTROM_PAYLOAD = "2"
TORADEX_PRODUCT_IDS = "0039"
TORADEX_FLASH_TYPE = "emmc"

MACHINE_NAME = "Colibri-iMX7-eMMC"

EXTRA_IMAGEDEPENDS += "u-boot-distro-boot"
IMAGE_BOOT_FILES += "${MACHINE_BOOT_FILES}"
MACHINE_BOOT_FILES = "boot.scr"

MACHINE_FIRMWARE_remove = "firmware-imx-epdc"
