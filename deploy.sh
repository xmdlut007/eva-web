#!/bin/zsh

set -x
set -e
mvn -U clean install
TOMCAT_PATH=/usr/local/Cellar/tomcat/8.5.3/libexec/webapps
rm -rf $TOMCAT_PATH/eva-web-0.0.1-SNAPSHOT
cp -rf ./target/eva-web-0.0.1-SNAPSHOT $TOMCAT_PATH
