# JCEF

This repository is a fork of the [Java Chromium Embedded
Framework (JCEF)](https://github.com/chromiumembedded/java-cef).

This fork exists to maintain a small set of patches (Java 17+, game-specific
APIs). Its original motivation is to integrate an embedded Chromium browser
into Minecraft Java.

## What about the upstream?

1. Upstream JCEF changes are merged regularly.
2. Fork-specific patches are kept small and isolated where practical.
3. The upstream `java/`, `native/`, `tools/`, and build layouts are preserved to
   reduce merge conflicts.
4. Fixes that are useful to the wider JCEF project should still be proposed
   upstream when appropriate.

See [Fork policy](docs/explanation/fork-policy.md) and [Synchronize with
upstream JCEF](docs/how-to/sync-upstream.md) for more information.

## Supported environments

| Environment | Supported versions and architectures |
| --- | --- |
| Java | 17 or newer |
| Linux | x64 and ARM64 |
| Windows | x64 and ARM64 |
| macOS | x64 and ARM64 |

## Project repositories

| Repository | Responsibility |
| --- | --- |
| [`trethore/jcef`](https://github.com/trethore/jcef) | Upstream JCEF source plus fork patches |
| [`trethore/jcefbuild`](https://github.com/trethore/jcefbuild) | Multi-platform native builds and binary distributions |
| [`trethore/jcefgithub`](https://github.com/trethore/jcefgithub) | Maven artifacts, GitHub Packages, Maven Central, and runtime native loading |

For normal Maven or Gradle use, see `trethore/jcefgithub`. This repository
primarily acts as patched source code for my experiments with JCEF.

## Building

JCEF combines Java, JNI, C++, CEF binary distributions, and platform-specific
toolchains. See [Your first local JCEF build](docs/tutorials/first-local-build.md)
for a guided introduction or [Build JCEF](docs/how-to/build-jcef.md) for the
command reference.
Reproducible release builds are produced by `trethore/jcefbuild`.

## Documentation

Documentation starts [HERE](docs/README.md)!

## Support and issue routing

Please respect this routing to avoid annoying the wrong people!

- Fork source patches and Minecraft-related integration requirements -> this repository
- Native build and CI failures -> [`trethore/jcefbuild`](https://github.com/trethore/jcefbuild/issues)
- Maven artifacts and runtime native loading -> [`trethore/jcefgithub`](https://github.com/trethore/jcefgithub/issues)
- General JCEF defects -> [upstream JCEF issue tracker](https://github.com/chromiumembedded/java-cef/issues)
- JCEF and CEF usage questions -> [CEF Forum](https://magpcss.org/ceforum/viewforum.php?f=17)

## License

JCEF is distributed under the BSD-style license in [LICENSE.txt](LICENSE.txt).
