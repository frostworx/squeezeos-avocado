DESCRIPTION = "Open Package Manager"
DESCRIPTION_libopkg = "Open Package Manager Library"
DESCRIPTION_update-alternatives-cworth = "Update alternatives"
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "curl gpgme"
PV = "0.0+svnr${SRCREV}"

SRC_URI = "ENTER_SRC_MIRROR/opkg_svn.openmoko.org_.trunk.src.target._4545_.tar.gz \
           file://fix_prototype.patch;patch=1 \
           file://singleton-status.patch;patch=1"

S = "${WORKDIR}/opkg"

inherit autotools_stage pkgconfig
