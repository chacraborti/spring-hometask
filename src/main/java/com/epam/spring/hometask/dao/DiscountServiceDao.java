package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.Event;

import javax.annotation.Nonnull;

public interface DiscountServiceDao {
    /**
     * Getting the discount for the event
     */
    int getDiscount(@Nonnull Event event, long numberOfTickets);
}
