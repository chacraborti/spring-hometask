package com.epam.spring.hometask.controller;

import com.epam.spring.hometask.domain.EventRating;
import com.epam.spring.hometask.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.service.EventService;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/events")
public class EventController {

    @Autowired
    EventService eventService;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        Collection<Event> events = eventService.getAll();
        ModelAndView modelAndView = new ModelAndView("events");
        modelAndView.addObject("events", events);
        modelAndView.addObject("eventRatings", EventRating.values());
        return modelAndView;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getByName(@PathVariable String name) {
        eventService.getByName(name);
        return "events";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remove(@PathVariable String id) {
        eventService.remove(Integer.valueOf(id));
        return "events";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable String id) {
        eventService.getById(Integer.valueOf(id));
        return "events";
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public String saveEvent(@ModelAttribute("event") Event event) {
        eventService.save(event);
        return "redirect:/events";
    }

//    @RequestMapping(value = "/file", method = RequestMethod.POST)
//    public String uploadEvents(MultipartHttpServletRequest multipartRequest)
//            throws IOException {
//        final List<MultipartFile> files = multipartRequest.getFiles("file");
//
//        if (files.isEmpty() || files.stream().allMatch(MultipartFile::isEmpty)) {
//            throw new IllegalArgumentException("Either no files uploaded or all files are empty!");
//        }
//
//        final List<Event> newEvents = new ArrayList<>();
//        for (MultipartFile file : files) {
//            if (!file.isEmpty()) {
//                List<Event> events = Json.fromJsonCollection(file.getBytes(), Event.class);
//                newEvents.addAll(events);
//            }
//        }
}
