FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-4.1:"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-v2.5b2"
SRCREV = "559570ccdc6555d2228a4e4e9e589e3145d7c2e4"
