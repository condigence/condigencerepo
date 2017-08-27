
DROP SCHEMA IF EXISTS `condyn_db`;

create database condyn_db;

use condyn_db;

DROP TABLE IF EXISTS `condyn`;

CREATE TABLE `condyn` (
  `condyn_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
   `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`condyn_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

