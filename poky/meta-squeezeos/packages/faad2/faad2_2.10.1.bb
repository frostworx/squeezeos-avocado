DESCRIPTION = "Freeware Advanced Audio (AAC) Decoder library"
SECTION = "libs"
LICENSE = "GPL"

PR="r0"

SRC_URI = " \
https://github.com/knik0/faad2/archive/refs/tags/${PV}.tar.gz \
file://forcedrmdisable.patch;patch=1 \
"

S="${WORKDIR}/${PN}-${PV}"

ARM_INSTRUCTION_SET = "arm"
CFLAGS_prepend = "-DFIXED_POINT=1 "
EXTRA_OECONF = "--with-drm=no --with-drc=no --with-mpeg4ip=no --with-xmms=no"

PACKAGES =+ "libfaad"
FILES_libfaad = "${libdir}/libfaad.so.*"

inherit autotools

do_stage() {
	autotools_stage_all
}

