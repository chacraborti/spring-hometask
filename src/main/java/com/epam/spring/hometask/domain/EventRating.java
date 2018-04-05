package com.epam.spring.hometask.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Yuriy_Tkach
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EventRating {

    LOW(0),

    MID(1),

    HIGH(2);

    private int id;

    EventRating(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static EventRating valueOf(Integer id) {
        for (EventRating rating : values()) {
            if (rating.getId() == id.intValue()) {
                return rating;
            }
        }
        throw new RuntimeException(EventRating.class.getName() + ": not found Enum by ID = " + id);
    }
}
