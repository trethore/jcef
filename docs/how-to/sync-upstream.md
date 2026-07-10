# Synchronize with upstream JCEF

Use this procedure to merge current upstream JCEF changes into the fork while
preserving fork-specific patches.

## 1. Configure the upstream remote

This is only required once:

```sh
git remote add upstream https://github.com/chromiumembedded/java-cef.git
git remote -v
```

The fork should be `origin`; official JCEF should be `upstream`.

## 2. Start from a clean checkout

```sh
git status
git checkout master
```

Commit or stash unrelated work before continuing.

## 3. Fetch and merge upstream

```sh
git fetch upstream
git merge upstream/master
```

Resolve conflicts by preserving upstream structure, then reapply the intent of
fork-specific changes. Avoid unrelated formatting or file moves during the
merge.

## 4. Validate the result

- Review persistent differences against [Fork policy](../explanation/fork-policy.md).
- Run relevant Java and native tests.
- Use `trethore/jcefbuild` when CMake, packaging, platform code, JNI, or the CEF
  version changed.
- Remove fork patches that are now implemented upstream.

## 5. Push the merge

```sh
git push origin master
```

Generally useful fixes should be proposed to the
[upstream JCEF repository](https://github.com/chromiumembedded/java-cef).
