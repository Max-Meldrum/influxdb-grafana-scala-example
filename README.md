
# Data visualization with InfluxDB and Grafana

Purpose: Showing how one can use InfluxDB and Grafana to display custom graphs.

How this system works is that there is a Akka http REST interface that we can send a request to. As parameters we can send a hostname and a CPU value. Then the request is sent into Influxdb.
We can then use Grafana with InfluxDB as the datasource and create the graphs below.

![alt text](https://github.com/yappl/influxdb-grafana-scala-example/blob/master/images/datavisualyappl.PNG?raw=true "Grafana")


----

[Check the blog post for more details](http://yappl.se/blog/Influxdb-Grafana)
