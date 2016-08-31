
# Data visualization with Influxdb and Grafana

Purpose: Showing how one can use Influxdb and Grafana to display custom graphs.

How this system works is that there is a Akka http REST interface that we can send a request to. As parameters we can send a hostname and a CPU value. Then the request is sent into Influxdb.
We can then use Grafana with Influxdb as the datasource and create the graphs below.


![Grafana](images/datavisualyappl.png)



----

## Scala & Influxdb client

## TODO

1. How to set up the influxdb + grafana using docker
2. Loading the influxdb with data
3. How to set up the graphs
