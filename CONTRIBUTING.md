# Swagger Code Generation

This repository relies on the following Dockerfile in order to run
Swagger Codegen inside a Docker container:
https://hub.docker.com/r/parsertongue/swagger-codegen-cli.

We're currently using version 3.0.32 of Swagger Codegen.

## Generating the API Client

Copy the Swagger specification YAML files to the local `./input` directory.

The API v1 and v2 files can be found using the OAS export link on our
documentation pages: https://docs.jumpcloud.com/1.0 and
https://docs.jumpcloud.com/2.0.

Update the version number for each package in `config_v1.json` or
`config_v2.json`.

To generate the API v1 or v2 client, run the commands below:

```bash
# Update API v1 and v2 specification files in `./input/index1.yaml` and `./input/index2.yaml`):
mkdir input
curl https://docs.jumpcloud.com/api/1.0/index.yaml --output input/index1.yaml
curl https://docs.jumpcloud.com/api/2.0/index.yaml --output input/index2.yaml

# Generate SDKs
mkdir output
LANG="java"
docker-compose run --rm swagger-codegen generate -i /swagger-api/yaml/index1.yaml -l ${LANG} -c /config/config_v1.json -o /swagger-api/out/jcapiv1
docker-compose run --rm swagger-codegen generate -i /swagger-api/yaml/index2.yaml -l ${LANG} -c /config/config_v2.json -o /swagger-api/out/jcapiv2

# This will generate the API v1 and v2 client files under the local `./output/jcapiv1` and `./output/jcapiv2` directories.

# Once you are satisfied with the generated API client, you can replace the existing files under the `jcapiv1` or `jcapiv2` directory with your generated files:

rm -rf jcapiv1
mv output/jcapiv1 .

rm -rf jcapiv2
mv output/jcapiv2 .
```

There is currently a bug with Swagger Codegen where invalid variable names get
generated in the doc files. In order to fix this, run the following commands in
the root directory of this repository:

```bash

grep -rl 'x-api-key.' jcapiv1/ | xargs sed -i '' 's/x-api-key\./x_api_key\./g'
grep -rl 'x-api-key =' jcapiv1/ | xargs sed -i '' 's/x-api-key =/x_api_key =/g'

grep -rl 'x-api-key.' jcapiv2/ | xargs sed -i '' 's/x-api-key\./x_api_key\./g'
grep -rl 'x-api-key =' jcapiv2/ | xargs sed -i '' 's/x-api-key =/x_api_key =/g'
```
