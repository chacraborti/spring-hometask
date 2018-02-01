package ua.epam.spring.hometask.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.epam.spring.hometask.dao.row_mapper.TicketRowMapper;
import ua.epam.spring.hometask.dao.row_mapper.UserRowMapper;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
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
    public User getUserByEmail(@Nonnull String login) throws EmptyResultDataAccessException {
        return jdbcTemplate.queryForObject("SELECT id, first_name, login FROM User WHERE login = ?", new Object[]{login}, new UserRowMapper());
    }

    @Override
    public User save(@Nonnull User object) {
        Integer id = object.getId();
        String name = object.getFirstName();
        String login = object.getLogin();
        jdbcTemplate.update("INSERT INTO User (first_name, login) VALUES(?,?);", new Object[]{id, name, login});
        return object;
    }

    @Override
    public void remove(@Nonnull User object) {
        jdbcTemplate.update("DELETE FROM User WHERE id = ?", new Object[]{object.getId()});
    }

    @Override
    public User getById(@Nonnull Integer id) throws EmptyResultDataAccessException {
          return jdbcTemplate.queryForObject("SELECT  id, first_name, login,  FROM User WHERE id = ?", new Object[] { id }, new UserRowMapper());
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM User;", new UserRowMapper());
    }

    @Override
    public List<Ticket> saveTicket(User user, List<Ticket> tickets) {
           return jdbcTemplate.query("INSERT INTO Ticket (id, idEvent, idUser) VALUES(?,?,?);", new TicketRowMapper());
    }
}
