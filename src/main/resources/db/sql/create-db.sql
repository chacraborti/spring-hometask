DROP TABLE Event IF EXISTS;
DROP TABLE EventRating IF EXISTS;
DROP TABLE Ticket IF EXISTS;
DROP TABLE User IF EXISTS;
DROP TABLE UserAccount IF EXISTS;

CREATE TABLE Event (
  id bigint auto_increment,
  name VARCHAR(45) NULL,
  base_price INT NULL,
  idEventType INT NULL,
  PRIMARY KEY (id));

CREATE TABLE EventRating (
  id bigint auto_increment,
  name VARCHAR(45) NULL,
  PRIMARY KEY (id));

CREATE TABLE Ticket (
  id bigint auto_increment,
  idEvent INT NULL,
  idUser INT NULL,
  PRIMARY KEY (id));

CREATE TABLE UserAccount (
  id bigint auto_increment,
  moneyQuantity INT NULL,
  idUser INT NULL,
PRIMARY KEY (id));


CREATE TABLE User (
  id bigint auto_increment,
  first_name VARCHAR(45) NULL,
  login VARCHAR(45) NULL,
  password VARCHAR(60) NULL,
  roles VARCHAR(45) NULL,
  PRIMARY KEY (id));