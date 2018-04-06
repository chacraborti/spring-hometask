package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.Event;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
@Repository
public class DiscountServiceDaoImpl implements DiscountServiceDao {

    @Override
    public int getDiscount(@Nonnull Event event, long numberOfTickets) {
        byte discount = 0;
        switch (event.getRating() ){
            case HIGH:
                break;
            case MID:
                discount+=1;
                break;
            case LOW:
                discount+=2;
                break;
            default:break;
        }

        discount+=numberOfTickets;

        return discount;
    }
}
