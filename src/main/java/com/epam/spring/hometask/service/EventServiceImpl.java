package com.epam.spring.hometask.service;

import com.epam.spring.hometask.dao.EventDao;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

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
    public void remove(@Nonnull Integer id) {
        eventDao.remove(id);
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

    @Override
    public void bookEvent(Ticket ticket) {
        eventDao.bookEvent(ticket);
    }

}
