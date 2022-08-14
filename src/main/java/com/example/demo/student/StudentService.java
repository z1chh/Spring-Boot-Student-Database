package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository pStudentRepository) {
        this.studentRepository = pStudentRepository;
    }
    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    public void addNewStudent(Student pStudent) {
        assert pStudent != null: "Error: invalid student";
        Optional<Student> studentOptional = this.studentRepository.findStudentByEmail(pStudent.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Error: email taken");
        }

        this.studentRepository.save(pStudent);
    }

    public void deleteStudent(Long pStudentId) {
        if (this.studentRepository.existsById(pStudentId))
            this.studentRepository.deleteById(pStudentId);
        else
            throw new IllegalStateException(String.format("Error: student with ID %d does not exist", pStudentId));
    }

    @Transactional
    public void updateStudent(Long pStudentId, String pName, String pEmail) {
        Student student = this.studentRepository.findById(pStudentId)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Error: student with ID %d does not exist", pStudentId)));

        // Change the name
        if (pName != null && !pName.equals("") &&
        !Objects.equals(student.getName(), pName)) {
            student.setName(pName);
        }

        // Change the email
        if (pEmail != null && !pEmail.equals("") &&
                !Objects.equals(student.getEmail(), pEmail)) {
            Optional<Student> studentOptional = this.studentRepository.findStudentByEmail(pEmail);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Error: email already exists");
            }
            student.setEmail(pEmail);
        }
    }
}


