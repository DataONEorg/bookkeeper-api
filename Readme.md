# DataONE Bookkeeper API

Bookkeeper is a RESTful service that is part of the [DataONE](https://dataone.org/) Coordinating Node
infrastructure. The Java classes in the Bookkeeper API implement the
 [Bookkeeper API](https://app.swaggerhub.com/apis/dataoneorg/bookkeeper/v1) models.  These classes 
 are used in [Bookkeeper](https://github.com/dataoneorg/bookkeeper) itself, 
 and other Java-based applications that interact with it.

Installation
------------

You can use the Bookkeeper API classes by importing the generated jar file into your project. 
Clone the repository and use Maven to build and use the library:

```shell
git clone https://github.com/dataoneorg/bookkeeper-api
cd bookkeeper-api
mvn install
```

Released versions are also available in the [DataONE Maven repository](https://maven.dataone.org).
Add it to your project POM file:

```xml
<repository>
    <id>dataone.org</id>
    <url>http://maven.dataone.org/</url>
    <releases>
        <enabled>true</enabled>
    </releases>
    <snapshots>
        <enabled>true</enabled>
    </snapshots>
</repository>
```
and add a dependency:

```xml
<dependency>
    <groupId>org.dataone</groupId>
    <artifactId>bookkeeper-api</artifactId>
    <version>1.0.0</version>
</dependency>

```

