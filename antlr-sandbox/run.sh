#!/usr/bin/env bash

cd src/main/java/

protoc --java_out=. selector/proto/schema.proto

cd selector/
javac *.java

cd ..
java selector.SelectorSample

cd ../../../..