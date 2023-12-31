SRC_URI:remove = " \
                  file://0003-core-link-add-no-warn-rwx-segments.patch \
                  file://0007-core-spmc-handle-non-secure-interrupts.patch \
                  file://0008-core-spmc-configure-SP-s-NS-interrupt-action-based-o.patch \
                 "

COMPATIBLE_MACHINE = "corstone1000"

OPTEEMACHINE = "corstone1000"
# Enable optee memory layout and boot logs
EXTRA_OEMAKE += " CFG_TEE_CORE_LOG_LEVEL=4"

# default disable latency benchmarks (over all OP-TEE layers)
EXTRA_OEMAKE += " CFG_TEE_BENCHMARK=n"

EXTRA_OEMAKE += " CFG_CORE_SEL1_SPMC=y CFG_CORE_FFA=y"

EXTRA_OEMAKE += " CFG_WITH_SP=y"
