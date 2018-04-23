package com.epam.spring.hometask.config;

import com.epam.spring.hometask.dao.UserDao;
import com.epam.spring.hometask.domain.Role;
import com.epam.spring.hometask.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ilona on 20.04.18.
 */
@Component
public class Initializer {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostConstruct
    public void initialize() throws IOException {
        Map initialData = getData();

        initializeUsers(initialData);

    }

    private void initializeUsers(Map initialData) {
        List<Map> users = (List<Map>) initialData.get("users");

        for (Map user : users) {
            User toSave = new User();

            toSave.setFirstName((String) user.get("first_name"));
            toSave.setLogin((String) user.get("login"));
            String password = (String) user.get("password");

            toSave.setPassword(passwordEncoder.encode(password));

            List<String> roles = (List<String>) user.get("roles");
            List<Role> roleList = new ArrayList<>();
            if (roles != null && !roles.isEmpty()) {
                for (String role : roles) {
                    roleList.add(Role.valueOf(role));
                }
            }
            toSave.setRoles(roleList);

            userDao.save(toSave);
        }

    }

    private Map getData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream resourceAsStream = Initializer.class.getClassLoader().getResourceAsStream("init.json");
        return objectMapper.readValue(resourceAsStream, Map.class);
    }

}
