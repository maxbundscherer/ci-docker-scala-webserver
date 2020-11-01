echo "Please see version in build.sbt and in shell-script"
echo "Please wait 5 seconds"
sleep 5
echo

echo "-- Login"
read -p "Git-Hub-Username: " username
read -p "Git-Hub-Token: " token
echo $token | docker login https://docker.pkg.github.com -u $username --password-stdin

echo
echo "-- Pull"
docker pull docker.pkg.github.com/$username/prototype-sbt-scala-docker/sbt-docker-test:0.1

echo
echo "Thank you!"