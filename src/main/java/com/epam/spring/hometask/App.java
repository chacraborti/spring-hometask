package com.epam.spring.hometask;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import com.epam.spring.hometask.aspect.CounterAspect;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.DiscountService;
import com.epam.spring.hometask.service.EventService;
import com.epam.spring.hometask.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    @Autowired
    UserService userService;
    @Autowired
    EventService eventService;
    @Autowired
    DiscountService discountService;
    @Autowired
    CounterAspect countAspect;

    public App() {
    }

    public void run(ApplicationContext ctx) {
        System.out.println("Please, enter your login");

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();


        while (userService.getUserByEmail(line)==null){
            System.out.println("Wrong login. Please, enter your login");
            line = scanner.nextLine();
        }
        User user = userService.getUserByEmail(line);

        System.out.println("Welcome, " + user.getFirstName() + ". Select the movie number you want to by ticket on :");

        eventService.getAll().forEach(event -> System.out.println(event.getId() + " " + event.getName() + " / price: " + event.getBasePrice()));

        Event event = getEventById(scanner);

        if (event != null) {
            System.out.println("How much tickets do you want to buy?");
            line = scanner.nextLine();
            Integer numOfTickets = Integer.valueOf(line);
            System.out.println("The final price will be: " + (event.getBasePrice() - discountService.getDiscount(event, numOfTickets))*numOfTickets);

            List<Ticket> tickets = new ArrayList<>();
            while (numOfTickets!=0){
                Ticket ticket = new Ticket();
                ticket.setUser(user);
                ticket.setEvent(event);
                user.getTickets().add(ticket);
                numOfTickets--;
            }

            userService.saveTicket(user, tickets);

            System.out.println("Tickets you purchased: ");
            user.getTickets().forEach(ticket -> System.out.println(ticket.getEvent().getName() + " for the name of: " + user.getFirstName()));
        } else {
            System.out.println("Wrong number");
        }

        System.out.println(countAspect.getCounter().size());
    }



    private Event getEventById(Scanner scanner) {
        String line = scanner.nextLine();
        Event selectedEvent = eventService.getById(Integer.valueOf(line));

        return selectedEvent;
    }

}
