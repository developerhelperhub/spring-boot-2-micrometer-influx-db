### Spring Boot  + Micrometer + InfluxDB 

This repo contains the sample code which helps how to collect the spring boot application metrics for monitoring.

- Spring Boot 2.7.8
- Micrometer
- Influx DB 2
- My SQL
- Docker

We have to run and configure the service to run this application

#### MySQL

Start the MySQL database

```bash 

docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql

```

#### Influx DB 2

Start the Influx database

```bash 

docker run --name influxdb -p 8086:8086 -d quay.io/influxdb/influxdb:v2.0.2

```

Mapping the bucket to database, in the influx db 2, we called bucket instead of database. 

```bash 

docker exec -it influxdb bash

influx setup --skip-verify --bucket my-bucket --org my-org --username my-user --password my-password --retention 1 --token my-super-secret-auth-token

influx config create --active --org my-org --config-name my-config --host-url http://localhost:8086 --token my-super-secret-auth-token

influx bucket list

influx v1 auth create \
  --read-bucket ad4ae25a30edf00b \
  --write-bucket ad4ae25a30edf00b \
  --username my-user
  
enter the pass: my-password

influx v1 dbrp create \
  --db example-db \
  --rp example-rp \
  --bucket-id ad4ae25a30edf00b \
  --default

```

Start the spring boot application

We can login into influx dashboard in this URL http://localhost:8086/onboarding/1. We can able to see the bucket name which "my-bucket" in the data/buckets section
 

