package ua.epam.spring.hometask.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.epam.spring.hometask.domain.Event;

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
