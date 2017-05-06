IMAGE_CLASSES_append = " image_type_tezi"
IMAGE_FSTYPES_append = " teziimg"
TORADEX_PRODUCT_IDS = "0014 0015 0016 0017"
# The payload offsets are given in number of 512 byte blocks.
OFFSET_BOOTROM_PAYLOAD = "2"
OFFSET_SPL_PAYLOAD = "138"

# Note: The last config will be symlinked to UBOOT_BINARY which is crucial for
# certain image formats.
UBOOT_CONFIG ?= "recover spl"
UBOOT_CONFIG[recover] = "colibri_imx6_nospl_defconfig,,u-boot.imx"
