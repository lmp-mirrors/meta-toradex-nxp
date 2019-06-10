PV = "6.2.4.p2.3"
SRC_URI[arm.md5sum] = "826349f67198359fddfe3e456770eb68"
SRC_URI[arm.sha256sum] = "35a5875d795190117b7fcdd43229d18576d530fddfd32f9d79e161fc7028d29d"
LIC_FILES_CHKSUM = "file://COPYING;md5=6dfb32a488e5fd6bae52fbf6c7ebb086"

# implement that this is not for COMPATIBLE_MACHINE_imxdpu
COMPATIBLE_MACHINE_2D          = "(^$)"
COMPATIBLE_MACHINE_2D_imxgpu2d = "${MACHINE}"
COMPATIBLE_MACHINE             = "${COMPATIBLE_MACHINE_2D}"
COMPATIBLE_MACHINE_imxdpu      = "(^$)"
