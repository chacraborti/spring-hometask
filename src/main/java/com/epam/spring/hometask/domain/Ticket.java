package com.epam.spring.hometask.domain;

/**
 * @author Yuriy_Tkach
 */
public class Ticket extends DomainObject implements Comparable<Ticket> {

    private String userName;

    private String eventName;

    public Ticket() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public int compareTo(Ticket o) {
        return 0;
    }
}
