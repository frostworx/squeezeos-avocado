
to run the dev environement and simultaneously host locally the source mirror
clone the main project with submodules (`git clone --recurse-submodules https://github.com/frostworx/squeezeos-avocado.git`),
so the `squeezeos-avocado-poky-src-mirror` is pulled as well
then follow the general usage under `README` - the `SQUEEZEOS_SRC_MIRROR` configuration can be ignored,
both containers communicate directly using `http://nginx/poky-cache` as url

start the containers with

`docker-compose -f docker-compose-with-src-mirror.yml up -d --remove-orphans`
