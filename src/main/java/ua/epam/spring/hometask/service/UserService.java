package ua.epam.spring.hometask.service;

import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

/**
 * @author Yuriy_Tkach
 */

public interface UserService {

    @Nullable User getUserByEmail(@Nonnull String email);

    User save(@Nonnull User object);

    void remove(@Nonnull User object);

    User getById(@Nonnull Integer id);

    @Nonnull
    Collection<User> getAll();

    List<Ticket> saveTicket(User user, List<Ticket> tickets);
}
