package com.epam.spring.hometask.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Event extends DomainObject {

    private String name;

    private int basePrice;

    private EventRating rating;

    public Event() {
    }

    @Autowired
    public Event(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getBasePrice() {
        return basePrice;
    }
    @XmlElement
    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public EventRating getRating() {
        return rating;
    }
    @XmlElement
    public void setRating(EventRating rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Event other = (Event) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
