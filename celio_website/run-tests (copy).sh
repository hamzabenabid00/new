#!/usr/bin/env bash
# ──────────────────────────────────────────────────────────────────────────
#  run-tests.sh — one command to build + run the whole Celio test stack.
#
#  What it does:
#    1. Builds the test image from Dockerfile (if anything changed).
#    2. Starts the Firefox (Selenium Grid) container AND the tests container.
#    3. Stops everything when the tests finish (--abort-on-container-exit).
#    4. Exits with the tests' pass/fail code (--exit-code-from tests),
#       so CI / your terminal shows green or red correctly.
#
#  Usage:
#    ./run-tests.sh            # build + run
#    ./run-tests.sh --no-build # run without rebuilding
# ──────────────────────────────────────────────────────────────────────────
set -euo pipefail

cd "$(dirname "$0")"

BUILD_FLAG="--build"
if [[ "${1:-}" == "--no-build" ]]; then
  BUILD_FLAG=""
fi

echo "==> Starting Firefox + Celio test suite"
docker compose up $BUILD_FLAG \
  --abort-on-container-exit \
  --exit-code-from tests \
  --remove-orphans

status=$?
echo "==> Tests finished with exit code ${status}"
exit $status
