package com.ua.foxminded.task10.dao.impl;


import com.ua.foxminded.task10.model.Group;
import com.ua.foxminded.task10.model.mapper.GroupMapper;
import com.ua.foxminded.task10.dao.DaoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupDaoImpl implements DaoInterface<Group> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_GROUPS = "select * from groups where group_id = ?";
    private final String SQL_DELETE_GROUPS = "delete from groups where group_id = ?";
    private final String SQL_UPDATE_GROUPS = "update groups set group_name where group_id = ?";
    private final String SQL_GET_ALL_GROUPS = "select * from groups";
    private final String SQL_INSERT_GROUPS = "insert into groups(group_name) values(?)";

    @Override
    public Group getById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_GROUPS, new Object[]{id}, new GroupMapper());
    }

    @Override
    public List<Group> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL_GROUPS, new GroupMapper());
    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update(SQL_DELETE_GROUPS, id) > 0;
    }

    @Override
    public boolean update(Group group) {
        return jdbcTemplate.update(SQL_UPDATE_GROUPS, group.getName(),
                group.getGroupId()) > 0;
    }

    @Override
    public boolean create(Group group) {
        return jdbcTemplate.update(SQL_INSERT_GROUPS, group.getName()) > 0;
    }
}