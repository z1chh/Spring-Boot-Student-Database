# Spring Boot Student Database

## Student Database
Implemented a Student Database using Spring Boot (and PosgresSQL).
* Implemented with an API layer (@RestController StudentController) that communicates to a service layer (@Service StudentService class) and a data access layer (@Configuration StudentConfig class and @Repository StudentRepository class) to retrieve/store/modify information from the PostgresSQL database.
* Initiated with a few students in the database (PostgresSQL).

## StudentController
@RestController class that allows to add new students to the database, modify existing students' information and delete existing students.
This is done through a service layer (@Autowired StudentService class).

### View the Database Information
The @GetMapping method getStudents allows to communicate to the database through the service layer (StudentService class), which itself communicates with the @Repository StudentRepository class (using the findAll method).

### Adding a New Student
The @PostMapping method registerNewStudent allows the StudentController to add a new student via the student service layer (StudentService class) if there is not already a student with the same email registered.
* The @Repository StudentRepository interface provides a @Query method findStudentByEmail to help for this method

### Delete an Existing Student
The @DeleteMapping method deleteStudent allows the StudentController to delete an existing student via the student service layer (StudentService class) if there is a student with the same ID registered.

### Update Information of an Existing Student
The @PutMapping method updateStudent allows the StudentController to modify the name and/or email of an existing student via the student service layer (StudentService class) if there is a student with the same ID registered. The service layer ensures that, if a new email is provided, no students with that email addess already exist.
* The @Repository StudentRepository interface provides a @Query method findStudentByEmail to help for this method

