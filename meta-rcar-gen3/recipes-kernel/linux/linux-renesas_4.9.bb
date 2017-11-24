DESCRIPTION = "Linux kernel for the R-Car Generation 3 based board"

require include/avb-control.inc
require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/:"
COMPATIBLE_MACHINE = "salvator-x|h3ulcb|m3ulcb"

RENESAS_BSP_URL = "git://git.kernel.org/pub/scm/linux/kernel/git/horms/renesas-bsp.git"
BRANCH = "v4.9/rcar-3.5.8"
SRCREV = "bef6058b0ba00238b19e7518ba76536218ef97f1"

SRC_URI = "${RENESAS_BSP_URL};protocol=git;nocheckout=1;branch=${BRANCH}"

LINUX_VERSION ?= "4.9.0"
PV = "${LINUX_VERSION}+git${SRCPV}"
PR = "r1"

SRC_URI_append = " \
    file://defconfig \
    file://touch.cfg \
    ${@base_conditional("USE_AVB", "1", " file://usb-video-class.cfg", "", d)} \
"
