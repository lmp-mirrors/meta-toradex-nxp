IMAGE_CLASSES_append = " image_type_tezi"
IMAGE_FSTYPES += "teziimg"
TORADEX_PRODUCT_IDS = "0032 0033 0041"
TORADEX_PRODUCT_IDS[0032] = "imx7s-colibri-eval-v3.dtb"
TORADEX_PRODUCT_IDS[0033] = "imx7d-colibri-eval-v3.dtb"
TORADEX_PRODUCT_IDS[0041] = "imx7d-colibri-eval-v3.dtb"
TORADEX_FLASH_TYPE = "rawnand"

MACHINE_NAME = "Colibri-iMX7"

MACHINE_BOOT_FILES = "boot.scr"
IMAGE_BOOT_FILES_append = " ${MACHINE_BOOT_FILES}"
WKS_FILE_DEPENDS_append = " u-boot-distro-boot"

MACHINE_FIRMWARE_remove = "firmware-imx-epdc"

UBOOT_MAKE_TARGET_colibri-imx7 = "u-boot.imx"
