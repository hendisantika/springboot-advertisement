# springboot-advertisement

# Ads Service

# Table of Contents

- [Description](#description)
- [Features](#features)
- [Technologies](#technologies)
- [Entities](#entities)
- [EndPoints](#endpoints)
- [Usage](#usage)

## Description

This service manage information about advertisements.

## Features

- Get relevants advertisements.
- Get all advertisements.
- Calculate the score of an ad based on its characteristics.

## Technologies

* [H2](https://www.h2database.com/html/main.html)
* [Spring Boot](https://spring.io/projects/spring-boot)

## Entities

#### Picture

```json
{
    "id": "string",
    "url": "string",
    "quality": "HD"
}
```

#### Advertisement

```json
{
    "id": "string",
    "description": "string",
    "typology": "string",
    "houseSize": "number",
    "gardenSize": "number",
    "pictures": [ Picture ],
    "irrelevantFrom": 0,
    "score": 0
}
```

for example:

```json

{
  "id": 9,
  "description": "Very bright and recently renovated central penthouse, it seems new",
  "typology": "FLAT",
  "houseSize": 130,
  "irrelevantFrom": 23,
  "gardenSize": 212,
  "pictures": [
    {
      "id": 5,
      "url": "http://www.idealista.com/pictures/5",
      "quality": "SD"
    }
  ],
  "picturesIds": [1,2,3],
  "score": 75
}
```

## EndPoints

All endpoints are describe in swagger yaml in spec folder:

- [OpenApi](spec/openapi.yml)

#### GET /api/advertisement

With this endpoint list of relevant advertisement can be retrieved. Request result can be sorted using following query
param:

- `sort`: In order to retrieve sorted response.
    ```
    field:order
    ```
  Where:
    - `field`: Name of advertisement entity field to sort result:
        - `values: [description, typology, houseSize, gardenSize, score]`
    - `order`: Order Type
        - `values: [desc, asc]. Default desc`

> Example: Get relevant advertisement ordered desc by score:
`/api/advertisement?sort=score:desc`

#### GET /api/advertisement/all

With this endpoint list of all advertisement can be retrieve.
> Only registered users with role QUALITY_USER can be perform this action.

Request result can be filtered using following query params:

- `show`: In order to retrieve all advertisement, only relevants or only irrelevants:
    - `values: [all, relevants, irrelevants]. Default all.`
- `sort`: In order to retrieve sorted response.
    ```
    field:order
    ```
  Where:
    - `field`: Name of advertisement entity field to sort result:
        - `values: [description, typology, houseSize, gardenSize, score]`
    - `order`: Order Type
        - `values: [desc, asc]. Default desc`

> Example: Retrieve irrelevants advertisement order by typology asc:
`/api/advertisement/all?show=irrelevants&sort=typology:asc`

#### GET /api/advertisement/calculate-scores

With this endpoint all advertisements score is calculated in request time.
> Only registered users with role QUALITY_USER can perform this action.

#### Postman

Postman collection have been included within the
code: [Postman Collection](springboot-advertisement.json "Postman collection")

## Usage

#### Run Service

Execute the following command:

```bash
$ mvn clean spring-boot:run
```

#### Compile Service

Execute the following command:

```bash
$ mvn clean package
```

With this command, jar of service will be created in folder `build/libs/`

#### Execute Generated jar

Execute the following command:

```bash
$ java -jar target/springboot-advertisement-0.0.1.jar
```

#### Docker

In order to create container with service, you must execute following operations:

```
$ mvn clean package
$ docker build -t hendisantika/advertisement:0.0.1 .      
$ docker run -p 8080:8080 hendisantika/advertisement:0.0.1
```

#### Demo Users

In order to test security in different endpoints, we create two users in memory:

- `user/password`: Normal user with roles [ `USER` ].
- `qualityUser/password`: Quality user, with roles [ `USER`, `QUALITY_USER` ]
