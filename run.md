docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql

docker run --name influxdb -p 8086:8086 -d quay.io/influxdb/influxdb:v2.0.2