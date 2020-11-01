echo "Please see version in build.sbt and in shell-script"
echo "Please wait 5 seconds"
sleep 5

echo
echo "Please check jdk version == 11"
java -version

echo
echo "-- SBT"
sbt docker:publishLocal