package com.epam.spring.hometask.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.epam.spring.hometask.dao.row_mapper.EventRowMapper;
import com.epam.spring.hometask.domain.Event;

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
        Double price = object.getBasePrice();
        Integer idEventRating = object.getRating().ordinal();
        jdbcTemplate.update("INSERT INTO Event (name, base_price, idEventRating) VALUES(?,?,?);", new Object[]{name, price, idEventRating});
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
}
