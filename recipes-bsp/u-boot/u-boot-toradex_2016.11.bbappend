include conf/tdx_version.conf

PR = "${TDX_VER_INT}-gitr${@d.getVar("SRCREV", False)[0:7]}"
LOCALVERSION ?= "-${TDX_VER_INT}"

#LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

#SRCREV = "60021a4daa9720ae89e31def9483a09a78ead049"
#SRCBRANCH = "2016.11-toradex-next"
