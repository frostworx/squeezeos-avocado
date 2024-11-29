SUMMARY = "The SoX Resampler library"
HOMEPAGE = "https://sourceforge.net/projects/soxr/"
LICENSE = "LGPLv2.1"

PR=r1

inherit cmake

SRC_URI = " \
    http://ralph.irving.sdf.org/squeezeos/${PN}-${PV}-Source.tar.gz \
    file://fix-cmake-set-project-version.patch;patch=1 \
"

ARM_INSTRUCTION_SET = "arm"

S = "${WORKDIR}/${PN}-${PV}-Source"

EXTRA_OECMAKE += " \
    -DCMAKE_BUILD_TYPE=Release \
    -DWITH_OPENMP=OFF \
    -DBUILD_TESTS=OFF \
    -DWITH_LSR_BINDINGS=OFF \
    -DBUILD_SHARED_LIBS=ON \
    -DBUILD_EXAMPLES=OFF \
    -DWITH_VR32=OFF \
    -DWITH_CR32=OFF \
    -DWITH_CR64=OFF \
    -DWITH_CR64S=OFF \
    -DWITH_CR32S=OFF \
    -DWITH_PFFFT=OFF \
    -Wno-dev \
"

do_install_append() {
	chmod 755 ${D}${layout_libdir}/libsoxr.so.0\.*
}

do_stage() {
        autotools_stage_all
}
