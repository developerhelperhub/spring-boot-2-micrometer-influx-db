https://docs.influxdata.com/influxdb/v2.3/query-data/influxql/#map-unmapped-buckets


https://docs.influxdata.com/influxdb/v2.6/tools/grafana/?t=InfluxQL#view-and-create-influxdb-v1-authorizations

http://localhost:8086/onboarding/1

docker exec -it influxdb bash

influx setup --skip-verify --bucket my-bucket --org my-org --username my-user --password my-password --retention 1 --token my-super-secret-auth-token


influx config create --active --org my-org --config-name my-config --host-url http://localhost:8086 --token my-super-secret-auth-token


influx bucket list

influx v1 auth create \
  --read-bucket ad4ae25a30edf00b \
  --write-bucket ad4ae25a30edf00b \
  --username my-user
  
pass: my-password

influx v1 dbrp create \
  --db example-db \
  --rp example-rp \
  --bucket-id ad4ae25a30edf00b \
  --default




Token my-super-secret-auth-token
