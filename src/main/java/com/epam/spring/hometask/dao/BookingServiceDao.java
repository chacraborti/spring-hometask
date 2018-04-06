package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

public interface BookingServiceDao {
    /**
     * Getting the price for the ticket
     */
    double getTicketsPrice(@Nonnull Event event);

    /**
     * Ticket booking by user
     */
    void bookTickets(Ticket tickets, User user);

    /**
     * Getting list of tickets purchased by the customer
     */
    @Nonnull Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime);


    Collection<Ticket> getByUserName(String userName);

    Collection<Ticket> getByIdEvent(Integer idEvent);

    Collection<Ticket> getAll();
}
