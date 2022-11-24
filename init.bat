@echo off

echo Building jar
call mvn clean package -DskipTests
echo ...

echo Copy jar to docker folder
copy target/springsecuritydemo-0.0.1.jar docker/app
echo ...

pause