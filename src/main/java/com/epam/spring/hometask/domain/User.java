package com.epam.spring.hometask.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlType(propOrder = {"firstName", "login", "password", "roles", "tickets"})
//@XmlAccessorType(XmlAccessType.FIELD)
public class User extends DomainObject {

    private String firstName;
    private String login;
    private String password;
    private List<Role> roles;

    private List<Ticket> tickets = new ArrayList<>();

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }
    @XmlElement
    public void setLogin(String login) {
        this.login = login;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
    @XmlElementWrapper
    @XmlElement
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getPassword() {
        return password;
    }
    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }
    @XmlElementWrapper
    @XmlElement
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getRolesAsSting(){
        StringBuilder builder = new StringBuilder();
        for (Role role : roles) {
            builder.append(role.toString());
        }
        return builder.toString();
    }
}
