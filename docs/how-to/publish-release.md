# Publish a release

Releases move through `trethore/jcef`, `trethore/jcefbuild`, and
`trethore/jcefgithub`. Do not publish local `binary_distrib/` output directly.

## 1. Select the source revision

Merge the desired upstream revision and fork patches into `trethore/jcef`.
Record the exact branch, tag, or commit to build.

## 2. Build native distributions

Run the manually dispatched `build` workflow in `trethore/jcefbuild` with:

- `jcef_repo` set to the source repository.
- `jcef_ref` set to the selected revision.
- `platform` set to `all` for a complete release.
- `dry_run` enabled for validation or disabled to create a release.
- `sign_macosx` enabled when signed macOS artifacts are required.

Verify all six outputs:

- `linux-amd64`
- `linux-arm64`
- `windows-amd64`
- `windows-arm64`
- `macosx-amd64`
- `macosx-arm64`

## 3. Verify build metadata

Confirm that the native release includes `build_meta.json` and that it points
to the intended JCEF source revision and build.

## 4. Generate Maven artifacts

Run the `publish` workflow in `trethore/jcefgithub` with:

- `build_meta` set to the published metadata URL.
- `mvn_version` set to the intended artifact version.
- `publish_target` set to `github`, `maven`, or `both`.

## 5. Verify publication

Check:

- The GitHub release and attached JARs.
- GitHub Packages when selected.
- Maven Central when selected.
- API, wrapper, and each native platform artifact.
- Runtime native resolution on representative platforms.

See the [release pipeline reference](../reference/release-pipeline.md) for the
artifacts and repository responsibilities involved.
