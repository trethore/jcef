# Fork policy

This repository follows upstream JCEF while maintaining a small set of changes
needed by its Java baseline, build pipeline, and Minecraft integration goals.

## Why preserve the upstream layout?

Upstream synchronization is a recurring maintenance task. Moving Java,
native, tooling, or third-party files for cosmetic reasons would turn ordinary
upstream merges into repeated structural conflicts. The fork therefore
modernizes documentation and external automation while retaining upstream's
source and build layout.

## Long-term differences

- Java 17 is the minimum supported Java version.
- Release artifacts cover Linux, Windows, and macOS on x64 and ARM64.
- Multi-platform native builds live in `trethore/jcefbuild`.
- Maven packaging and runtime native loading live in `trethore/jcefgithub`.
- Fork patches may expose capabilities needed by game integrations.

## Patch policy

- Keep persistent fork patches focused and independently reviewable.
- Avoid unrelated formatting changes in upstream-owned files.
- Remove a fork patch when an equivalent upstream fix is merged.
- Propose generally useful fixes to upstream JCEF.
- Keep Minecraft-version-specific mod code outside this repository.

Git history remains the source of truth for individual code changes. This page
describes policy and intentional differences rather than duplicating a commit
changelog.
