#!/bin/bash


for i in {1..50}
do
	curl -H "Content-Type: application/json" -X POST -d '{"hostName":"Host4","cpu": 0.00}' http://localhost:8080/dump
done

sleep 10s

while true; do 


for i in {1..50}
do
	curl -H "Content-Type: application/json" -X POST -d '{"hostName":"Host4","cpu": 40.5}' http://localhost:8080/dump
done

sleep 10s

for i in {1..50}
do
	curl -H "Content-Type: application/json" -X POST -d '{"hostName":"Host4","cpu": 55.5}' http://localhost:8080/dump
done

sleep 10s

for i in {1..50}
do
	curl -H "Content-Type: application/json" -X POST -d '{"hostName":"Host4","cpu": 85.5}' http://localhost:8080/dump
done

sleep 10s

for i in {1..50}
do
	curl -H "Content-Type: application/json" -X POST -d '{"hostName":"Host4","cpu":99}' http://localhost:8080/dump
done

done
