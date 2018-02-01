package ua.epam.spring.hometask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.epam.spring.hometask.service.BookingService;

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
//        model.addAttribute("price", service.getTicketPrice(event, auditorium, dateTime, Arrays.asList(seats), user));
//        return "price";
//    }
//
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


//    @RequestMapping("/ticketsForEvent")
//    public String getTicketsForEvent(@RequestParam String event,
//                                     @RequestParam String auditorium,
//                                     @RequestParam("eventTime") @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss") LocalDateTime dateTime,
//                                     Model model){
//        model.addAttribute("tickets", service.getTicketsForEvent(event, auditorium, dateTime));
//        return "tickets";
//    }



}
