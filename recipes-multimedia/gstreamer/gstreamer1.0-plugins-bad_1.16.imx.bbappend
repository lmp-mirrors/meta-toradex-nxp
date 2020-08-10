FILESEXTRAPATHS_prepend := "${THISDIR}/gstreamer1.0-plugins-bad:"
SRCBRANCH = "MM_04.05.05_2005_L5.4.24"
SRCREV = "2fdaef1839ebfef7ea3bc8c1c59463a9ef0ae19a"
SRC_URI_remove = " \
    file://0001-meson-fix-build-with-opencv-enabled-and-opencv4.-Fix.patch \
"