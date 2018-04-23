package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.Ticket;

import javax.annotation.Nonnull;
import java.util.Collection;

public interface EventDao {
    /**
     * Getting event by name
     */
    Event getByName(@Nonnull String name);

    /**
     * Saving the event
     */
    Event save(@Nonnull Event object);

    /**
     * Removing the event by id
     * @param id
     */
    void remove(@Nonnull Integer id);

    /**
     * Grtting event by id
     */
    Event getById(@Nonnull Integer id);

    /**
     * Getting all the events avaliable
     */
    Collection<Event> getAll();

    void bookEvent(Ticket ticket);
}
