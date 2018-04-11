package com.epam.spring.hometask.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User extends DomainObject {

    private String firstName;
    private String login;
    private Long password;
    private String role;

    private List<Ticket> tickets = new ArrayList<>();

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
}
