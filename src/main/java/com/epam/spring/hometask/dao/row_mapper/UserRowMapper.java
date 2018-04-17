package com.epam.spring.hometask.dao.row_mapper;

import com.epam.spring.hometask.domain.Role;
import com.epam.spring.hometask.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilona on 20.12.17.
 */
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        String roles = resultSet.getString("roles");
        List<Role> roleList = new ArrayList<>();
        for (String role : roles.split(" ")){
            roleList.add(Role.valueOf(role));
        }

        user.setRoles(roleList);
        return user;
    }
}
