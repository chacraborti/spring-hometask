package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.dao.row_mapper.EventRowMapper;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

@Repository
public class EventDaoImpl implements EventDao {
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Qualifier("jdbcTemplate")
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return null;
    }

    @Override
    public Event save(@Nonnull Event object) {
        String name = object.getName();
        int price = object.getBasePrice();
        Integer idEventType = object.getRating().ordinal();
        jdbcTemplate.update("INSERT INTO Event (name, base_price, idEventType) VALUES(?,?,?);", new Object[]{name, price, idEventType});
        return object;
    }

    @Override
    public void remove(@Nonnull Integer id) {
        jdbcTemplate.update("DELETE FROM Event WHERE id = ?", new Object[]{id});
    }

    @Override
    public Event getById(@Nonnull Integer id) throws EmptyResultDataAccessException {
      return jdbcTemplate.queryForObject("SELECT idEvent, name, base_price, idEventType from Event where idEvent = ?", new Object[] { id }, new EventRowMapper());
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return jdbcTemplate.query("SELECT * FROM Event;", new EventRowMapper());
    }

    @Override
    public void bookEvent(Ticket ticket) {
        jdbcTemplate.update("INSERT INTO Ticket (idEvent, idUser) VALUES(?,?)", new Object[]{ticket.getEventName(), ticket.getUserName()});
    }
}
