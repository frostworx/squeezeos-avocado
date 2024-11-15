DESCRIPTION = "Stand Alone SqueezeCenter Package with everything needed"

inherit image

PREFERRED_VERSION_faad2 ?= "2.7"
IMAGE_INSTALL += "squeezecenter faad2 alac flac"

IMAGE_LINGUAS = " "

IMAGE_FSTYPES = "tar.gz"

# remove not needed ipkg informations
ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files"


