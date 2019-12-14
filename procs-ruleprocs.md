# procs-ruleprocs.md
## start
```sh
$ mvn compile quarkus:dev
$ open http://localhost:8080/fruits.html
```

## native
```sh
# preqs: 
# `native-image` in the GRAALVM_HOME, Install it using `gu install native-image`
$ mvn package -Pnative -DskipTests
```
