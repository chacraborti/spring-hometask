package com.epam.spring.hometask.controller;

import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService service;

//    @RequestMapping(value = "/getPrice", method = RequestMethod.GET)
//    public String getPrice(@RequestParam String event,
//                           @RequestParam String auditorium,
//                           @RequestParam("eventTime") @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss") LocalDateTime dateTime,
//                           @RequestParam(value = "seats") Integer[] seats,
//                           @RequestParam User user,
//                           Model model) { //Model @ModelAttribute("model") ModelMap model
//        model.addAttribute("price", service.getTicketsPrice(event, auditorium, dateTime, Arrays.asList(seats), user));
//        return "price";
//    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String bookTicket(@RequestParam Ticket ticket,
//                             @RequestParam User user,
//                             Model model) {
//        model.addAttribute("ticket", service.bookTicket(user, ticket));
//        return "ticket";
//    }
//
//    @RequestMapping("/ticketsForEvent")
//    public String getTicketsForEvent(@RequestParam String event,
//                                     @RequestParam String auditorium,
//                                     @RequestParam("eventTime") @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss") LocalDateTime dateTime,
//                                     Model model){
//        model.addAttribute("tickets", service.getTicketsForEvent(event, auditorium, dateTime));
//        return "tickets";
//    }
//
//
//    @RequestMapping("/ticketsForEvent")
//    public String getTicketsForEvent(@RequestParam String event,
//                                     @RequestParam String auditorium,
//                                     @RequestParam("eventTime") @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss") LocalDateTime dateTime,
//                                     Model model){
//        model.addAttribute("tickets", service.getTicketsForEvent(event, auditorium, dateTime));
//        return "tickets";
//    }

//        List<Course> documents = Arrays.asList(
//                new Course(1, "Spring MVC PDF IText Example", new Date()),
//                new Course(3, "Spring MVC PDF Lowagie Example", new Date())
//        );

        @RequestMapping(value = "/{name}", method = RequestMethod.GET)
        public String getByUserName(@RequestParam String name,
                                  Model model) {
            Collection<Ticket> tickets = service.getByUserName(name);
            model.addAttribute("tickets", tickets);
            return "ticket";
        }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getByIdEvent(@RequestParam Integer id,
                              Model model) {
        Collection<Ticket> tickets = service.getByIdEvent(id);
        model.addAttribute("tickets", tickets);
        return "ticket";
    }
}
