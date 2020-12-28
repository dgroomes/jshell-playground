#!/usr/bin/env bash
# Start a jshell session that's loaded with the project's source code and library dependencies.
# NOTE: jshell is awesome.

jshell \
  --feedback verbose \
  --startup DEFAULT --startup setup-snippets.jsh \
  --class-path 'out:lib/*' \
  --enable-preview
