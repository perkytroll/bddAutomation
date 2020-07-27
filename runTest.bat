@echo off
echo "Starting project..."

set TagName=%1

call mvn clean
call mvn compile
call mvn test-compile
call mvn install -Dcucumber.options="--tags @%TagName%"
rem call mvn install -Dtomee.properties=cucumber.options="--tags @%TagName%" -Dcucumber.options="--tags @%TagName%"
rem call mvn install "-Dtomee.properties=cucumber.options=--tags @${TagName}" "-Dcucumber.options=--tags @${TagName}"