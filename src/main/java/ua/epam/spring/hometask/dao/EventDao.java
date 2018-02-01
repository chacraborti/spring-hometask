package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Event;

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
     * Removing the event
     * @param object
     */
    void remove(@Nonnull Event object);

    /**
     * Grtting event by id
     */
    Event getById(@Nonnull Integer id);

    /**
     * Getting all the events avaliable
     */
    Collection<Event> getAll();
}
