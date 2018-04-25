package com.epam.spring.hometask.service;


import com.epam.spring.hometask.dao.UserAccountDAO;
import com.epam.spring.hometask.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountDAO userAccountDAO;

    @Override
    public void addMoney(UserAccount account, int quantity) {
        int currentAmount = account.getMoneyQuantity();
        account.setMoneyQuantity(currentAmount + quantity);
        userAccountDAO.update(account);
    }

    @Override
    public void withdrawMoney(UserAccount account, int quantity) {
        int currentAmount = account.getMoneyQuantity();
        account.setMoneyQuantity(currentAmount - quantity);
        userAccountDAO.update(account);
    }

    @Override
    public UserAccount getById(int id) {
        return userAccountDAO.getById(id);
    }
}
