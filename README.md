# SBT Docker Test

## Requirements

- openJDK 11
- local docker installation

### Run in docker (local)

- Please see Version in ``./build.sbt`` and below
- Run ``sbt docker:publishLocal``
- Run ``docker run --name "tmp-docker-scala" --rm -d -p 8080:8080 sbt-docker-test:0.1``

### Publish to github packages

- Run ``./deploy.sh``

### Pull from github packages

- Run ``./pull-image.sh``