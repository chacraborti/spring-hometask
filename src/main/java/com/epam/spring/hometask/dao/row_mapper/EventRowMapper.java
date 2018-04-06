package com.epam.spring.hometask.dao.row_mapper;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.EventRating;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ilona on 20.12.17.
 */
public class EventRowMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event();
        event.setId(resultSet.getInt(1));
        event.setName(resultSet.getString(2));
        event.setBasePrice(resultSet.getInt(3));
        event.setRating(EventRating.valueOf(resultSet.getInt(4)));
        return event;
    }
}
