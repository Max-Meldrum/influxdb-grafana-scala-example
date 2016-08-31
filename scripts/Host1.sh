#!/bin/bash


for i in {1..50}
do
	curl -H "Content-Type: application/json" -X POST -d '{"hostName":"Host1","cpu": 0.00}' http://localhost:8080/dump
done

sleep 10s

while true; do 


for i in {1..50}
do
	curl -H "Content-Type: application/json" -X POST -d '{"hostName":"Host1","cpu": 25.5}' http://localhost:8080/dump
done

sleep 10s

for i in {1..50}
do
	curl -H "Content-Type: application/json" -X POST -d '{"hostName":"Host1","cpu": 40.5}' http://localhost:8080/dump
done

sleep 10s

for i in {1..50}
do
	curl -H "Content-Type: application/json" -X POST -d '{"hostName":"Host1","cpu": 75.5}' http://localhost:8080/dump
done

sleep 10s

for i in {1..50}
do
	curl -H "Content-Type: application/json" -X POST -d '{"hostName":"Host1","cpu": 90}' http://localhost:8080/dump
done

done
