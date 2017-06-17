require recipes-bsp/u-boot/u-boot-toradex.inc

PV = "2016.11"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

SRCREV = "f0e414972b5b225e33ebe75574562266116746f9"
SRCBRANCH = "2016.11-toradex"
COMPATIBLE_MACHINE = "(mx6|mx7|vf)"


# Hack around building two U-Boot configurations, one with, one without SPL
# if using UBOOT_CONFIG to build more than one configuration, the current code in
# u-boot.inc assumes all are either with or without SPL.
do_compile_append_mx6() {
    for config in ${UBOOT_MACHINE}; do
        touch ${B}/${config}/${SPL_BINARY}
    done
}
do_deploy_append_mx6() {
    # if SPL is zero sized file, remove all deployed artefacts
    if [ -n "${SPL_BINARY}" ]
    then
        if [ -n "${UBOOT_CONFIG}" ]
        then
            for config in ${UBOOT_MACHINE}; do
                i=$(expr $i + 1);
                for type in ${UBOOT_CONFIG}; do
                    j=$(expr $j + 1);
                    if [ $j -eq $i ]
                    then
                        if [ ! -s ${DEPLOYDIR}/${SPL_IMAGE}-${type}-${PV}-${PR} ]
                        then
                            rm -f ${DEPLOYDIR}/${SPL_IMAGE}-${type}-${PV}-${PR}
                            rm -f ${DEPLOYDIR}/${SPL_BINARYNAME}-${type}
                            rm -f ${DEPLOYDIR}/${SPL_SYMLINK}-${type}
                            rm -f ${DEPLOYDIR}/${SPL_SYMLINK}
                        else
                            ln -sf ${SPL_IMAGE}-${type}-${PV}-${PR} ${SPL_BINARYNAME}
                        fi
                    fi
                done
                unset  j
            done
            unset  i
        fi
    fi
}
