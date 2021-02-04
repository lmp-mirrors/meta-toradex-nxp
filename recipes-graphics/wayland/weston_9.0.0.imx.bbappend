# Don't build and install the backends which display weston on top of an
# existing wayland or x11 server. (Otherwise weston will prefer the wayland
# backend over the fbdev one for the non drm enabled machines)
PACKAGECONFIG_remove = "wayland x11"

PACKAGECONFIG[xwayland] = "-Dxwayland=true,-Dxwayland=false,libxcursor"

FILESEXTRAPATHS_prepend := "${THISDIR}/weston/:"
SRC_URI_append = " \
    file://0001-libweston-backend-fbdev-fbdev.c-don-t-destroy-output.patch \
    file://0002-libweston-pixman-renderer.c-zero-freed-pointer.patch \
"
