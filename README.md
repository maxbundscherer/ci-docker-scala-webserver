# SBT Docker Test

## Requirements

- openJDK 11
- local docker installation

## Let's get started

- Run ``sbt docker:publishLocal``

### Run in docker

- Run ``docker run --name "se12" --rm -d -p 8080:8080 sbt-docker-test:0.1``