@echo off

set chrome_driver_win64=https://chromedriver.storage.googleapis.com/84.0.4147.30/chromedriver_win32.zip
set gecko_driver_win64=https://github.com/mozilla/geckodriver/releases/download/v0.24.0/geckodriver-v0.24.0-win64.zip

echo "Removing existing drivers (if any)"

if exist *.{gz,zip}* del /f *.{gz,zip}*
if exist gecko* del /f gecko*
if exist chromedriver* del /f chromedriver*
if exist *.jar del /f *.jar

echo "Downloading drivers for Windows"

curl -LO %chrome_driver_win64%
curl -LO %gecko_driver_win64%

echo "Download Complete, Beginning extraction......."

for /R %%I in ("*.zip") do (
  "%ProgramFiles%\7-Zip\7z.exe" x -y -o"%%~dpI" "%%~fI" 
)

echo "Extraction Complete"