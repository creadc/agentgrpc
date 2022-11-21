@echo off
@ping 127.0.0.1 -n 2 & taskkill /f /t /im %1 & ping 127.0.0.1 -n 2 & del/f/s/q %2 & start javaw -jar %3
exit