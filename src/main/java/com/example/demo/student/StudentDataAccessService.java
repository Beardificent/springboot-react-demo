package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class StudentDataAccessService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> selectAllStudents() {

        String sql = "" + "SELECT student_id," + "first_name, " + "last_name, " + "email, " + "gender " + "FROM student";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            String studentId = resultSet.getString("student_id");
            UUID studentIdUUID = UUID.fromString(studentId);
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String genderString = resultSet.getString("gender").toUpperCase();
            Student.Gender gender = Student.Gender.valueOf(genderString);
            return new Student(studentIdUUID, first_name, last_name, email, gender);
        });

    }
}
