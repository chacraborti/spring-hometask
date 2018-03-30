package com.epam.spring.hometask.service;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

/**
 * @author Yuriy_Tkach
 */

public interface BookingService {

    /**
     * Getting price when buying all supplied seats for particular event
     * 
     * @param event Event to get base ticket price, vip seats and other
     *            information
     * @return total price
     */
    public double getTicketsPrice(@Nonnull Event event);

    /**
     * Books saveTicket in internal system. If user is not
     * <code>null</code> in a ticket then booked saveTicket are saved with it
     * 
     * @param tickets
     *            Set of saveTicket
     */
    public void bookTickets(@Nonnull Set<Ticket> tickets, User user);

    /**
     * Getting all purchased saveTicket for event on specific air date and time
     * 
     * @param event
     *            Event to get saveTicket for
     * @param dateTime
     *            Date and time of airing of event
     * @return set of all purchased saveTicket
     */
    public @Nonnull Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime);

    Collection<Ticket> getByUserName(String userName);

    Collection<Ticket> getByIdEvent(Integer idEvent);
}
