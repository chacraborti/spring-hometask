package com.epam.spring.hometask.service;

import com.epam.spring.hometask.domain.Event;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 * @author Yuriy_Tkach
 */

public interface EventService {

    public @Nullable Event getByName(@Nonnull String name);
    Event save(@Nonnull Event object);

    void remove(@Nonnull Integer id);

    Event getById(@Nonnull Integer id);

    @Nonnull
    Collection<Event> getAll();
}
