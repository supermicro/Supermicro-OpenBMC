#
# Copyright OpenEmbedded Contributors
#
# SPDX-License-Identifier: MIT
#

from oeqa.runtime.case import OERuntimeTestCase
from oeqa.core.decorator.depends import OETestDepends
from oeqa.runtime.decorator.package import OEHasPackage

class RustCompileTest(OERuntimeTestCase):

    @classmethod
    def setUp(cls):
        dst = '/tmp/'
        src = os.path.join(cls.tc.files_dir, 'test.rs')
        cls.tc.target.copyTo(src, dst)

    @classmethod
    def tearDown(cls):
        files = '/tmp/test.rs /tmp/test'
        cls.tc.target.run('rm %s' % files)
        dirs = '/tmp/hello'
        cls.tc.target.run('rm -r %s' % dirs)

    @OETestDepends(['ssh.SSHTest.test_ssh'])
    @OEHasPackage(['rust'])
    def test_rust_compile(self):
        status, output = self.target.run('rustc /tmp/test.rs -o /tmp/test')
        msg = 'rust compile failed, output: %s' % output
        self.assertEqual(status, 0, msg=msg)

        status, output = self.target.run('/tmp/test')
        msg = 'running compiled file failed, output: %s' % output
        self.assertEqual(status, 0, msg=msg)

    @OETestDepends(['ssh.SSHTest.test_ssh'])
    @OEHasPackage(['cargo'])
    def test_cargo_compile(self):
        status, output = self.target.run('cargo new /tmp/hello')
        msg = 'cargo new failed, output: %s' % output
        self.assertEqual(status, 0, msg=msg)

        status, output = self.target.run('cargo build --manifest-path=/tmp/hello/Cargo.toml')
        msg = 'cargo build failed, output: %s' % output
        self.assertEqual(status, 0, msg=msg)

        status, output = self.target.run('cargo run --manifest-path=/tmp/hello/Cargo.toml')
        msg = 'running compiled file failed, output: %s' % output
        self.assertEqual(status, 0, msg=msg)
