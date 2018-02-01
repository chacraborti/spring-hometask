CREATE SCHEMA `theatre` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

CREATE TABLE `theatre`.`Event` (
  `idEvent` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `base_price` INT NULL,
  `idEventType` INT NULL,
  PRIMARY KEY (`idEvent`));

CREATE TABLE `theatre`.`EventRating` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `theatre`.`Ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idEvent` INT NULL,
  `idUser` INT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `theatre`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `login` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

INSERT INTO User (first_name, login) VALUES("andrew","Andrew");

INSERT INTO Event (name) VALUES("Casablanca");
INSERT INTO Event (name) VALUES("Saw");
INSERT INTO Event (name) VALUES("Doctor Who");

insert into EventRating (name) values ("HIGH");