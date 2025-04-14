package com.example.springjdbc.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.springjdbc.model.Student;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;
    

    public void save(Student s) {
        
        String sql = "insert into student (rno,name,marks) values (?,?,?)";
        int rows = jdbc.update(sql, s.getRno(),s.getName(),s.getMarks());
        System.out.println(rows + "affected");
    }

    public List<Student> findAll() {
        String sql = "select * from student";

        RowMapper<Student> mapper = new RowMapper<Student>() {

            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                
                Student s = new Student();
                s.setRno(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setMarks(rs.getInt(3));

                return s;
            }
            
            
        };

        return jdbc.query(sql, mapper);
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    
    
}
