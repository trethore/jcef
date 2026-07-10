#!/usr/bin/env python3

import re
import subprocess
import sys
from pathlib import Path
from urllib.parse import unquote


LINK_PATTERN = re.compile(r"!?\[[^]]*\]\(([^)]+)\)")
EXTERNAL_PREFIXES = ("http://", "https://", "mailto:")


def tracked_markdown_files(root: Path) -> list[Path]:
    result = subprocess.run(
        ["git", "ls-files", "*.md"],
        cwd=root,
        check=True,
        capture_output=True,
        text=True,
    )
    return [root / path for path in result.stdout.splitlines()]


def local_target(link: str) -> str | None:
    target = link.strip()
    if not target or target.startswith(EXTERNAL_PREFIXES) or target.startswith("#"):
        return None

    target = target.split(maxsplit=1)[0].strip("<>")
    target = unquote(target.split("#", 1)[0])
    return target or None


def main() -> int:
    root = Path(__file__).resolve().parents[2]
    missing: list[tuple[Path, str]] = []
    files = tracked_markdown_files(root)

    for markdown_file in files:
        content = markdown_file.read_text(encoding="utf-8")
        for match in LINK_PATTERN.finditer(content):
            target = local_target(match.group(1))
            if target is None:
                continue

            resolved = (markdown_file.parent / target).resolve()
            if not resolved.exists():
                missing.append((markdown_file.relative_to(root), match.group(1)))

    if missing:
        for markdown_file, target in missing:
            print(f"{markdown_file}: missing local link target: {target}", file=sys.stderr)
        return 1

    print(f"Checked local links in {len(files)} Markdown files.")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
