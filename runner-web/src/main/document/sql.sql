CREATE SCHEMA IF NOT EXISTS `runner` DEFAULT CHARACTER SET utf8 ;

DROP TABLE IF EXISTS `runner`.`sys_customer`;
CREATE TABLE `runner`.`sys_customer` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `code` VARCHAR(45) NULL COMMENT '',
  `name` VARCHAR(255) NULL COMMENT '',
  `create_date` TIMESTAMP NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `SYS_CUSTOMER_IDX_CODE` (`code` ASC)  COMMENT '');

DROP TABLE IF EXISTS `runner`.`sys_user`;
CREATE TABLE `runner`.`sys_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `username` VARCHAR(45) NULL COMMENT '',
  `password` VARCHAR(100) NULL COMMENT '',
  `salt` VARCHAR(20) NULL COMMENT '',
  `name` VARCHAR(255) NULL COMMENT '',
  `status` INT NULL DEFAULT 0 COMMENT '',
  `version` BIGINT(20) NULL DEFAULT 0 COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `SYS_USER_IDX_USERNAME` (`username` ASC)  COMMENT '');

ALTER TABLE `runner`.`sys_user` 
ADD COLUMN `cust_code` VARCHAR(45) NULL COMMENT '' AFTER `salt`;

ALTER TABLE `runner`.`sys_user` 
ADD INDEX `FK_SYS_USER_CUST_idx` (`cust_code` ASC)  COMMENT '';
ALTER TABLE `runner`.`sys_user` 
ADD CONSTRAINT `FK_SYS_USER_CUST`
  FOREIGN KEY (`cust_code`)
  REFERENCES `runner`.`sys_customer` (`code`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `runner`.`sys_user` 
ADD COLUMN `register_date` TIMESTAMP NULL COMMENT '' AFTER `status`;

ALTER TABLE `runner`.`sys_user` 
ADD UNIQUE INDEX `SYS_USER_UN_USERNAME` (`username` ASC)  COMMENT '';
