# SBT Docker Scala Webserver GitHub Packages

Runs webserver written in scala in docker container. Publishing-script to GitHub-Packages included.

## Requirements

- openJDK 11
- local docker installation

### Run in docker (local)

- Please see Version in ``./build.sbt`` and below
- Run ``sbt docker:publishLocal``
- Run ``docker run --name "tmp-docker-scala" --rm -d -p 8080:8080 sbt-docker-test:0.1``

### Publish to github packages

- Run ``./deploy.sh``

### Pull/Run from github packages

- Run ``./pull-run-image.sh``
