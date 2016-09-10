FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-4.1:"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-v2.6b1"
SRCREV = "455cc9da4df2597945cb63a08a7c99cab99db644"
SRCBRANCH = "toradex_vf_4.1-next"
