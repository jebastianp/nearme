CREATE DATABASE  IF NOT EXISTS `nearmedb`;
USE `nearmedb`;
set @old_unique_checks=@@unique_checks, unique_checks=0;
set @old_foreign_key_checks=@@foreign_key_checks, foreign_key_checks=0;

create schema if not exists nearme_schema default character set utf8;

-- -----------------------------------------------------
-- Host: nearmedb.cmr5nzcs4t0i.us-west-2.rds.amazonaws.com:3306    Database: nearmedb
-- connection check : telnet  nearmedb.cmr5nzcs4t0i.us-west-2.rds.amazonaws.com 3306
-- mysql -h nearmedb.cmr5nzcs4t0i.us-west-2.rds.amazonaws.com -P 3306 -u nearmeadmin -p
-- ------------------------------------------------------
-- Server version	5.6.21-log

DROP TABLE IF EXISTS nearme_schema.category;
-- -----------------------------------------------------
-- table nearme_schema.category
-- -----------------------------------------------------
create table nearme_schema.category
(
     category_id    integer unsigned    not null auto_increment
    ,name           varchar(255) NOT NULL
    ,enabled bit(1)  null default 0
    ,created_date   timestamp           not null default '0000-00-00 00:00:00'
    ,updated_date   timestamp           not null default current_timestamp on update current_timestamp  
    ,deleted_date   timestamp           null default null
    ,primary key(category_id)
    ,index category_idx1 (created_date)
    ,index category_idx2 (name)
    ,index category_idx3 (updated_date)
)
engine=innodb;

delimiter //
drop TRIGGER IF EXISTS nearme_schema.trg_category_b100
//
create trigger nearme_schema.trg_category_b100 before insert on nearme_schema.category for each row 
begin
    set new.created_date = current_timestamp;
end;
 //
delimiter ;

--
-- Table structure for table `meta`
--
DROP TABLE IF EXISTS nearme_schema.meta;

create table nearme_schema.meta (
  meta_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  value varchar(100) DEFAULT NULL,
  PRIMARY KEY (meta_id),
  UNIQUE KEY meta_uidx1 (name)
)
engine=innodb;

-- set sql_mode=@old_sql_mode;
set foreign_key_checks=@old_foreign_key_checks;
set unique_checks=@old_unique_checks;