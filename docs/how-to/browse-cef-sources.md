# Browse CEF sources

Use the fork-specific helper to create a reference checkout of the CEF source:

```sh
tools/dev/clone_cef_reference.sh
```

The source is cloned to:

```text
references/cef
```

This directory is ignored by Git and is useful for:

- Comparing JCEF bindings with the CEF C++ API.
- Finding declarations and implementation details.
- Debugging behavior across the JNI boundary.
- AI-assisted code exploration.

The reference checkout is not used by the JCEF build. CMake downloads a CEF
binary distribution under `third_party/cef/` for compilation.

## Update the checkout

The clone helper does not modify an existing checkout. Update it directly:

```sh
git -C references/cef fetch origin
git -C references/cef checkout master
git -C references/cef pull --ff-only
```

To start over, remove `references/cef` and run the helper again.
