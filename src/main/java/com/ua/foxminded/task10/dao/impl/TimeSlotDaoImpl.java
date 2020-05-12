package com.ua.foxminded.task10.dao.impl;

import com.ua.foxminded.task10.dao.DaoInterface;
import com.ua.foxminded.task10.model.TimeSlot;
import com.ua.foxminded.task10.model.mapper.TimeSLotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimeSlotDaoImpl implements DaoInterface<TimeSlot> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_TIMESLOT = "select * from timeslots where timeSlotId = ?";
    private final String SQL_DELETE_TIMESLOT = "delete from timeSlots where timeSlotId = ?";
    private final String SQL_UPDATE_TIMESLOT = "update timeSlots set startLesson = ?, endLesson = ? where timeSlotId = ?";
    private final String SQL_GET_ALL_TIMESLOT = "select * from lessons";
    private final String SQL_INSERT_TIMESLOT = "insert into timeSlots(startLesson, endLesson) values(?,?)";

    @Override
    public TimeSlot getById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_TIMESLOT, new Object[]{id}, new TimeSLotMapper());
    }

    @Override
    public List<TimeSlot> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL_TIMESLOT, new TimeSLotMapper());
    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update(SQL_DELETE_TIMESLOT, id) > 0;
    }

    @Override
    public boolean update(TimeSlot timeSlot) {
        return jdbcTemplate.update(SQL_UPDATE_TIMESLOT, timeSlot.getStartLesson(), timeSlot.getEndLesson(),
                timeSlot.getTimeSlotId()) > 0;
    }

    @Override
    public boolean create(TimeSlot timeSlot) {
        return jdbcTemplate.update(SQL_INSERT_TIMESLOT, timeSlot.getStartLesson(), timeSlot.getEndLesson()) > 0;

    }
}