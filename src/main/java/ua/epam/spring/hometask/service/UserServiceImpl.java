package ua.epam.spring.hometask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.dao.UserDao;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        try{
            return userDao.getUserByEmail(email);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public User save(@Nonnull User object) {
        if(!getAll().contains(object)){
            return userDao.save(object);
        }
        return null;
    }

    @Override
    public void remove(@Nonnull User object) {
        userDao.remove(object);
    }

    @Override
    public User getById(@Nonnull Integer id) {
        try{
            return userDao.getById(id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<Ticket> saveTicket(User user, List<Ticket> ticketstoSave) {
        List<Ticket> tickets = user.getTickets();
        tickets.addAll(ticketstoSave);

        return tickets;
    }
}
