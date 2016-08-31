#!/bin/bash


for i in {1..50}
do
	curl -H "Content-Type: application/json" -X POST -d '{"hostName":"Host3","cpu": 0.00}' http://localhost:8080/dump
done

sleep 10s

while true; do


for i in {1..50}
do
	curl -H "Content-Type: application/json" -X POST -d '{"hostName":"Host3","cpu": 20.5}' http://localhost:8080/dump
done

sleep 10s

for i in {1..50}
do
	curl -H "Content-Type: application/json" -X POST -d '{"hostName":"Host3","cpu": 35.5}' http://localhost:8080/dump
done

sleep 10s

for i in {1..50}
do
	curl -H "Content-Type: application/json" -X POST -d '{"hostName":"Host3","cpu": 60.5}' http://localhost:8080/dump
done

sleep 10s

for i in {1..50}
do
	curl -H "Content-Type: application/json" -X POST -d '{"hostName":"Host3","cpu": 79}' http://localhost:8080/dump
done

done
