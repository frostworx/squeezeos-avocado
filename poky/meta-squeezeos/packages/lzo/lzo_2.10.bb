DESCRIPTION = "Lossless data compression library"
HOMEPAGE = "http://www.oberhumer.com/opensource/lzo/"
LICENSE = "GPLv2"
SECTION = "libs"
PRIORITY = "optional"
PR = "r0"

SRC_URI = " \
	http://www.oberhumer.com/opensource/lzo/download/lzo-${PV}.tar.gz \
"
inherit autotools_stage pkgconfig

EXTRA_OECONF = "--enable-shared"

do_configure () {
	${S}/configure \
	--build=${BUILD_SYS} \
	--host=${HOST_SYS} \
	--target=${TARGET_SYS} \
	--prefix=${prefix} \
	--exec_prefix=${exec_prefix} \
	--bindir=${bindir} \
	--sbindir=${sbindir} \
	--libexecdir=${libexecdir} \
	--datadir=${datadir} \
	--sysconfdir=${sysconfdir} \
	--sharedstatedir=${sharedstatedir} \
	--localstatedir=${localstatedir} \
	--libdir=${libdir} \
	--includedir=${includedir} \
	--oldincludedir=${oldincludedir} \
	--infodir=${infodir} \
	--mandir=${mandir} \
	${EXTRA_OECONF} \
}

do_stage() {
	autotools_stage_all
}
