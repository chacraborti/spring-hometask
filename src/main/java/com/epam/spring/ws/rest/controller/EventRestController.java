package com.epam.spring.ws.rest.controller;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.EventRating;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.service.EventService;
import com.epam.spring.hometask.util.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(value = "/events")
public class EventRestController {

    @Autowired
    EventService eventService;



    @GetMapping
    public ModelAndView getAll() {
        Collection<Event> events = eventService.getAll();
        ModelAndView modelAndView = new ModelAndView("events");
        modelAndView.addObject("events", events);
        modelAndView.addObject("eventRatings", EventRating.values());
        return modelAndView;
    }

    @GetMapping(value = "/{name}")
    public String getByName(@PathVariable String name) {
        eventService.getByName(name);
        return "events";
    }

    @GetMapping(value = "/{id}")
    public String remove(@PathVariable String id) {
        eventService.remove(Integer.valueOf(id));
        return "events";
    }

    @GetMapping(value = "/{id}")
    public String getById(@PathVariable String id) {
        eventService.getById(Integer.valueOf(id));
        return "events";
    }

    @PostMapping(value = "/event")
    public String saveEvent(@ModelAttribute("eventForm") Event event) {
        eventService.save(event);
        return "redirect:/events";
    }

    @PostMapping(value = "/book")
    public String bookEvent(@ModelAttribute("bookForm") Event event) {
        eventService.bookEvent(new Ticket(1, 2));
        return "redirect:/events";
    }


    @PostMapping(value = "/file")
    public String eventsUpload(@RequestParam("file") MultipartFile file,
                               RedirectAttributes redirectAttributes) throws IOException {

        final List<Event> events = new ArrayList<>();

        if (!file.isEmpty()) {
            events.addAll(JsonParser.convertJsonToList(file.getBytes(), Event.class));
        }

        for (Event event : events)
            eventService.save(event);


        return "redirect:/events";
    }

    @PostMapping(value = "/uploadMultipleFile")
    public @ResponseBody
    String uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files) {
        final List<MultipartFile> fileList = Arrays.asList(files);

        final List<Event> eventList = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    eventList.addAll(JsonParser.convertJsonToList(file.getBytes(), Event.class));
                } catch (IOException e) {
                    return "redirect:/error";
                }
            }
        }
        for (Event event : eventList) {
            eventService.save(event);
        }
        return "redirect:/events";
    }
}
