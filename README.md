# buildtimeboot
Compare quarkus build time boot to spring boot run time boot difference

In order to run the following command, it would need to build each quickstart first.

See more analyse please check: 

You can also review the raw comparation output by click the txt file without running any command.

## Check classload numbers:
```bash
#Quarkus
java -verbose:class -jar quarkus-getting-started/target/quarkus-getting-started-1.0.0-SNAPSHOT-runner.jar| tee quarkus-classload.txt


#Springboot
java -verbose:class -jar springboot-getting-started/target/demo-0.0.1-SNAPSHOT.jar |tee springboot-classload.txt

# Counting the class load numbers
grep "class,load" quarkus-classload.txt |wc -l;grep "class,load" springboot-classload.txt |wc -l

```

## Check the binary output 
```bash
#quarkus
unzip -l quarkus-getting-started/target/quarkus-getting-started-1.0.0-SNAPSHOT-runner.jar | awk '{print $4}' |sort |tee quarkus-build-class.txt

#spring boot
unzip -l springboot-getting-started/target/demo-0.0.1-SNAPSHOT.jar | awk '{print $4}'|sort |tee springboot-build-class.txt 
```
## Check TRACE level startup log
```bash
QUARKUS_PROFILE=dev java -jar quarkus-getting-started/target/quarkus-getting-started-1.0.0-SNAPSHOT-runner.jar |tee quarkus-bootstrap.log

SPRING_PROFILES_ACTIVE=dev java -jar springboot-getting-started/target/demo-0.0.1-SNAPSHOT.jar |tee springboot-bootstrap.txt
```

## Check the quarkus build log
```bash
mvn -X clean package -DskipTests -f quarkus-getting-started/pom.xml |tee quarkus-build.log
```


