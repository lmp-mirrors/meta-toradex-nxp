include conf/tdx_version.conf

LOCALVERSION = "-${TDX_VER_ITEM}"

SRCREV = "52259cf22a165c0721bb26c723c0dc5e2659eaa7"
SRCBRANCH = "2016.11-toradex"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "2016.11-toradex-next"

# Hack around building two U-Boot configurations, one with, one without SPL
# if using UBOOT_CONFIG to build more than one configuration, the current code in
# u-boot.inc assumes all are either with or without SPL.
compile_add() {
    if [ -n "${UBOOT_CONFIG}" ]
    then
        for config in ${UBOOT_MACHINE}; do
            touch ${B}/${config}/${SPL_BINARY}
        done
    fi
}
deploy_add() {
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
do_compile_append_mx6() {
    compile_add
}
do_compile_append_use-mainline-bsp() {
    compile_add
}
do_deploy_append_mx6() {
    deploy_add
}
do_deploy_append_use-mainline-bsp() {
    deploy_add
}
