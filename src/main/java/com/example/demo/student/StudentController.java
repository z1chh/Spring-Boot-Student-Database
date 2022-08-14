package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService pStudentService) {
        this.studentService = pStudentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student pStudent) {
        assert pStudent != null: "Error: invalid student";
        this.studentService.addNewStudent(pStudent);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long pStudentId) {
        this.studentService.deleteStudent(pStudentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long pStudentId,
                              @RequestParam(required = false) String pName,
                              @RequestParam(required = false) String pEmail) {
        this.studentService.updateStudent(pStudentId, pName, pEmail);
    }
}
