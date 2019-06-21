PV = "5.0.0.imx"
LIC_FILES_CHKSUM = "file://COPYING;md5=d79ee9e66bb0f95d3386a7acae780b70 \
                    file://libweston/compositor.c;endline=26;md5=f47553ae598090444273db00adfb5b66"

FILESEXTRAPATHS_prepend := "${THISDIR}/weston:"
SRCBRANCH = "weston-imx-5.0"
SRC_URI = "git://source.codeaurora.org/external/imx/weston-imx.git;protocol=https;branch=${SRCBRANCH} \
           file://weston.png \
           file://weston.desktop \
           file://0001-make-error-portable.patch \
           file://xwayland.weston-start \
           file://0001-weston-launch-Provide-a-default-version-that-doesn-t.patch \
           file://0003-weston-touch-calibrator-Advertise-the-touchscreen-ca.patch \
           file://weston.ini \
"

# Use argb8888 as gbm-format for i.MX8MQ only
SRC_URI_append_mx8mq = " file://0001-weston.ini-using-argb8888-as-gbm-default-on-mscale-8.patch \
                         file://0002-weston.ini-configure-desktop-shell-size-in-weston-co.patch \
"
SRCREV = "fb563901657b296c7c7c86d26602a622429e334f"
