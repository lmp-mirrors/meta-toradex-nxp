# Copyright (C) 2016 Toradex AG
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Deploys Vivante GPU libraries, even if no package RDEPENDS on them"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
    libgl-mx6 \
    libgles-mx6 \
    libgles2-mx6 \
    libopenvg-mx6 \
    libvdk-mx6 \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'xserver-xorg-extension-viv-autohdmi', \
                                                       '', d), d)} \
"
