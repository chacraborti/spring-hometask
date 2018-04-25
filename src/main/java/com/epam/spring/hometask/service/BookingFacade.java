package com.epam.spring.hometask.service;

import com.epam.spring.hometask.domain.User;

public interface BookingFacade extends BookingService {

    void deposit(double amount, User user);
}
