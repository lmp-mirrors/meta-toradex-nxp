IMAGE_CLASSES_append = " image_type_tezi"
IMAGE_FSTYPES_append = " teziimg"
TORADEX_PRODUCT_IDS = "0032 0033 0041"
TORADEX_PRODUCT_IDS[0032] = "imx7s-colibri-eval-v3.dtb"
TORADEX_PRODUCT_IDS[0033] = "imx7d-colibri-eval-v3.dtb"
TORADEX_PRODUCT_IDS[0041] = "imx7d-colibri-eval-v3.dtb"
TORADEX_FLASH_TYPE = "rawnand"

MACHINE_NAME = "Colibri-iMX7"

MACHINEOVERRIDES_append_upstream = ":use-mainline-bsp"

MACHINE_FIRMWARE_remove = "firmware-imx-epdc"

KERNEL_DEVICETREE_append_use-nxp-bsp += " \
    imx7d-colibri-iris.dtb \
    imx7d-colibri-iris-v2.dtb \
    imx7s-colibri-iris.dtb \
    imx7s-colibri-iris-v2.dtb \
"
KERNEL_DEVICETREE_append_use-mainline-bsp = " \
    imx7d-colibri-aster.dtb \
    imx7s-colibri-aster.dtb \
"

PREFERRED_PROVIDER_virtual/kernel = "linux-toradex"
PREFERRED_PROVIDER_virtual/kernel_preempt-rt = "linux-toradex"
PREFERRED_PROVIDER_virtual/kernel_use-mainline-bsp = "linux-toradex-mainline"
PREFERRED_PROVIDER_virtual/kernel_use-mainline-bsp_preempt-rt = "linux-toradex-mainline"
PREFERRED_PROVIDER_virtual/dtb_use-mainline-bsp = "device-tree-overlays-mainline"

PREFERRED_PROVIDER_u-boot-default-script = "u-boot-distro-boot"
UBOOT_MAKE_TARGET_colibri-imx7 = "u-boot.imx"
