FROM scratch
ADD rootfs.tar.xz /
ADD 20230114-updated-utilities-i386.tar.tgz /usr/local
COPY sources.list /etc/apt/sources.list
RUN apt-get update && apt-get upgrade -y
RUN groupadd -g 1000 -o user
RUN useradd -m -u 1000 -g 1000 -o -s /bin/bash user
RUN dpkg-reconfigure -p critical dash
RUN apt-get install g++ git-core build-essential python diffstat texinfo  texi2html cvs subversion wget gawk help2man libx11-dev libsdl1.2-dev xmlto curl libcurl4-openssl-dev zip -y
RUN apt-get install sudo -y # DBG
RUN echo "%user ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers # DBG
RUN echo "dash dash/sh boolean false" | debconf-set-selections
RUN DEBIAN_FRONTEND=noninteractive dpkg-reconfigure dash

CMD ["/bin/bash"]
