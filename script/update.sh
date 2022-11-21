#!/bin/sh
stty -echo
sleep 1s
kill -9 $1
sleep 1s
rm -rf $2
nohup java -jar $3 >/dev/null 2>log &