#!/usr/bin/env bash
# Start a jshell session that's loaded with the project's source code and library dependencies.
# NOTE: JShell is awesome.

jshell \
  --feedback normal \
  --startup DEFAULT --startup setup-snippets.jsh \
  --class-path 'out:lib/*' \
  --enable-preview
