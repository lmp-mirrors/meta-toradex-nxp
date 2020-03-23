IMAGE_CLASSES += "image_type_tezi"
IMAGE_FSTYPES += "teziimg"
TORADEX_PRODUCT_IDS = "0036 0040 0044 0045"
TORADEX_PRODUCT_IDS[0036] = "imx6ull-colibri-eval-v3.dtb"
TORADEX_PRODUCT_IDS[0040] = "imx6ull-colibri-wifi-eval-v3.dtb"
TORADEX_PRODUCT_IDS[0044] = "imx6ull-colibri-eval-v3.dtb"
TORADEX_PRODUCT_IDS[0045] = "imx6ull-colibri-wifi-eval-v3.dtb"
TORADEX_FLASH_TYPE = "rawnand"

IMAGE_FSTYPES += "wic.gz"
WIC_CREATE_EXTRA_ARGS_append = " --no-fstab-update"

MACHINE_NAME = "Colibri-iMX6ULL"

PREFERRED_PROVIDER_u-boot-default-script = "u-boot-distro-boot"
UBOOT_ENTRYPOINT_colibri-imx6ull = "0x81000000"

MACHINEOVERRIDES_append_upstream = ":use-mainline-bsp"

MACHINE_BOOT_FILES = "boot.scr"
IMAGE_BOOT_FILES_append = " ${MACHINE_BOOT_FILES}"
WKS_FILE_DEPENDS_append = " u-boot-distro-boot"

UBOOT_ENTRYPOINT_colibri-imx6ull = "0x81000000"
UBOOT_MAKE_TARGET_colibri-imx6ull = "u-boot.imx"

KERNEL_DEVICETREE_append_use_nxp_bsp = " \
    imx6ull-colibri-aster.dtb imx6ull-colibri-wifi-aster.dtb \
    imx6ull-colibri-iris.dtb imx6ull-colibri-wifi-iris.dtb \
    imx6ull-colibri-iris-v2.dtb imx6ull-colibri-wifi-iris-v2.dtb \
"
PREFERRED_PROVIDER_virtual/kernel_preempt-rt = "linux-toradex-rt"
PREFERRED_PROVIDER_virtual/kernel_upstream = "linux-toradex-mainline"
PREFERRED_PROVIDER_virtual/kernel_upstream_preempt-rt = "linux-toradex-mainline-rt"
