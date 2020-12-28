#!/usr/bin/env bash
# Load the application source code into a jshell session.
# Note: JShell is awesome! I wish I had JShell when I started learning Java.

jshell \
  --feedback verbose \
  --startup DEFAULT \
  --class-path 'out'
