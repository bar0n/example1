SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
CREATE SCHEMA IF NOT EXISTS `exercice1` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;
USE `exercice1` ;

-- -----------------------------------------------------
-- Table `exercice1`.`clients`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `exercice1`.`clients` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT ,
  `LAST_NAME` VARCHAR(30) CHARACTER SET 'utf8' NOT NULL ,
  `FIRST_NAME` VARCHAR(30) CHARACTER SET 'utf8' NOT NULL ,
  `PHOTO_PATH` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_icelandic_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_icelandic_ci;


-- -----------------------------------------------------
-- Table `exercice1`.`client_details`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `exercice1`.`client_details` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT ,
  `CLIENT_ID` INT(11) NOT NULL ,
  `TEL_TYPE` VARCHAR(20) NOT NULL ,
  `TEL_NUMBER` VARCHAR(20) NOT NULL ,
  `UR_ADDRESS` VARCHAR(20) NOT NULL ,
  `FIZ_ADDRESS` VARCHAR(20) NOT NULL ,
  `EMAIL` VARCHAR(20) NOT NULL ,
  `CITY` VARCHAR(20) NOT NULL ,
  `INN` VARCHAR(20) NOT NULL ,
  `EDRPO` VARCHAR(20) NOT NULL ,
  `COMMENTS` VARCHAR(200) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_CONTACT_DETAIL_1` (`CLIENT_ID` ASC) ,
  CONSTRAINT `FK_CONTACT_DETAIL_1`
    FOREIGN KEY (`CLIENT_ID` )
    REFERENCES `exercice1`.`clients` (`ID` ))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `exercice1`.`clients_debt`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `exercice1`.`clients_debt` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `client_id` INT(11) NOT NULL ,
  `debt` DECIMAL(10,2) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `id_idx` (`client_id` ASC) ,
  CONSTRAINT `id_clientID`
    FOREIGN KEY (`client_id` )
    REFERENCES `exercice1`.`clients` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `exercice1`.`wordtemplate`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `exercice1`.`wordtemplate` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
