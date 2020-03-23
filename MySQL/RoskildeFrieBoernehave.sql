-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`city` (
  `city_id` INT NOT NULL,
  `city_zipcode` INT NOT NULL,
  PRIMARY KEY (`city_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`household`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`household` (
  `household_id` INT NOT NULL AUTO_INCREMENT,
  `household_adresse1` VARCHAR(45) NOT NULL,
  `city_city_id` INT NOT NULL,
  PRIMARY KEY (`household_id`),
  INDEX `fk_husstand_by1_idx` (`city_city_id` ASC) VISIBLE,
  CONSTRAINT `fk_husstand_by1`
    FOREIGN KEY (`city_city_id`)
    REFERENCES `mydb`.`city` (`city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`parent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`parent` (
  `parent_id` INT NOT NULL AUTO_INCREMENT,
  `parent_firstname` VARCHAR(45) NOT NULL,
  `parent_lastname` VARCHAR(45) NOT NULL,
  `parent_phonenumber` INT NOT NULL,
  `household_household_id` INT NOT NULL,
  PRIMARY KEY (`parent_id`),
  INDEX `fk_foraeldre_hustand1_idx` (`household_household_id` ASC) VISIBLE,
  CONSTRAINT `fk_foraeldre_hustand1`
    FOREIGN KEY (`household_household_id`)
    REFERENCES `mydb`.`household` (`household_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`room` (
  `room_id` INT NOT NULL AUTO_INCREMENT,
  `room_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`room_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`child`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`child` (
  `child_id` INT NOT NULL,
  `child_firstname` VARCHAR(45) NOT NULL,
  `child_lastname` VARCHAR(45) NOT NULL,
  `parent_id` VARCHAR(45) NOT NULL,
  `room_id` INT NOT NULL,
  `household_household_id` INT NOT NULL,
  PRIMARY KEY (`child_id`),
  INDEX `fk_boern_stue_idx` (`room_id` ASC) VISIBLE,
  INDEX `fk_boern_husstand1_idx` (`household_household_id` ASC) VISIBLE,
  CONSTRAINT `fk_boern_stue`
    FOREIGN KEY (`room_id`)
    REFERENCES `mydb`.`room` (`room_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_boern_husstand1`
    FOREIGN KEY (`household_household_id`)
    REFERENCES `mydb`.`household` (`household_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`employee` (
  `employee_id` INT NOT NULL,
  `employee_firstname` VARCHAR(45) NOT NULL,
  `employee_lastname` VARCHAR(45) NOT NULL,
  `employee_phonenumber` INT NOT NULL,
  PRIMARY KEY (`employee_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
