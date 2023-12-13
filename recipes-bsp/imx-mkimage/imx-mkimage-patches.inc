FILESEXTRAPATHS:prepend := "${THISDIR}/files/:"

# additional patches addressing U-Boot secure boot SPL Authentication Vulnerability (CVE-2023-39902)
# (plus patches LFU-573* in downstream U-Boot)
SRC_URI:append = " \
    file://0001-LFOPTEE-126-Add-spl-and-sld-Blocks-info.patch \
    file://0002-LFU-573-1-imx8m-Generate-hash-of-FIT-FDT-structure-t.patch\
    file://0003-LFU-573-2-imx8m-Reserve-new-IVT-CSF-for-FIT-FDT-sign.patch \
"
