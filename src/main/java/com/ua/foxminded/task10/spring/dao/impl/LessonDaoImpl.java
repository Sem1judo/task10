package com.ua.foxminded.task10.spring.dao.impl;

import com.ua.foxminded.task10.model.Lector;
import com.ua.foxminded.task10.model.Lesson;
import com.ua.foxminded.task10.model.mapper.LessonMapper;
import com.ua.foxminded.task10.spring.dao.DaoInterface;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class LessonDaoImpl implements DaoInterface<Lesson> {
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_LESSON = "select * from lessons where lesson_id = ?";
    private final String SQL_DELETE_LESSON = "delete from lessons where lesson_id = ?";
    private final String SQL_UPDATE_LESSON = "update lessons set lesson_name = ? where lesson_id = ?";
    private final String SQL_GET_ALL_LESSON = "select * from lessons";
    private final String SQL_INSERT_LESSON = "insert into lessons(lesson_name) values(?)";

    public LessonDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Lesson getById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_LESSON, new Object[]{id}, new LessonMapper());
    }

    @Override
    public List<Lesson> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL_LESSON, new LessonMapper());
    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update(SQL_DELETE_LESSON, id) > 0;
    }

    @Override
    public boolean update(Lesson lesson) {
        return jdbcTemplate.update(SQL_UPDATE_LESSON, lesson.getName(),
                lesson.getLessonId()) > 0;
    }

    @Override
    public boolean create(Lesson lesson) {
        return jdbcTemplate.update(SQL_INSERT_LESSON, lesson.getName()) > 0;
    }
}
