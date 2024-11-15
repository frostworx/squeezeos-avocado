SUMMARY = "Audio decoder for MPEG-1 Layer 1/2/3"
LICENSE = "LGPLv2.1"

SRC_URI = "https://www.mpg123.de/download/${PN}-${PV}.tar.bz2 \
	file://autoconf261.patch;patch=1 \
"

ARM_INSTRUCTION_SET = "arm"

PACKAGES =+ "libmpg123 libout123"
FILES_libmpg123 = "${libdir}/libmpg123.so.*"
FILES_libout123 = "${libdir}/libout123.so.*"

inherit autotools 

do_stage() {
        autotools_stage_all
}

EXTRA_OECONF = " \
    --enable-modules=no \
    --enable-shared=yes \
    --enable-static=no \
    --with-default-audio=dummy \
    --with-audio=dummy \
    --with-cpu=arm_nofpu \
"

LEAD_SONAME = "libmpg123.so"

