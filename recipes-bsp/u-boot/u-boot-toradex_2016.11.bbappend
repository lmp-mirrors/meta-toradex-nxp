include conf/tdx_version.conf

PR = "${TDX_VER_INT}+gitr${@d.getVar("SRCREV", False)[0:7]}"
LOCALVERSION ?= "-${TDX_VER_INT}"

#LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

SRCREV = "1b121c6ab548a9af0a27876e9eaa0c654c1dc3e1"
SRCBRANCH = "2016.11-toradex"
