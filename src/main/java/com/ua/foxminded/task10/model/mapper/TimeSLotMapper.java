package com.ua.foxminded.task10.model.mapper;

import com.ua.foxminded.task10.model.TimeSlot;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TimeSLotMapper implements RowMapper<TimeSlot> {
    @Override
    public TimeSlot mapRow(ResultSet resultSet, int i) throws SQLException {
        TimeSlot timeSLot = new TimeSlot();
        timeSLot.setTimeSlotId(resultSet.getLong("TimeSlotId"));
        timeSLot.setStartLesson(resultSet.getTimestamp("startLesson").toLocalDateTime());
        timeSLot.setEndLesson(resultSet.getTimestamp("endLesson").toLocalDateTime());
        return null;
    }
}
