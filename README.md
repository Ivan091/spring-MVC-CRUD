# Ivan-Karnasevich

![Java CI with Maven](https://github.com/Brest-Java-Course-2021/IKarnasevich/workflows/Java%20CI%20with%20Maven/badge.svg)

#

![My db schema](docs/img/DataBase.png)

### Requirements

* JDK 11
* Apache Maven
* npm

### Build back:

```
mvn clean install
```

#### Run back:

```
java -jar rest-api/target/app-rest-1.0-SNAPSHOT.jar
```

#### Front server will be available by:

```
http://localhost:8080/
```

### Build front:

```
cd react-front/
npm install
npm run build
```

#### Run front:

```
npx serve -s build
```

#### Front server will be available by:

```
http://localhost:5000/
```

#### To view available rest endpoint run the back and access the following URL:

```
http://localhost:8080/swagger-ui/
```
