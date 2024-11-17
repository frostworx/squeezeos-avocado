SUMMARY = "Opus - codec for interactive speech and audio transmission"
LICENSE = "Modified (2-clause or 3-clause) BSD or Clear BSD"
SECTION = "libs"
DEPENDS = "libogg"
PR = "r0"

SRC_URI = "https://github.com/xiph/${PN}/releases/download/v${PV}/${PN}-${PV}.tar.gz \
    file://autoconf261.patch;patch=1 \
"

ARM_INSTRUCTION_SET = "arm"

inherit autotools 

do_stage() {
        autotools_stage_all
}

EXTRA_OECONF = " \
    --enable-shared=yes \
    --enable-static=no \
    --enable-fixed-point \
    --disable-float-api \
    --disable-extra-programs \
    --disable-doc \
"

