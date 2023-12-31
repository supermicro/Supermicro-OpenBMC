SUMMARY = "To merge the Host and BMC config files generated from MRW "
DESCRIPTION = "Merge host provided FRU info config file, fru info config, \
which is not sent by host config, and BMC accessible FRU info config \
files generated by gen-ipmi-fru.pl into a single config file. \
fru-gen parser parses the merged config file and generates cpp file"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
DEPENDS += "virtual/phosphor-ipmi-fru-read-inventory"
PROVIDES += "virtual/phosphor-ipmi-fru-merge-config"
PR = "r1"

inherit phosphor-ipmi-host
inherit native

do_install:append() {
  SRC=${config_datadir}
  DEST=${D}${config_datadir}
  install -d ${DEST}
  cat ${SRC}/config.yaml > ${DEST}/fru_config.yaml
}
