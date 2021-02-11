package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping
    public List<Student> getAllStudents() {
        return List.of(new Student(UUID.randomUUID(), "Cis", "Magito", "cis.magito@gmail.com", Student.Gender.MALE),
                new Student(UUID.randomUUID(), "Goku", "Son", "kakarot@gmail.com", Student.Gender.MALE)
        );
    }

}
