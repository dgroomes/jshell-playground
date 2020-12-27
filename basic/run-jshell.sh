#!/usr/bin/env bash
# Load the application source code into a jshell session.
# Note: jshell is awesome! I wish I had jshell when I started learning Java.

jshell \
  --feedback verbose \
  --startup DEFAULT \
  --class-path 'out'
