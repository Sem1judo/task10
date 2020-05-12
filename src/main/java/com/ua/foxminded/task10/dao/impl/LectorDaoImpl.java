package com.ua.foxminded.task10.dao.impl;

import com.ua.foxminded.task10.model.Lector;
import com.ua.foxminded.task10.dao.DaoInterface;
import com.ua.foxminded.task10.model.mapper.LectorMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class LectorDaoImpl implements DaoInterface<Lector> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_LECTORS = "select * from lectors where lector_id = ?";
    private final String SQL_DELETE_LECTORS = "delete from lectors where lector_id = ?";
    private final String SQL_UPDATE_LECTORS = "update lectors set first_name = ?, last_name = ? where lector_id = ?";
    private final String SQL_GET_ALL_LECTORS = "select * from lectors";
    private final String SQL_INSERT_LECTORS = "insert into lectors(first_name, last_name) values(?,?)";

    @Override
    public Lector getById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_LECTORS, new Object[]{id}, new LectorMapper());
    }

    @Override
    public List<Lector> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL_LECTORS, new LectorMapper());
    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update(SQL_DELETE_LECTORS, id) > 0;
    }

    @Override
    public boolean update(Lector lector) {
        return jdbcTemplate.update(SQL_UPDATE_LECTORS, lector.getFirstName(), lector.getLastName(),
                lector.getLectorId()) > 0;
    }

    @Override
    public boolean create(Lector lector) {
        return jdbcTemplate.update(SQL_INSERT_LECTORS, lector.getFirstName(), lector.getLastName()) > 0;
    }




}