package com.epam.spring.hometask.dao;


import com.epam.spring.hometask.dao.row_mapper.UserAccountRowMapper;
import com.epam.spring.hometask.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserAccountDAOImpl implements UserAccountDAO {

    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Qualifier("jdbcTemplate")
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public UserAccount create(UserAccount userAccount) {
        jdbcTemplate.update("INSERT INTO UserAccount (moneyQuantity, idUser) VALUES(?,?);", new Object[]{userAccount.getMoneyQuantity(), userAccount.getUserId()});
        return userAccount;
    }

    @Override
    public UserAccount getById(int id) {
        return jdbcTemplate.queryForObject("SELECT  * FROM UserAccount WHERE id = ?", new Object[] { id }, new UserAccountRowMapper());
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
        jdbcTemplate.update("UPDATE UserAccount SET (moneyQuantity, idUser) VALUES(?,?);", new Object[]{userAccount.getMoneyQuantity(), userAccount.getUserId()});
        return userAccount;
    }

}
