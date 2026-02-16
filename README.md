# An utility for simulating data

## 1. An utility developed using spring jpa which can simulate code for a simple schema
## 2. It also has capabilities to persist in any database with jdbc support, like postgres, MySQL, etc.
## 3. It is extensible to support custom schema and additional logic around simulation

# To setup Postgres for testing

## To setup Postgres visit: https://hub.docker.com/_/postgres
> docker run --name postgres-test -e POSTGRES_PASSWORD=<YOUR_PASSWORD> -d postgres

# To run simulator

## edit the following properties in: src/main/resource/application.properties

> spring.datasource.url=jdbc:postgresql://<ip-address>:port/postgres
> spring.datasource.username=postgres
> spring.datasource.password=<YOUR_PASSOWRD>

## Note: You can find the ip address of your docker container by running docker inspect postgres-test and looking for the ip-address details

## Once the properties files updated, run the following
### To build
> mvn clean install
### To run
> java -jar target/datasim-0.0.1-SNAPSHOT.jar 
