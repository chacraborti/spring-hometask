package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Set;

public interface BookingServiceDao {
    /**
     * Getting the price for the ticket
     */
    double getTicketsPrice(@Nonnull Event event);

    /**
     * Ticket booking by user
     */
    void bookTickets(@Nonnull Set<Ticket> tickets, User user);

    /**
     * Getting list of tickets purchased by the customer
     */
    @Nonnull Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime);
}
