INI_UNCOMMENT_ASSIGNMENTS_append_mx8 = " \
    use-g2d=1 \
"


uncomment() {
    # already uncommented, do nothing
    if ! (grep "^$1" $2); then
        if ! (grep "^#$1" $2); then
            bbfatal "Commented setting '#$1' not found in file $2"
        fi
        sed -i -e 's,^#'"$1"','"$1"',g' $2
    fi
}


configure_noidle() {
    sed -i '/idle-time=0/d' ${D}${sysconfdir}/xdg/weston/weston.ini
    sed -i '/^\[core\]/a idle-time=0' ${D}${sysconfdir}/xdg/weston/weston.ini
}

# Prevent weston from going to sleep
do_install_append_upstream() {
    configure_noidle
}

configure_pixman() {
    sed -i '/use-pixman=true/d' ${D}${sysconfdir}/xdg/weston/weston.ini
    sed -i '/^\[core\]/a use-pixman=true' ${D}${sysconfdir}/xdg/weston/weston.ini
}

# With upstream weston and modules without GPU weston uses a lot of
# cpu time and becomes very unresponsive. Setting use-pixman=true works
# around it.
do_install_append_upstream_colibri-imx6ull() {
    configure_pixman
}

do_install_append_upstream_colibri-imx6ull-emmc() {
    configure_pixman
}

do_install_append_upstream_colibri-imx7() {
    configure_pixman
}

do_install_append_upstream_colibri-imx7-emmc() {
    configure_pixman
}

# openembedded-core commit 4efdcc1090 ("weston: Use systemd notify,")
# forces systemd-notify which in our setup does not work. Uncomment the
# relevant lines for now.
do_install_append() {
    sed -i 's/\(Type=notify\)/# \1/' ${D}${systemd_system_unitdir}/weston@.service
    sed -i 's/\(NotifyAccess=all\)/# \1/' ${D}${systemd_system_unitdir}/weston@.service
}
