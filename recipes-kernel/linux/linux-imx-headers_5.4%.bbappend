LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
SRCBRANCH = "toradex_5.4-2.1.x-imx"
LOCALVERSION = "-${SRCBRANCH}"
SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH}"
# Keep that one stable, i.e. use the exact git hash from the NXP BSP.
SRCREV = "dea2fede7e024ee7029b13e8d82a00ec14427777"
