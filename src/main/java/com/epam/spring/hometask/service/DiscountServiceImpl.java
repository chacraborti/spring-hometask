package com.epam.spring.hometask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epam.spring.hometask.dao.DiscountServiceDao;
import com.epam.spring.hometask.domain.Event;

import javax.annotation.Nonnull;
@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    DiscountServiceDao discountServiceDao;

    @Override
    public int getDiscount(@Nonnull Event event, long numberOfTickets) {
        return discountServiceDao.getDiscount(event, numberOfTickets);
    }
}
