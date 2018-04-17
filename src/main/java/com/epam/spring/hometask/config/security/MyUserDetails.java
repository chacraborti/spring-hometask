package com.epam.spring.hometask.config.security;

import com.epam.spring.hometask.domain.Role;
import com.epam.spring.hometask.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private final String userName;
    private final String userPassword;
    List<Role> roles;
   private final List<MyGrantedAuthority> myGrantedAuthorityList;

    public MyUserDetails(User user) {

        userName = user.getFirstName();
        userPassword = user.getPassword();
        roles = user.getRoles();
        List<Role> roles = user.getRoles();

        List<MyGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles){
            authorities.add(new MyGrantedAuthority(role.name()));
        }

        myGrantedAuthorityList = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return myGrantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}