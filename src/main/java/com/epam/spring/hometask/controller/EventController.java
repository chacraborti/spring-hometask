package com.epam.spring.hometask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.service.EventService;

import java.util.Collection;

@Controller
@RequestMapping(value = "/events")
public class EventController {

    @Autowired
    EventService eventService;


    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
    public String getByName(@ModelAttribute("model") ModelMap model, @PathVariable String name) {
        eventService.getByName(name);
        return "events";
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public String save(@ModelAttribute("model") ModelMap model, @RequestBody Event event) {
        eventService.save(event);
        return "events";
    }


    @RequestMapping(value = "/events/{id}", method = RequestMethod.DELETE)
    public String remove(@ModelAttribute("model") ModelMap model, @PathVariable String id) {
        eventService.remove(Integer.valueOf(id));
        return "events";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String getById(@ModelAttribute("model") ModelMap model,  @PathVariable String id) {
        eventService.getById(Integer.valueOf(id));
        return "events";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(@ModelAttribute("model") ModelMap model) {
        Collection<Event> events = eventService.getAll();
        model.addAttribute("events", events);

        return "events";
    }
}
