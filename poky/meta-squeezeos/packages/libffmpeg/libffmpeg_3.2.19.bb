SUMMARY = "FFmpeg (Hypatia) alac and wma codecs only library"
LICENSE = "LGPLv3"

SRC_URI = "https://www.ffmpeg.org/releases/ffmpeg-${PV}.tar.bz2 \
	file://alac.patch;patch=0 \
	file://wmapro.patch;patch=0 \
	file://configure-die-unknown-option.patch;patch=1 \
"

ARM_INSTRUCTION_SET = "arm"

S = "${WORKDIR}/ffmpeg-${PV}"

inherit autotools

do_stage() {
        autotools_stage_all
}

EXTRA_OECONF = " \
    --cross-prefix=${TARGET_PREFIX} \
    --arch=${TARGET_ARCH} \
    --target-os="linux" \
    --enable-cross-compile \
    --enable-hardcoded-tables \
    --disable-debug \
    --disable-avdevice \
    --disable-avfilter \
    --disable-swscale \
    --disable-swresample \
    --disable-ffmpeg \
    --disable-ffplay \
    --disable-ffserver \
    --disable-ffprobe \
    --disable-network \
    --disable-muxers \
    --disable-demuxers \
    --disable-hwaccels \
    --enable-rdft \
    --enable-demuxer=asf \
    --enable-demuxer=mov \
    --disable-bsfs \
    --disable-filters \
    --disable-parsers \
    --disable-protocols \
    --enable-protocol=file \
    --enable-protocol=pipe \
    --enable-protocol=cache \
    --disable-indevs \
    --disable-outdevs \
    --disable-encoders \
    --disable-decoders \
    --enable-decoder=alac \
    --enable-decoder=mjpeg \
    --enable-decoder=mjpegb \
    --enable-decoder=wmalossless \
    --enable-decoder=wmapro \
    --enable-decoder=wmav1 \
    --enable-decoder=wmav2 \
    --enable-decoder=wmavoice \
    --disable-runtime-cpudetect \
    --enable-shared \
    --disable-static \
    --disable-iconv \
    --disable-postproc \
    --disable-sdl \
    --disable-doc \
    --disable-podpages \
    --enable-gpl \
    --enable-version3 \
    --disable-x11grab \
    --disable-xlib \
    --disable-zlib \
    --disable-bzlib \
    --disable-dxva2 \
    --disable-fontconfig \
    --disable-libass \
    --disable-libbluray \
    --disable-libfreetype \
    --disable-libgsm \
    --disable-libmodplug \
    --disable-libmp3lame \
    --disable-libopencore_amrnb \
    --disable-libopencore_amrwb \
    --disable-libopenjpeg \
    --disable-libopus \
    --disable-libpulse \
    --disable-librtmp \
    --disable-libschroedinger \
    --disable-libspeex \
    --disable-libtheora \
    --disable-libv4l2 \
    --disable-libvorbis \
    --disable-libvpx \
    --disable-libx264 \
    --disable-libxvid \
    --disable-libxcb \
    --disable-libxcb-shm \
    --disable-libxcb-xfixes \
    --disable-libxcb-shape \
    --disable-vdpau \
"

