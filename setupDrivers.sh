#!/bin/bash

echo "Beginning driver download and extraction...."

echo "Removing drivers and zip files if they exist...."

rm -rf *.zip
rm -rf *.tar.gz
rm -rf chromedriver
rm -rf geckodriver

echo "Removed existing drivers and zip files...."

echo "Begining download of new drivers...."

uOS=$(uname -s)

if [[ $uOS -eq "Darwin" ]]
then
  echo "Downloading drivers for Mac...."
  wget "https://github.com/mozilla/geckodriver/releases/download/v0.26.0/geckodriver-v0.26.0-macos.tar.gz"
  wget "https://chromedriver.storage.googleapis.com/84.0.4147.30/chromedriver_mac64.zip"
else
  echo "Downloading drivers for Linux"
  wget "https://chromedriver.storage.googleapis.com/84.0.4147.30/chromedriver_linux64.zip"
  wget "https://github.com/mozilla/geckodriver/releases/download/v0.26.0/geckodriver-v0.26.0-linux64.tar.gz"
fi

echo "Download completed...."

echo "Driver extraction begins...."

unzip *.zip
tar -xvzf *.tar.gz

echo "Driver extraction has been completed"
