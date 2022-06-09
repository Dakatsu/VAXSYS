# VAXSYS
Vaccination Management System project for Concordia University's SOEN 6471 Advanced Software Architecture class.

## Project Setup
This project requires PostgreSQL and Spring Boot, the latter being fetched by Gradle. Setting up this project on a Windows 10 computer requires the following steps:
1. Install PostgreSQL.
2. Install IntelliJ and use *New » Project from Version Control* to create the project from this repository.
3. Add the JDK to the project and its modules.
4. Create a new database called *vaxsys* in PostgreSQL. This can be done using the *pgAdmin 4* program.
5. Use the Query Tool in pgAdmin 4 to run the `schema.sql` and `data.sql` files located in */src/main/resources/*.
6. In the *application.properties* file located in */src/main/resources/*, find the `spring.datasource.password=` line and add the password used for the *PostgreSQL vaxsys* database after the equals sign, e.g. `spring.datasource.password=Pa$sW0rD`.

## Running and Using VAXSYS
Once running the program in the IDE, wait for a line similar to this to appear in the console output:

  `com.vaxsys.Application                   : Started Application in X.XXX seconds`
  
The program can then be accessed from a web browser by typing in *localhost:9000/index.html*. It can also be accessed from another computer or phone by replacing *localhost* with an IP address.

Alternatively, the program's API is exposed via the HTTP requests documented in this repository's wiki.
