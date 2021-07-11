# java-api
>A simple RESTful api framework by java

## develop

`mvn clean install -U & run frameApplication`

## build

`mvn clean package -Dmaven.test.skip=true`

## deploy

`nohup java -jar frame.jar >start.log &`

## DevOps

`ps -ef|grep java & top -p pid & kill -9`