DESCRIPTION = "lightweight hotkey daemon"
HOMEPAGE = "https://github.com/wertarbyte/triggerhappy"
LICENSE = "GPLv3"
PR = "r0"

DEPENDS = " \
"

RDEPENDS_${PN} += " \
"

SRC_URI = " \
    http://nginx/poky-cache/${PN}-${PV}.tar.gz \
	file://baby.conf \
	file://hassio.conf-template \
	file://hassio-keypress-send \
"

S="${WORKDIR}/${PN}-release-${PV}"

do_make() { 
	oe_runmake
} 

do_install() { 
	install -d ${D}${bindir}
	install -m 755 ${S}/thd ${D}${bindir}/thd
	install -m 755 ${S}/th-cmd ${D}${bindir}/th-cmd
	install -m 755 ${WORKDIR}/hassio-keypress-send ${D}${bindir}/hassio-keypress-send
    install -d ${D}/etc/triggerhappy/triggers.d
	install -m 755 ${WORKDIR}/baby.conf ${D}/etc/triggerhappy/triggers.d
	install -m 755 ${WORKDIR}/hassio.conf-template ${D}/etc/
}

FILES_${PN} = "/usr/bin/thd \
/usr/bin/th-cmd \
/usr/bin/hassio-keypress-send \
/etc/triggerhappy/triggers.d/baby.conf \
/etc/hassio.conf-template \
"
