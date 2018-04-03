package com.epam.spring.hometask.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {

 @Autowired
 private DataSource dataSource;
 
 @PostConstruct
 public void initialize(){
  try {
   Connection connection = dataSource.getConnection();
   Statement statement = connection.createStatement();
   statement.execute("DROP TABLE IF EXISTS Event");
   statement.execute("DROP TABLE IF EXISTS EventRating");
   statement.execute("DROP TABLE IF EXISTS Ticket");
   statement.execute("DROP TABLE IF EXISTS User");
   statement.executeUpdate(
     "CREATE TABLE `theatre.sqlite`.`Event` (\n" +
             "  `idEvent` INT NOT NULL AUTO_INCREMENT,\n" +
             "  `name` VARCHAR(45) NULL,\n" +
             "  `base_price` INT NULL,\n" +
             "  `idEventType` INT NULL,\n" +
             "  PRIMARY KEY (`idEvent`));"
     );
      statement.executeUpdate(
              "CREATE TABLE `theatre`.`EventRating` (\n" +
                      "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                      "  `name` VARCHAR(45) NULL,\n" +
                      "  PRIMARY KEY (`id`));"
      );
      statement.executeUpdate(
              "CREATE TABLE `theatre`.`Ticket` (\n" +
                      "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                      "  `idEvent` INT NULL,\n" +
                      "  `idUser` INT NULL,\n" +
                      "  PRIMARY KEY (`id`));"
      );
      statement.executeUpdate(
              "CREATE TABLE `theatre`.`User` (\n" +
                      "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                      "  `first_name` VARCHAR(45) NULL,\n" +
                      "  `login` VARCHAR(45) NULL,\n" +
                      "  PRIMARY KEY (`id`));"
      );
      statement.executeUpdate(
     "INSERT INTO User (first_name, login) VALUES(\"andrew\",\"Andrew\");"
     );
      statement.executeUpdate(
              "INSERT INTO Event (name) VALUES(\"Casablanca\");"
      );
      statement.executeUpdate(
              "INSERT INTO Event (name) VALUES(\"Saw\");"
      );
      statement.executeUpdate(
              "INSERT INTO Event (name) VALUES(\"Doctor Who\");"
      );
      statement.executeUpdate(
              "insert into EventRating (name) values (\"HIGH\");"
      );
   statement.close();
   connection.close();
  }
  catch (SQLException e) {
   e.printStackTrace();
  }
 }
}