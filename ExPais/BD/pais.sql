CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Pais` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `populacao` BIGINT NOT NULL,
  `area` DECIMAL(15,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

USE MYDB;
INSERT INTO `pais` (`nome`,`populacao`,`area`) VALUES ('Alemanha','82521700','357051');
INSERT INTO `pais` (`nome`,`populacao`,`area`) VALUES ('Brasil','207660929','8515767049');
INSERT INTO `pais` (`nome`,`populacao`,`area`) VALUES ('Italia','60802085','301338');
INSERT INTO `pais` (`nome`,`populacao`,`area`) VALUES ('Espanha','46524943','504030');
INSERT INTO `pais` (`nome`,`populacao`,`area`) VALUES ('Inglaterra','53012456','130395');
INSERT INTO `pais` (`nome`,`populacao`,`area`) VALUES ('Dinamarca','5627235','43094');
INSERT INTO `pais` (`nome`,`populacao`,`area`) VALUES ('Chile','17248450','756950');
INSERT INTO `pais` (`nome`,`populacao`,`area`) VALUES ('Colombia','48747632','1138914');
INSERT INTO `pais` (`nome`,`populacao`,`area`) VALUES ('Peru','33208710','1285220');
INSERT INTO `pais` (`nome`,`populacao`,`area`) VALUES ('Argentina','43590368','2780400');

SELECT * FROM pais;

