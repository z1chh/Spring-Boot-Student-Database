package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long pId, String pName, String pEmail, LocalDate pDob) {
        assert pId >= 0: "Error: invalid ID";
        assert pName != null && !pName.equals(""): "Error: invalid name";
        assert pEmail != null && !pEmail.equals(""): "Error: invalid email";
        this.id = pId;
        this.name = pName;
        this.email = pEmail;
        this.dob = pDob;
    }

    public Student(String pName, String pEmail, LocalDate pDob) {
        assert pName != null && !pName.equals(""): "Error: invalid name";
        assert pEmail != null && !pEmail.equals(""): "Error: invalid email";
        this.name = pName;
        this.email = pEmail;
        this.dob = pDob;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long pId) {
        assert pId >= 0: "Error: invalid ID";
        this.id = pId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String pName) {
        assert pName != null && !pName.equals(""): "Error: invalid name";
        this.name = pName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String pEmail) {
        assert pEmail != null && !pEmail.equals(""): "Error: invalid email";
        this.email = pEmail;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate pDob) {
        this.dob = pDob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer pAge) {
        assert pAge >= 0: "Error: invalid age";
        this.age = pAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
