SUMMARY = "Test recipe for testing rpm generated by oe-core"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

LICENSE = "MIT"

SRC_URI = "file://testfile.txt"
INHIBIT_DEFAULT_DEPS = "1"

do_compile(){
	echo "testdata" > ${B}/"file with [brackets].txt"
	echo "testdata" > ${B}/"file with (parentheses).txt"
}

do_install(){
	install ${B}/* ${D}/
}

FILES:${PN} = "*"
