package com.epam.spring.hometask.controller;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.EventRating;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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


//    @GetMapping(value = "/tickets", headers = "accept=application/pdf")
//    public ModelAndView getTickets(@RequestParam String eventName, @RequestParam String auditorium,
//                                   @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateEvent)
//    {
//        List<Ticket> tickets = bookingService.getTicketsForEvent(eventName, auditorium, dateEvent);
//        return new ModelAndView("pdfView", "tickets",  tickets);
//    }
//}

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET, headers = "accept=application/pdf")
    public ModelAndView getByUserName(@PathVariable String name,
                                      Model model) {
        Collection<Ticket> tickets = service.getByUserName(name);
        model.addAttribute("tickets", tickets);
        return new ModelAndView("pdfView", "tickets", tickets);
    }

    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET, headers = "accept=application/pdf")
    public ModelAndView getByIdEvent(@PathVariable Integer id,
                                     Model model) {
        Collection<Ticket> tickets = service.getByIdEvent(id);
        model.addAttribute("tickets", tickets);
        return new ModelAndView("pdfView", "tickets", tickets);
    }
}
