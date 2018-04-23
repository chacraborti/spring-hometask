package com.epam.spring.hometask.domain;

/**
 * @author Yuriy_Tkach
 */
public class Ticket extends DomainObject implements Comparable<Ticket> {

    private String userName;

    private String eventName;

    public Ticket() {
    }

    public Ticket(String userName, String eventName) {
        this.userName = userName;
        this.eventName = eventName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userId) {
        this.userName = userId;
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
