SUMMARY = "Opusfile - API for decoding and seeking within .opus files on disk"
LICENSE = "BSD 3-Clause "New" or "Revised"
SECTION = "libs"
DEPENDS = "opus"
PR = "r0"

SRC_URI = "https://github.com/xiph/${PN}/releases/download/v${PV}/${PN}-${PV}.tar.gz \
"

ARM_INSTRUCTION_SET = "arm"

inherit autotools

PACKAGES =+ "libopusfile libopusurl"
FILES_libopusfile = "${libdir}/libopusfile.so.*"
FILES_libopusurl = "${libdir}/libopusurl.so.*"

LEAD_SONAME = "libopusfile.so"

EXTRA_OECONF = " \
    --enable-shared=yes \
    --enable-static=no \
    --enable-fixed-point \
    --disable-float \
    --disable-examples \
    --disable-http \
    --disable-doc \
"


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

