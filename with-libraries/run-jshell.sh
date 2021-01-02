#!/usr/bin/env bash
# Start a jshell session that's loaded with the project's source code and library dependencies.
# NOTE: JShell is awesome.
#
# Optionally pass the option "--debug" and the Java process running the JShell tool itself will start in the debugging
# mode and will be suspended until a remote debugger is attached.

set -e

opts=(
--feedback normal
--startup DEFAULT --startup setup-snippets.jsh
--class-path 'out:lib/*'
--enable-preview
)

if [[ "x$1" == "x--debug" ]]; then
  echo "'debug' flag detected. JShell will be started in debug mode"
  opts+=('-J-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005')
fi

set -u

jshell "${opts[@]}"
