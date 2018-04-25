package com.epam.spring.hometask.dao.row_mapper;

import com.epam.spring.hometask.domain.UserAccount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserAccountRowMapper implements RowMapper<UserAccount> {

    @Override
    public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(rs.getInt(1));
        userAccount.setMoneyQuantity(rs.getInt(2));
        userAccount.setUserId(rs.getInt(3));
        return null;
    }
}
