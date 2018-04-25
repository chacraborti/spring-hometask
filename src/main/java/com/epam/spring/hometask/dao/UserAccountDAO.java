package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.UserAccount;
public interface UserAccountDAO {

    UserAccount create(UserAccount userAccount);

    UserAccount getById(int id);

    UserAccount update(UserAccount userAccount);
}
