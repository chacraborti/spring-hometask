package com.epam.spring.hometask.controller;

import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.service.BookingFacade;
import com.epam.spring.hometask.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingFacade service;
//
//    @RequestMapping(method = RequestMethod.POST)
//    public String bookTicket(@RequestParam Ticket ticket,
//                             @RequestParam User user,
//                             Model model) {
//        model.addAttribute("ticket", service.bookTickets(ticket, user));
//        return "ticket";
//    }

    @RequestMapping(method = RequestMethod.GET, headers = "accept=application/pdf")
    public ModelAndView getByUserName(Model model) {
        Collection<Ticket> tickets = service.getAll();
        model.addAttribute("tickets", tickets);
        return new ModelAndView("pdfView", "tickets", tickets);
    }

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
