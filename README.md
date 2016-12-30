#### Installed the dependency first:

To be able to make Neo4j scan classpath in Widlfly I forked this module https://github.com/ctpconsulting/neo4j-ogm-resourceresolver-vfs.
Thanks to https://github.com/thomashug.


```bash
mvn install:install-file -Dfile="./neo4j-ogm-resourceresolver-vfs-1.0.0-SNAPSHOT.jar" -DgroupId=com.ctp.neo4j -DartifactId=neo4j-ogm-resourceresolver-vfs -Dversion=1.0.0-SNAPSHOT -Dpackaging=jar
```

I was using neo4j as a module in wildfly but I decide deploying the dependencies inside WAR.
I have to use also the dependency java-neo4j-ogm from inerloop (https://github.com/inner-loop/java-neo4j-ogm) to solve the problem of org.neo4j.ogm.exception.ServiceNotFoundException: Driver: org.neo4j.ogm.drivers.http.driver.HttpDriver.




