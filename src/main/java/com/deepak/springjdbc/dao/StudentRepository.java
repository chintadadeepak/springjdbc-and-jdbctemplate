package com.deepak.springjdbc.dao;

import com.deepak.springjdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private JdbcTemplate jdbcTemplate;
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student student) {
        String sql = "INSERT INTO student (id, name, marks) VALUES (?,?,?)";
        int rows = jdbcTemplate.update(sql, student.getId(), student.getName()
        , student.getMarks());
        System.out.println(rows + " effected");
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM student";
        RowMapper<Student> mapper = (rs, rowNum) -> {
                return new Student( rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getInt("marks"));
        };
        return jdbcTemplate.query(sql, mapper);
    }
}
