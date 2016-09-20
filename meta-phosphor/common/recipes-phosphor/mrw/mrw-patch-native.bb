SUMMARY = "Phosphor machine readable workbook patching script"
DESCRIPTION = "Retrieve the script that can patch the MRW XML"
PR = "r1"

S = "${WORKDIR}/git"

inherit obmc-phosphor-license
inherit native

DEPENDS += "python-native python-lxml-native"

SRC_URI += "git://github.com/openbmc/phosphor-mrw-tools"
SRCREV = "7a68567af7bf121143ef135152a39723518b6e06"

do_install() {
    install -d ${D}${bindir}/obmc-mrw
    install -m 0755 patchxml.py ${D}${bindir}/obmc-mrw
}
