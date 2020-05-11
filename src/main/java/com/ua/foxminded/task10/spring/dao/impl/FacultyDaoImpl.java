package com.ua.foxminded.task10.spring.dao.impl;

import com.ua.foxminded.task10.model.Faculty;
import com.ua.foxminded.task10.model.mapper.FacultyMapper;
import com.ua.foxminded.task10.spring.dao.DaoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class FacultyDaoImpl implements DaoInterface<Faculty> {

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_FACULTY = "select * from faculties where faculty_id = ?";
    private final String SQL_DELETE_FACULTY = "delete from faculties where faculty_id = ?";
    private final String SQL_UPDATE_FACULTY = "update faculties set faculty_name = ? where faculty_id = ?";
    private final String SQL_GET_ALL_FACULTY = "select * from faculties";
    private final String SQL_INSERT_FACULTY = "insert into faculties(faculty_name) values(?)";


    @Autowired
    public FacultyDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Faculty getById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_FACULTY, new Object[]{id}, new FacultyMapper());
    }

    @Override
    public List<Faculty> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL_FACULTY, new FacultyMapper());
    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update(SQL_DELETE_FACULTY, id) > 0;
    }

    @Override
    public boolean update(Faculty faculty) {
        return jdbcTemplate.update(SQL_UPDATE_FACULTY, faculty.getName(),
                faculty.getFacultyId()) > 0;
    }

    @Override
    public boolean create(Faculty faculty) {
        return jdbcTemplate.update(SQL_INSERT_FACULTY, faculty.getName()) > 0;

    }

}
