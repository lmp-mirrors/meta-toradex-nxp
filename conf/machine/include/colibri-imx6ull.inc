IMAGE_CLASSES += "image_type_tezi"
IMAGE_FSTYPES += "teziimg"
TORADEX_PRODUCT_IDS = "0036 0040 0044 0045"
TORADEX_PRODUCT_IDS[0036] = "imx6ull-colibri-eval-v3.dtb"
TORADEX_PRODUCT_IDS[0040] = "imx6ull-colibri-wifi-eval-v3.dtb"
TORADEX_PRODUCT_IDS[0044] = "imx6ull-colibri-eval-v3.dtb"
TORADEX_PRODUCT_IDS[0045] = "imx6ull-colibri-wifi-eval-v3.dtb"
TORADEX_FLASH_TYPE = "rawnand"

MACHINE_NAME = "Colibri-iMX6ULL"

MACHINEOVERRIDES_append_upstream = ":use-mainline-bsp"

MACHINE_BOOT_FILES = "boot.scr"
IMAGE_BOOT_FILES_append = " ${MACHINE_BOOT_FILES}"
WKS_FILE_DEPENDS_append = " u-boot-distro-boot"

UBOOT_ENTRYPOINT_colibri-imx6ull = "0x81000000"

PREFERRED_PROVIDER_virtual/kernel_preempt-rt = "linux-toradex-rt"
PREFERRED_PROVIDER_virtual/kernel_upstream = "linux-toradex-mainline"
PREFERRED_PROVIDER_virtual/kernel_upstream_preempt-rt = "linux-toradex-mainline-rt"
