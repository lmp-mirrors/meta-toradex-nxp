IMAGE_CLASSES += "image_type_tezi"
IMAGE_FSTYPES += "teziimg"
TORADEX_PRODUCT_IDS = "0036 0040 0044 0045"
TORADEX_PRODUCT_IDS[0036] = "imx6ull-colibri-eval-v3.dtb"
TORADEX_PRODUCT_IDS[0040] = "imx6ull-colibri-wifi-eval-v3.dtb"
TORADEX_PRODUCT_IDS[0044] = "imx6ull-colibri-eval-v3.dtb"
TORADEX_PRODUCT_IDS[0045] = "imx6ull-colibri-wifi-eval-v3.dtb"
TORADEX_FLASH_TYPE = "rawnand"

MACHINE_NAME = "Colibri-iMX6ULL"

EXTRA_IMAGEDEPENDS += "u-boot-distro-boot"
IMAGE_BOOT_FILES += "${MACHINE_BOOT_FILES}"
MACHINE_BOOT_FILES = "boot.scr"
