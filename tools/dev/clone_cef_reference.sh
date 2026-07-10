#!/usr/bin/env bash

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT_DIR="$(cd "${SCRIPT_DIR}/../.." && pwd)"
TARGET_DIR="${ROOT_DIR}/references/cef"
CEF_REPO_URL="https://github.com/chromiumembedded/cef"

if [ -e "${TARGET_DIR}" ]; then
  echo "${TARGET_DIR} already exists; skipping clone."
  exit 0
fi

mkdir -p "$(dirname "${TARGET_DIR}")"
git clone "${CEF_REPO_URL}" "${TARGET_DIR}"
