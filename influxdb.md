## Commands

docker exec -it influxdb bash

influx setup --skip-verify --bucket my-app-bucket --org my-org --username my-user --password my-password --retention 30d --token my-super-secret-auth-token


influx config create --active --org my-org --config-name my-config --host-url http://localhost:8086 --token my-super-secret-auth-token


influx v1 auth create \
  --read-bucket ad4ae25a30edf00b \
  --write-bucket ad4ae25a30edf00b \
  --username my-user
  
pass: my-password

influx bucket list

influx v1 dbrp create \
  --db my-app-db \
  --rp my-app-rp \
  --bucket-id 99af5febd21d012d \
  --default


create -n my-jmeter-bucket -o my-org -r 30d

influx bucket list

influx v1 dbrp create \
  --db my-jmeter-db \
  --rp my-jmeter-rp \
  --bucket-id 74a5e73698526b03

# URL

http://localhost:8086/onboarding/1

# References

https://docs.influxdata.com/influxdb/v2.3/query-data/influxql/#map-unmapped-buckets
https://docs.influxdata.com/influxdb/v2.6/tools/grafana/?t=InfluxQL#view-and-create-influxdb-v1-authorizations
