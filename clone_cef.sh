#!/bin/bash

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
TARGET_DIR="${SCRIPT_DIR}/cef"
CEF_REPO_URL="https://github.com/chromiumembedded/cef"

if [ -e "${TARGET_DIR}" ]; then
  echo "${TARGET_DIR} already exists; skipping clone."
  exit 0
fi

git clone "${CEF_REPO_URL}" "${TARGET_DIR}"
