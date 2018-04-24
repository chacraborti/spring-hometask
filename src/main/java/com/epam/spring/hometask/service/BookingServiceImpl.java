package com.epam.spring.hometask.service;

import com.epam.spring.hometask.dao.BookingServiceDao;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.Collection;
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
    public void bookTickets(Ticket ticket, User user) {
        bookingServiceDao.bookTickets(ticket, user);
        ticket.setUserId(user.getId());
    }

    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return bookingServiceDao.getPurchasedTicketsForEvent(event, dateTime);
    }

    @Override
    public Collection<Ticket> getByUserName(String userName) {
        return bookingServiceDao.getByUserName(userName);
    }

    @Override
    public Collection<Ticket> getByIdEvent(Integer idEvent) {
        return bookingServiceDao.getByIdEvent(idEvent);
    }

    @Override
    public Collection<Ticket> getAll() {
        return bookingServiceDao.getAll();
    }
}
