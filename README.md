# Ivan-Karnasevich

![Java CI with Maven](https://github.com/Brest-Java-Course-2021/IKarnasevich/workflows/Java%20CI%20with%20Maven/badge.svg)

#

![My db schema](docs/img/DataBase.png)

### Requirements

* JDK 11
* Apache Maven

### Build:

```
mvn clean install
```

### To run the app:

```
java -jar rest-api/target/app-rest-1.0-SNAPSHOT.jar
```

#### To view available rest endpoint run the app and access the following URL:

```
http://localhost:8080/swagger-ui/
```

Important! Title schema is wrong there. I have no idea why, but swagger don't want to understand `runtime` property whose type is `java.sql.Time`. So, remember the property must be a string
in `HH:MM:SS` format.
