# Do not reload daemon configuration
do_install_append () {
    if ${@bb.utils.contains('DISTRO_FEATURES','sysvinit','false','true',d)};then
        sed -e 's/\disable/--no-reload \disable/' \
            -i ${D}${systemd_unitdir}/system/dpkg-configure.service
    fi
}
