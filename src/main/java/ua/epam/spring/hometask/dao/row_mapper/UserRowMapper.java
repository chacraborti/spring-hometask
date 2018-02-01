package ua.epam.spring.hometask.dao.row_mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.epam.spring.hometask.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ilona on 20.12.17.
 */
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(1));
        user.setFirstName(resultSet.getString(2));
        user.setLogin(resultSet.getString(3));
        return user;
    }
}
