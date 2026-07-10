# Repository layout

The source layout intentionally remains close to upstream JCEF.

| Path | Purpose |
| --- | --- |
| `java/org/cef/` | JCEF Java API and Java-side implementation |
| `java/tests/simple/` | Minimal example application |
| `java/tests/detailed/` | Detailed example and feature demonstrations |
| `java/tests/junittests/` | Automated Java tests |
| `native/` | JNI and native C++ implementation |
| `cmake/` | CMake support for obtaining CEF |
| `tools/` | Upstream compile, test, formatting, and packaging scripts |
| `tools/dev/` | Fork-specific developer utilities |
| `third_party/` | Pinned build dependencies and downloaded CEF files |
| `references/` | Ignored source checkouts used for code browsing |
| `jcef_build/` | Generated native build output |
| `binary_distrib/` | Generated binary distributions |

## JNI file relationships

Java classes ending in `_N` contain native-backed implementations. Their JNI
entry points are implemented by related files under `native/`. A JNI API change
commonly requires coordinated updates to:

1. The public Java interface or class.
2. Its Java `_N` implementation.
3. The corresponding native header and implementation.
4. Generated JNI declarations when applicable.
5. Tests or example coverage.

Use `tools/make_jni_header.*` or `tools/make_all_jni_headers.*` instead of
manually maintaining generated declarations.

Upstream-owned files should not be moved for cosmetic reasons. Stable paths
reduce conflicts during upstream synchronization.
