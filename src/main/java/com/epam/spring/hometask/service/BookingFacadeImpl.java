package com.epam.spring.hometask.service;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Transactional(readOnly = true)
@Service
public class BookingFacadeImpl implements BookingFacade {


    @Autowired
    private  BookingService bookingService;
    @Autowired
    private  UserService userService;
    @Autowired
    private  EventService eventService;
    @Autowired
    private UserAccountService userAccountService;

    @Override
    public void deposit(double amount, User user) {

    }

    @Override
    public double getTicketsPrice(@Nonnull Event event) {
        return bookingService.getTicketsPrice(event);
    }

    @Override
    @Transactional
    public void bookTickets(Ticket ticket, User user) {
        UserAccount account = userAccountService.getById(user.getId());
        Event event = eventService.getById(ticket.getEventId());
        userAccountService.withdrawMoney(account, event.getBasePrice());

        bookingService.bookTickets(ticket, user);
    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return bookingService.getPurchasedTicketsForEvent(event, dateTime);
    }

    @Override
    public Collection<Ticket> getByUserName(String userName) {
        return bookingService.getByUserName(userName);
    }

    @Override
    public Collection<Ticket> getByIdEvent(Integer idEvent) {
        return bookingService.getByIdEvent(idEvent);
    }

    @Override
    public Collection<Ticket> getAll() {
        return bookingService.getAll();
    }

//    @Transactional
//    public void deposit(double amount, User user) {
//        UserAccount account = userAccountService.getByUser(user);
//        userAccountService.deposit(account, amount);
//    }
}
