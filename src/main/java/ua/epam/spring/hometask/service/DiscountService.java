package ua.epam.spring.hometask.service;

import ua.epam.spring.hometask.domain.Event;

import javax.annotation.Nonnull;

/**
 * @author Yuriy_Tkach
 */

public interface DiscountService {

    int getDiscount(@Nonnull Event event, long numberOfTickets);

}
