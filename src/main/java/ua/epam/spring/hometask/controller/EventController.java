package ua.epam.spring.hometask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.service.EventService;

import java.util.Collection;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String getAll(@ModelAttribute("model") ModelMap model) {
        Collection<Event> events = eventService.getAll();
        model.addAttribute("events", events);

        return "index";
    }

}
