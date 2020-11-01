echo "Please see version in build.sbt and in shell-script"
echo "Please wait 5 seconds"
sleep 5
echo

echo
echo "Please check jdk version == 11"
java -version

echo "-- Login"
read -p "Git-Hub-Username: " username
read -p "Git-Hub-Token: " token
echo $token | docker login https://docker.pkg.github.com -u $username --password-stdin

echo
echo "-- SBT"
sbt docker:publishLocal

echo
echo "-- Please remember image_id"
docker images

echo
echo "-- Please input (Tag Image)"
read -p "Image-Id: " imageId
docker tag $imageId docker.pkg.github.com/$username/prototype-sbt-scala-docker/sbt-docker-test:0.1

echo
echo "-- Push to aws"
docker push docker.pkg.github.com/$username/prototype-sbt-scala-docker/sbt-docker-test:0.1

echo "-- Clean up docker"
docker rmi -f $imageId

echo
echo "Thank you!"