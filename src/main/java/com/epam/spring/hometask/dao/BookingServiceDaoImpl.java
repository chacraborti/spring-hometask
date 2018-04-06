package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.dao.row_mapper.EventRowMapper;
import com.epam.spring.hometask.dao.row_mapper.TicketRowMapper;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
@Repository
public class BookingServiceDaoImpl implements BookingServiceDao{

    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Qualifier("jdbcTemplate")
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public double getTicketsPrice(Event event) {
        Event e =  jdbcTemplate.queryForObject("SELECT base_price  FROM Ticket WHERE id = ?", new Object[] { event.getId() }, new EventRowMapper());
        return e.getBasePrice();
    }

    @Override
    public void bookTickets(Ticket tickets, User user) {
    }

    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return null;
    }

    @Override
    public Collection<Ticket> getByUserName(String userName) {
        return jdbcTemplate.query("select Event.name, user.first_name from ticket join event on event.idEvent = ticket.idEvent join user on user.id = ticket.idUser WHERE User.first_name = ?", new Object[] { userName }, new TicketRowMapper());
    }

    @Override
    public Collection<Ticket> getByIdEvent(Integer idEvent) {
        return jdbcTemplate.query("select Event.name, user.first_name from ticket join event on event.idEvent = ticket.idEvent join user on user.id = ticket.idUser WHERE idEvent = ?", new Object[] { idEvent }, new TicketRowMapper());
    }

    @Override
    public Collection<Ticket> getAll() {
        return jdbcTemplate.query("select Event.name, user.first_name from ticket join event on event.idEvent = ticket.idEvent join user on user.id = ticket.idUser", new TicketRowMapper());
    }
}
