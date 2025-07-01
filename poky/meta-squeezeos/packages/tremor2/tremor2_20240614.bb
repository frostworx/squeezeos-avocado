SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libogg"
DESCRIPTION = "Tremor is a fixed point implementation of the vorbis codec."
LICENSE = "BSD"
SRCDATE = "${PV}"
PR = "r0"

SRC_URI = " \
    ${SQUEEZEOS_SRC_MIRROR}/tremor-${PV}.tar.gz \
    file://tremor2.patch;patch=1 \
"

S="${WORKDIR}/tremor-${PV}"

inherit autotools_stage

EXTRA_OECONF=" --enable-shared=yes --disable-rpath "

ARM_INSTRUCTION_SET = "arm"
