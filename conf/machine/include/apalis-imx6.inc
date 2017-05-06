IMAGE_CLASSES_append = " image_type_tezi"
IMAGE_FSTYPES_append = " teziimg"
TORADEX_PRODUCT_IDS = "0027 0028 0029 0035"
# The payload offsets are given in number of 512 byte blocks.
OFFSET_BOOTROM_PAYLOAD = "2"
OFFSET_SPL_PAYLOAD = "138"

# The SPL configures the DDR RAM depending on the module it runs on. Thus there
# is no need to distingush between the different module types.
# For recovery mode we build a U-Boot with IVT which runs without SPL. It uses
# save timings for all known Apalis iMX6.
# Note: The last config will be symlinked to UBOOT_BINARY which is crucial for
# certain image formats.
UBOOT_CONFIG ?= "recover spl"
UBOOT_CONFIG[recover] = "apalis_imx6_nospl_it_defconfig,,u-boot.imx"
