package com.epam.spring.hometask.service;


import com.epam.spring.hometask.domain.UserAccount;

public interface UserAccountService {

    void addMoney(UserAccount account, int amount);

    void withdrawMoney(UserAccount account, int amount);

    UserAccount getById(int id);

}
