# Release pipeline reference

## Repository responsibilities

| Repository | Input | Output |
| --- | --- | --- |
| `trethore/jcef` | Upstream JCEF plus fork patches | Source revision |
| `trethore/jcefbuild` | JCEF repository and Git ref | Native archives, Javadocs, license, and `build_meta.json` |
| `trethore/jcefgithub` | `build_meta.json` and Maven version | API, wrapper, native Maven artifacts, and releases |

## Native targets

- `linux-amd64.tar.gz`
- `linux-arm64.tar.gz`
- `windows-amd64.tar.gz`
- `windows-arm64.tar.gz`
- `macosx-amd64.tar.gz`
- `macosx-arm64.tar.gz`

## `trethore/jcefbuild` workflow inputs

| Input | Purpose |
| --- | --- |
| `jcef_repo` | JCEF repository to clone |
| `jcef_ref` | Branch, tag, or commit to build |
| `platform` | One target or all targets |
| `sign_macosx` | Enable macOS signing and notarization workflow |
| `dry_run` | Build artifacts without creating a release |

Linux and Windows builds use Docker-backed environments. macOS builds use
GitHub-hosted runners. Windows ARM64 is produced using Visual Studio
cross-compilation.

## `trethore/jcefgithub` workflow inputs

| Input | Purpose |
| --- | --- |
| `build_meta` | URL of the native build metadata |
| `mvn_version` | Version assigned to generated Maven artifacts |
| `publish_target` | GitHub Packages, Maven Central, or both |

The generated artifacts include the JCEF API, per-platform native bundles, the
runtime wrapper, and the relocated wrapper variant.
