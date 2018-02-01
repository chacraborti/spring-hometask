package ua.epam.spring.hometask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.dao.EventDao;
import ua.epam.spring.hometask.domain.Event;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventDao eventDao;

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return eventDao.getByName(name);
    }

    @Override
    public Event save(@Nonnull Event object) {
        return eventDao.save(object);
    }

    @Override
    public void remove(@Nonnull Event object) {
        eventDao.remove(object);
    }

    @Override
    public Event getById(@Nonnull Integer id) {
        try {
            return eventDao.getById(id);
        } catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return eventDao.getAll();
    }

}
