package com.epam.spring.hometask.domain;

/**
 * @author Yuriy_Tkach
 */
public class DomainObject {

    private Integer id;

    public DomainObject() {
    }

    public DomainObject(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
