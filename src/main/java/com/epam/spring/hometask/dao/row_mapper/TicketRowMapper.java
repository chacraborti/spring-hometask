package com.epam.spring.hometask.dao.row_mapper;

import com.epam.spring.hometask.domain.Ticket;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ilona on 20.12.17.
 */
public class TicketRowMapper implements RowMapper<Ticket>{
    @Override
    public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
        Ticket ticket = new Ticket();
        String eventName = resultSet.getString(1);
        String userName = resultSet.getString(2);

        ticket.setEventName(eventName);
        ticket.setUserName(userName);
        return ticket;
    }
}
