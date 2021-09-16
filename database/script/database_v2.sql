-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema paoloweb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema paoloweb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `paoloweb` ;
USE `paoloweb` ;

-- -----------------------------------------------------
-- Table `paoloweb`.`blogPost`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `paoloweb`.`blogPost` (
  `idblogPost` INT NOT NULL AUTO_INCREMENT,
  `link` VARCHAR(45) NOT NULL,
  `content` LONGBLOB NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`idblogPost`),
  UNIQUE INDEX `link_UNIQUE` (`link` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `paoloweb`.`project` (
  `idproject` INT NOT NULL AUTO_INCREMENT,
  `url_image` VARCHAR(1000) NULL,
  `title` VARCHAR(100) NOT NULL,
  `description` VARCHAR(4000) NOT NULL,
  `github` VARCHAR(100) NULL,
  `link` VARCHAR(100) NULL,
  PRIMARY KEY (`idproject`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `paoloweb`.`content`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `paoloweb`.`content` (
  `idcontent` INT NOT NULL AUTO_INCREMENT,
  `locale` VARCHAR(45) NOT NULL,
  `key` VARCHAR(100) NOT NULL,
  `value` VARCHAR(4000) NOT NULL,
  PRIMARY KEY (`idcontent`))
ENGINE = InnoDB;

GRANT ALL PRIVILEGES ON paoloweb.* TO 'paolo'@'%';

ALTER DATABASE paoloweb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

