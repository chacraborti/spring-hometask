package ua.epam.spring.hometask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.dao.BookingServiceDao;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingServiceDao bookingServiceDao;

    @Override
    public double getTicketsPrice(@Nonnull Event event) {
        return  bookingServiceDao.getTicketsPrice(event);
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets, User user) {
        bookingServiceDao.bookTickets(tickets, user);
        for (Ticket ticket : tickets) {
            ticket.setUser(user);
        }
    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return bookingServiceDao.getPurchasedTicketsForEvent(event, dateTime);
    }
}
