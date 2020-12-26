#!/usr/bin/env bash
# Compile

find src -name "*.java" > sources.txt
javac \
  @sources.txt \
  --class-path "lib/*" \
  -d out \
  --release 15 \
  --enable-preview
