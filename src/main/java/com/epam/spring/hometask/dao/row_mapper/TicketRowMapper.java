package com.epam.spring.hometask.dao.row_mapper;

import org.springframework.jdbc.core.RowMapper;
import com.epam.spring.hometask.domain.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ilona on 20.12.17.
 */
public class TicketRowMapper implements RowMapper<Ticket>{
    @Override
    public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setId(resultSet.getInt(1));

//        ticket.setEvent();
//        ticket.setUser();
        return ticket;
    }
}
