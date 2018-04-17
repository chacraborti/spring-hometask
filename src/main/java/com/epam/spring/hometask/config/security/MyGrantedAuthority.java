package com.epam.spring.hometask.config.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Alyx on 09.04.2016.
 */
public class MyGrantedAuthority implements GrantedAuthority {
    private final String authority;

    public MyGrantedAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
