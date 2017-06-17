include conf/tdx_version.conf

PR = "${TDX_VER_INT}-gitr${@d.getVar("SRCREV", False)[0:7]}"
LOCALVERSION ?= "-${TDX_VER_INT}"

#LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

SRCREV = "f0e414972b5b225e33ebe75574562266116746f9"
SRCBRANCH = "2016.11-toradex"
