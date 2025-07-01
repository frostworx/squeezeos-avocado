# squeezeos-avocado

*WIP* (first builds worked fine, but not ready yet)

Custom squeezeos fork with multiple cleanups, which allows to build squeezebox firmware files from a docker container without the need of setting up a fully bloated ancient vm.

## Changes

### cleanups in source urls
  intruducing a `SQUEEZEOS_SRC_MIRROR` variable, meant to be a generic url for all source packages, which are
   - no longer available upstream
   - complicated/impossible to download in an ancient linux distro (ssl problems)
   - don't have a valid home

Ideally those files are hosted by a squeezeos community (maybe lyrion.org?)
For now there is no public url hosting those files (I might add a separate git project for the beginning later),
so defaults to my local http://192.168.2.4:8730/poky-cache

### docker support
Yes, finally the squeezeos firmware can be built completely in a docker container.
Implementation is a bit rough for now, but already works fine (successfully built working 'baby' firmwares).


see README in the docker subdirectory for details

I'm undecided yet where to go from here.

For now I simply use it to have an easy to use and clean as possible dev encironment to possibly
work on my own home assistant (hassio -> therefore 'avocado') customizations.
