IMAGE_CLASSES_append = " image_type_tezi"
IMAGE_FSTYPES += "teziimg"
TORADEX_PRODUCT_IDS = "0027 0028 0029 0035"
# The payload offsets are given in number of 512 byte blocks.
OFFSET_BOOTROM_PAYLOAD = "2"
OFFSET_SPL_PAYLOAD = "138"

MACHINE_NAME = "Apalis-iMX6"

PREFERRED_PROVIDER_u-boot-default-script = "u-boot-distro-boot"

KERNEL_IMAGETYPE_${MACHINE} = "zImage"
PREFERRED_PROVIDER_virtual/kernel_preempt-rt = "linux-toradex-rt"

UBOOT_SUFFIX = "img"

MACHINE_FIRMWARE_remove = "firmware-imx-epdc"

# As per meta-freescale commit 927b31771dab ("xf86-video-imx-vivante: Remove fb
# from name") this package got renamed. Use new one!
XSERVER_DRIVER_apalis-imx6 = "xf86-video-imx-vivante"
