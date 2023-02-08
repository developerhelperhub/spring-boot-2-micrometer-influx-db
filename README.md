### Spring Boot  + Micrometer + InfluxDB + Grafana

This repo contains the sample code which helps how to collect the spring boot application metrics for monitoring.

- Spring Boot 2.7.8
- Micrometer
- Influx DB 2
- My SQL
- Grafana
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
#### Grafana

Start the Grafana

```bash 

docker run -d --name=grafana -p 3000:3000 grafana/grafana

```
### Configure Data Source Influx DB in Grafana
1. Select Datasource menu
2. Choose the Influx DB datasource
3. Give the name of datasource "Influx DB"
4. Select the query language is "InfluxQL"
5. Give the URL is "http://host.docker.internal:8086"
6. Add custom header, header name is "Authorization" and value is "Token my-super-secret-auth-token"
7. Database is "my-app-db"
8. User is "my-user"
9. Password is "my-password"
10. HTTP method is "Get"
11. Click the save and test button

#### Dashboards

1. Start the spring boot application
2. We can login into influx dashboard in this URL http://localhost:8086/onboarding/1. We can able to see the bucket name which "my-app-bucket" in the data/buckets section
3. We can login into grafana dashboard in this URL http://localhost:3000. The grafana template is available in the source and the file name is "Spring Boot Metrics-*.json". This template can be imported and monitor the application. 
 
 

