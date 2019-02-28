-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cupcakedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cupcakedb` ;

-- -----------------------------------------------------
-- Schema cupcakedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cupcakedb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `cupcakedb` ;

-- -----------------------------------------------------
-- Table `cupcakedb`.`bottoms`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcakedb`.`bottoms` ;

CREATE TABLE IF NOT EXISTS `cupcakedb`.`bottoms` (
  `bottom_id` INT(11) NOT NULL AUTO_INCREMENT,
  `bottom_name` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`bottom_id`),
  UNIQUE INDEX `bottom_id_UNIQUE` (`bottom_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcakedb`.`customers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcakedb`.`customers` ;

CREATE TABLE IF NOT EXISTS `cupcakedb`.`customers` (
  `username` VARCHAR(12) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `balance` DOUBLE NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcakedb`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcakedb`.`orders` ;

CREATE TABLE IF NOT EXISTS `cupcakedb`.`orders` (
  `order_number` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`order_number`),
  INDEX `username` (`username` ASC) VISIBLE,
  UNIQUE INDEX `order_number_UNIQUE` (`order_number` ASC) VISIBLE,
  CONSTRAINT `orders_ibfk_1`
    FOREIGN KEY (`username`)
    REFERENCES `cupcakedb`.`customers` (`username`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcakedb`.`toppings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcakedb`.`toppings` ;

CREATE TABLE IF NOT EXISTS `cupcakedb`.`toppings` (
  `topping_id` INT(11) NOT NULL AUTO_INCREMENT,
  `topping_name` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`topping_id`),
  UNIQUE INDEX `topping_id_UNIQUE` (`topping_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcakedb`.`ordered_cupcakes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cupcakedb`.`ordered_cupcakes` ;

CREATE TABLE IF NOT EXISTS `cupcakedb`.`ordered_cupcakes` (
  `order_number` INT(11) NOT NULL,
  `topping_id` INT(11) NOT NULL,
  `bottom_id` INT(11) NOT NULL,
  `amount` INT(11) NOT NULL,
  INDEX `order_number` (`order_number` ASC) VISIBLE,
  INDEX `topping_id` (`topping_id` ASC) VISIBLE,
  INDEX `bottom_id` (`bottom_id` ASC) VISIBLE,
  PRIMARY KEY (`order_number`, `topping_id`, `bottom_id`),
  CONSTRAINT `ordered_cupcakes_ibfk_1`
    FOREIGN KEY (`order_number`)
    REFERENCES `cupcakedb`.`orders` (`order_number`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ordered_cupcakes_ibfk_2`
    FOREIGN KEY (`topping_id`)
    REFERENCES `cupcakedb`.`toppings` (`topping_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ordered_cupcakes_ibfk_3`
    FOREIGN KEY (`bottom_id`)
    REFERENCES `cupcakedb`.`bottoms` (`bottom_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
