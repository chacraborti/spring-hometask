package ua.epam.spring.hometask.domain;

/**
 * @author Yuriy_Tkach
 */
public class Ticket extends DomainObject implements Comparable<Ticket> {

    private User user;

    private Event event;

    public Ticket() {
    }

    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public int compareTo(Ticket other) {
        return event.getName().compareTo(other.getEvent().getName());
    }

}
