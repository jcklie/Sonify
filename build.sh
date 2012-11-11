#!/bin/sh

mvn clean install eclipse:eclipse assembly:single
chmod a+x target/bragi-sonify-0.6-jar-with-dependencies.jar

