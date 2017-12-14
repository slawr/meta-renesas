# Do not reload daemon configuration
do_install_append () {
    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)};then
        sed -e 's/\disable/--no-reload \disable/' \
            -i ${D}${systemd_unitdir}/system/opkg-configure.service
    fi
}
