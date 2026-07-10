# Supported platforms

## Release targets

| Operating system | Architecture | Release target |
| --- | --- | --- |
| Linux | x64 | `linux-amd64` |
| Linux | ARM64 | `linux-arm64` |
| Windows | x64 | `windows-amd64` |
| Windows | ARM64 | `windows-arm64` |
| macOS | x64 | `macosx-amd64` |
| macOS | ARM64 | `macosx-arm64` |

Java 17 is the minimum supported Java version.

## Common build requirements

- Git
- CMake 3.21 or newer
- JDK 17 or newer
- Python 3
- Ninja or another supported CMake generator

## Linux

Local builds require a C++ toolchain, GTK 3 development packages, and the
desktop development dependencies required by CEF. Exact package names depend
on the distribution.

Release builds use the Docker environment defined by
`trethore/jcefbuild/scripts/docker/DockerfileLinux`.

## Windows

Local native builds use Visual Studio 2022 with C++ build tools and a matching
Windows SDK. Windows ARM64 releases are cross-compiled by `trethore/jcefbuild`
using the Visual Studio toolchain.

## macOS

Local builds require Xcode, its command-line tools, and Apache Ant for the Java
application bundle. Release builds use GitHub-hosted macOS runners and can
optionally apply signing and notarization.

Support in this document describes the complete project release pipeline. It
does not imply that every target can be built natively from every host system.
