#!/usr/bin/env bash
# Compile

find src -name "*.java" > sources.txt
javac \
  @sources.txt \
  -d out \
  --release 15
