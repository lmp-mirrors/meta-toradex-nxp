SRCREV = "27cde5253235104c45b8ce72963e7ae159134f89"

# Don't build and install the backends which display weston on top of an
# existing wayland or x11 server. (Otherwise weston will prefer the wayland
# backend over the fbdev one for the non drm enabled machines)
PACKAGECONFIG_remove = "wayland x11"

PACKAGECONFIG[xwayland] = "-Dxwayland=true,-Dxwayland=false,libxcursor"
