package ua.epam.spring.hometask.dao.row_mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.epam.spring.hometask.domain.Ticket;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
