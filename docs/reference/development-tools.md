# Development tools

## Build and run

| Tool | Purpose |
| --- | --- |
| `tools/compile.sh`, `tools/compile.bat` | Compile Java sources |
| `tools/run.sh`, `tools/run.bat` | Launch the simple or detailed sample |
| `tools/run_tests.sh`, `tools/run_tests.bat` | Run automated tests |
| `tools/make_jar.sh`, `tools/make_jar.bat` | Build JCEF Java archives |
| `tools/make_distrib.sh`, `tools/make_distrib.bat` | Assemble a binary distribution |
| `tools/make_docs.sh`, `tools/make_docs.bat` | Generate Javadocs |

## JNI generation

| Tool | Purpose |
| --- | --- |
| `tools/make_jni_header.sh`, `tools/make_jni_header.bat` | Generate a JNI header for one class |
| `tools/make_all_jni_headers.sh`, `tools/make_all_jni_headers.bat` | Regenerate all JNI headers |

## Formatting

| Tool | Purpose |
| --- | --- |
| `tools/fix_style.sh`, `tools/fix_style.bat` | Apply repository formatting |
| `tools/fix_style.py` | Formatting implementation used by the wrappers |

## Fork-specific utilities

| Tool | Purpose |
| --- | --- |
| `tools/dev/clone_cef_reference.sh` | Clone CEF source into ignored `references/cef` for browsing |
| `tools/dev/check_markdown_links.py` | Validate local links in tracked Markdown files |

Generated output belongs in `jcef_build/`, `out/`, or `binary_distrib/` and is
ignored by Git.
