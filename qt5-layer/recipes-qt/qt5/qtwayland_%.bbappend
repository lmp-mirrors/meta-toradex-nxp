PACKAGECONFIG_remove_tdx = "${@bb.utils.contains('DISTRO_FEATURES', 'wayland x11', 'xcomposite-egl xcomposite-glx', '', d)}"
