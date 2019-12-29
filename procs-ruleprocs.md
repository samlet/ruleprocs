# procs-ruleprocs.md
## start
```bash
$ cp -r resources target/
$ mvn compile quarkus:dev

$ open http://localhost:8080/fruits.html
# rest-json
$ curl http://localhost:8080/fruits

# ner rest intf
$ curl -d '{"sents":"Jokowi pergi ke Singapura."}' \
              -H "Content-Type: application/json" -X POST \
              localhost:8080/ner
```

## native
```bash
# preqs: 
# `native-image` in the GRAALVM_HOME, Install it using `gu install native-image`
$ mvn package -Pnative -DskipTests
```

## docker
```bash
$ mvn package -DskipTests
```

## servant
```bash
$ start servant
```


