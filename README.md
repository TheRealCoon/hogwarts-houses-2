# Hogwarts Houses - sprint 2

## Story

Even wizards can not live their life to the fullest without a bit of programming.

We've been helping the wizards at Hogwarts in the first sprint (_50 points to Codecool!_). Since then, they have been swinging with their wands a few times, and learned new spells, like `Agile-is`, and `Sprintio`. 

We just got the owl with their newest request - they said, they are running out of parchments by administering students, so they need to persist data in a _database_.

Also, Professor Snape asked us, to automatize his class of potion brewing, as he is fed up with his students.



## What are you going to learn?

- the DAO-pattern
- create and establish a connection to an H2 database with a Spring Boot application using JDBC
- unit testing

## Tasks

1. In order to continue just where we left off, your first task is to clone the starter repo, and import your work from the last sprint.
    - All work from sprint 1 is merged to the `starter repo of sprint 2`.

2. Make sure the following properties are set in the `application.properties`, in the `resources` folder: Set the `spring.datasource.name` to `hogwarts`. Set the `spring.h2.console.enabled` property. Set the `spring.jpa.hibernate.ddl-auto` property. Set the `spring.datasource.username` property. Set the `spring.datasource.url` property. Set the `springdoc.swagger-ui.path` property.
    - The `spring.datasource.name` is set to `hogwarts`.
    - The `spring.h2.console.enabled` property is set.
    - The `spring.jpa.hibernate.ddl-auto` property is set.
    - The `spring.datasource.username` property is set.
    - The `springdoc.swagger-ui.path` property is set.

3. Create a `schema.sql` in the `resources` folder. Create a table for `building`. Create a table for `picture`. The `picture` should have a `foreign key` referring to the `building`. Create a table for `room`. The `room` should have a `foreign key`, referring to the `building`. Create a table for `student`. The `student` should have fixed options of `HouseType` and `PetType` to choose from. Create a table for `resident`, describing the connection between a `student` and a `room`.
    - The `resources` folder contains a `schema.sql` describing the entities in Hogwarts.
    - The schema describes a `building`.
    - The schema describes a `picture`, with a field referring to it's `building`.
    - The schema describes a `room`, with a field referring to it's `building`.
    - The schema describes a `student`.
    - The schema describes a `resident`, referring to it's `room` and `student`.

4. Create a `data.sql` in the `resources` folder, and fill all tables of the database with some sample data.
    - There is a `data.sql` file in the `resources` folder.
    - After running the `data.sql` file, all tables of the database should be filled with sample data.

5. Create a `RoomDAO` interface in the `dao` layer. The `RoomDAO` should contain methods for CRUD operations, extended with `list all available rooms, and `list all room with no cat or owl`. Obviously, if you already have a `DAO` which pass all requirements, you can skip to the next task.
    - The `RoomDAO` interface is located within the `dao` layer.
    - The `RoomDAO` provides methods for listing all rooms, listing all available rooms, listing all rooms with no cat or owl, getting a room by ID, saving a new room, updating a room by ID, and for deleting a room by ID.

6. Create a `StudentDAO` interface in the `dao` layer. The `StudentDAO` should contain methods for CRUD operations. Obviously, if you already have a `DAO` which pass all requirements, you can skip to the next task.
    - The `StudentDAO` interface is located within the `dao` layer.
    - The `StudentDAO` provides methods for listing all students, getting a student by ID, saving a student, updating a student, deleting a student.

7. Create a `BuildingDAO` interface in the `dao` layer. The `BuildingDAO` should contain methods for CRUD operations. Obviously, if you already have a `DAO` which pass all requirements, you can skip to the next task.
    - The `BuildingDAO` interface is located within the `dao` layer.
    - The `BuildingDAO` provides methods for listing all buildings, getting a building by ID, saving a building, updating a building, deleting a building.

8. Create a `RoomDaoJdbcImpl` repository class, where the `RoomDAO` interface methods are implemented.
    - All interface methods of `RoomDAO` are implemented.

9. Create a `StudentDaoJdbcImpl` repository class, where the `StudentDAO` interface methods are implemented.
    - All interface methods of `StudentDAO` are implemented.

10. Create a `BuildingDaoJdbcImpl` repository class, where the `StudentDAO` interface methods are implemented.
    - All interface methods of `BuildingDAO` are implemented.

11. After having all the DAO interfaces implemented, all services should use the database. This includes handling request also. Every data for responses should originate from the database. All templates and endpoints should work from last week.
    - Endpoints for creating, finding, deleting, updating, finding available rooms, finding rooms for rat owners should create the same response, as with the in-memory database did before.

12. Severus Snape, the Potions Master at Hogwarts, can teach you, _how to bottle lame, brew lory, even put a stopper in deaf_ - as Ron's notes says from the first class. Your task is to learn the ins and outs of potion brewing - at first, by trial and error. A `recipe` of a potion has a `name`, and a list of 5 `ingredients`.  The `ingredients` are fixed, they should be enumerated - _please do not put Longbottom's frog in the cauldron_. Create an endpoint at `/potions`. Here, you should list all `recipes` available.
    - There is at least 5 `recipes` in the database.
    - At `/potions` all existing `recipes` are listed.

13. Let's get our cauldrons dirty!  Create an endpoint at `/potions/{studentId}` where you can send your list of `ingredients` in a `POST request` and brew *something*. The response should contain all data of the created potion! You should check, whether this list matches any written `recipes` before (the order of the ingredients should __not__ matter!). Make sure to be able to create, read, update and even delete `recipes` in the database. These `recipes` should be related to the `students`.
    - There is an endpoint at `/potions/{studentId}`, where a `student` can start to brew the `recipe` of a potion by sending a `POST request`.
    - The list of `ingredients` is checked if it matches any `recipe`.
    - Student can create, read, update and even delete `recipes`.
    - The `recipes` are related to `students`.
    - The response contains the persisted potion.

14. When brewing something at `/potions/{studentId}`, you should check, whether this list matches any written `recipes` before (the order of the ingredients should __not__ matter!). If the `recipe` matches any known `recipe`, then save the `recipe` of the potion to the `student's list of known potions`. This should be persisted in the database also.
    - If the list of `ingredients`, __in any order__, matches a `recipe`, the potion is saved to the `student's recipes` by the name of the `recipe` existing already.
    - After a successful brew, the student's newly learnt `recipe` should be persisted in the database.

15. When brewing something at `/potions/{studentId}` did not match any existing recipe's ingredient list (in any order), create a new `recipe`. Save this new potion to the `student's` known `recipes`.  The name of the recipe could be any random value, but should remain unique. This should be persisted in the database also.
    - If the list of `ingredients`, __in any order__, did not match a `recipe` known before, the new recipe is saved to the `student's recipes`.
    - The new potion's ingredients' are saved as a new recipe to the 'student's known recipes'.
    - The newly saved `recipe` has a unique `name`.

16. By sending a `GET request` to `/potions/{studentId}`, list all explored `recipes` of a `student`.
    - At `/potions/{studentId}` all known `recipes` of a given `student` are listed.

17. Please note, that ***this is an optional task.*** Create a form for brewing potions. The form should contain 5 input fields (or dropdown menus) for ingredients. When the potion does not match any known recipe, create a field
    - There is an HTML containing a `<form>` for potion brewing, with input fields for the ingredients.
    - After submitting the form, the potion is persisted.

18. Create a `unit test` for every `service` method related to potion brewing. Try to write tests for every outcome of your methods, even the unlikely or nearly possible ones.
    - There are at least 2 unit tests written for every method related to potion brewing.

## General requirements

None

## Hints

- When brewing a potion, you can define the student in a query, like `/potions/brew?student-id=0,`
- When brewing a potion, you can send the `ingredients` in a query, like `potions/brew?ingredients=boomslang_skin,crocodile_heart,doxy_egg,dragon_claw,fluxweed`.
- For generating random values, you can use `UUID`s from `java.util` package.


## Background materials

- [How to use Spring JdbcTemplate](https://yashodgayashan.medium.com/how-to-use-spring-jdbctemplate-dec9e4476eaa)
- <i class="far fa-camera"></i> [Spring JDBC Template Tutorial](https://youtube.com/watch?v=0uLqdBpYAVA)
- [How to handle query parameters in Spring](https://baeldung.com/spring-request-param)
- <i class="far fa-book-open"></i> [Data Access Object (DAO) pattern tutorial](https://tutorialspoint.com/design_pattern/data_access_object_pattern.htm)
- <i class="far fa-candy-cane"></i> [The difference between integration and unit tests](https://stackoverflow.com/questions/10752/what-is-the-difference-between-integration-and-unit-tests)
