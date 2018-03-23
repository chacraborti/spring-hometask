package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;

public interface UserDao {
    /**
     * Getting user by email
     */
    User getUserByEmail(@Nonnull String email);

    /**
     *Saving the user
     */
    User save(@Nonnull User object);

    /**
     * Removing user from the system
     */
    void remove(@Nonnull User object);

    /**
     * Getting user by id
     */
    User getById(@Nonnull Integer id);

    /**
     *  Getting all the users
     * @return
     */
    @Nonnull
    Collection<User> getAll();

    /**
     * Saving and getting all the users
     */
    List<Ticket> saveTicket(User user, List<Ticket> tickets);
}
