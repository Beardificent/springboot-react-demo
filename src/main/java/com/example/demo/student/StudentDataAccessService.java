package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentDataAccessService {

    public List<Student> selectAllStudents(){
        return List.of(
                new Student(UUID.randomUUID(),
                        "Cis",
                        "Magito",
                        "cis.magito@gmail.com",
                        Student.Gender.MALE),
                new Student(UUID.randomUUID(),
                        "Goku",
                        "Son",
                        "kakarot@gmail.com",
                        Student.Gender.MALE)
        );
    }
}
