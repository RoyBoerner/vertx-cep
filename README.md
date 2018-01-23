README
======

This is a distributed event processor using vert.x.

```
mvn package
java -jar emitter/target/emitter-1.0-SNAPSHOT-fat.jar -cluster
java -jar -Dhttp.port=8081 processor/target/processor-1.0-SNAPSHOT-fat.jar -cluster
java -jar -Dhttp.port=8082 processor/target/processor-1.0-SNAPSHOT-fat.jar -cluster
java -jar -Dhttp.port=8082 processor/target/processor-1.0-SNAPSHOT-fat.jar -cluster
```

You may start as much processors as you want.

* http://localhost:8080/
* http://localhost:8081/