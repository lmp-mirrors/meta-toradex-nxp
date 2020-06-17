FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
# looks like weston-imx requires Vivante 6.4.0 g2d support to compile
# correctly, e.g.
# ../git/libweston/renderer-g2d/g2d-renderer.c:482:37: error: 'G2D_TILED_STATUS' undeclared (first use in this function)
#  482 |   g2dSurface->tiling             |= G2D_TILED_STATUS;

SRC_URI_append = "file://0001-g2d-renderer-ignore-G2D_TILED_STATUS-if-not-defined.patch"
