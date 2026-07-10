# Build architecture

JCEF combines Java, JNI, native C++, CEF binary distributions, and
platform-specific packaging. Separating source maintenance from native builds
and Maven publishing keeps each workflow focused.

```text
trethore/jcef source revision
        |
        v
trethore/jcefbuild
        |-- Linux x64 and ARM64 distributions
        |-- Windows x64 and ARM64 distributions
        |-- macOS x64 and ARM64 distributions
        |-- build_meta.json
        `-- Javadocs
        |
        v
trethore/jcefgithub
        |-- JCEF API artifact
        |-- platform-native artifacts
        |-- runtime wrapper artifact
        |-- GitHub Packages
        `-- Maven Central
```

## Why Maven is not the primary source build

Upstream JCEF uses CMake, Ant, and its own distribution scripts. Those tools
also handle native output, resources, samples, tests, Javadocs, and the macOS
application bundle. Replacing them in the source fork would increase upstream
merge cost and risk breaking the native release process.

Maven therefore belongs in `trethore/jcefgithub`, after native distributions
have been built. This provides Maven and Gradle consumption without changing
the upstream-compatible source workflow.

## Why releases use separate CI

Building six large CEF distributions requires different hosts, containers,
cross-compilation, and optional macOS signing. Keeping that work in
`trethore/jcefbuild` prevents the source repository from carrying a large,
fork-specific CI implementation and makes native builds independently
repeatable.

For exact workflow inputs and outputs, see the [release pipeline
reference](../reference/release-pipeline.md).
