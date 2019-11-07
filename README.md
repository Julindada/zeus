# zeus
Main Web project for Celitea

先添加 application.properties 至 resources 目录下

``` shell script
mkdir running

mvn clean package

cp target/zeus-0.0.1-SNAPSHOT.jar running/

cp bin/http.sh running/

cd running

启动$ PORT=8071 ./http.sh start zeus-0.0.1-SNAPSHOT.jar

停止$ ./http.sh stop
```
