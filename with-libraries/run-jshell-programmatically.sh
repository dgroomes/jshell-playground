#!/usr/bin/env bash
# This starts the JShell tool programmatically from an alternative Java main method in the "MainJShellRunner" Java class.

set -eu

java \
  --class-path 'out' \
  --enable-preview \
  dgroomes/MainJShellRunner
