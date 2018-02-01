package ua.epam.spring.hometask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.dao.DiscountServiceDao;
import ua.epam.spring.hometask.domain.Event;

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
