
create database medicare;

use medicare;

CREATE TABLE appointment (
          id INTEGER NOT NULL AUTO_INCREMENT, 
          age int,  
          name VARCHAR(20), 
          address VARCHAR(20), 
          contact_no BIGINT(10), 
          commision VARCHAR(20), 
          gender CHAR(1), 
          ref_doc VARCHAR(20), 
          service_type VARCHAR(20), 
          is_deleted boolean default 0, 
          is_modified boolean default 0, 
          is_cancled boolean default 0, 
          token BIGINT, 
          booking_date_time DATETIME, 
          PRIMARY KEY ( id )
);


INSERT INTO `medicare`.`appointment` (`id`, `age`, `name`, `address`, `contact_no`, `commision`, `gender`, `ref_doc`, `service_type`, `is_deleted`, `is_modified`, `is_cancled`, `booking_date_time`) VALUES ('1', '25', 'Ankit Saini', 'btm ', '9742085972', '100', 'M', 'Dr. Vishal', 'x-ray', '0', '0', '0', '2017-05-27 14:56:59');
INSERT INTO `medicare`.`appointment` (`id`, `age`, `name`, `address`, `contact_no`, `commision`, `gender`, `ref_doc`, `service_type`, `is_deleted`, `is_modified`, `is_cancled`, `booking_date_time`) VALUES ('2', '22', 'harry Potter', 'btm x ', '9742086574', '100', 'M', 'Dr. Vishal', 'x-ray', '0', '0', '0', '2017-05-22 14:56:59');
INSERT INTO `medicare`.`appointment` (`id`, `age`, `name`, `address`, `contact_no`, `commision`, `gender`, `ref_doc`, `service_type`, `is_deleted`, `is_modified`, `is_cancled`, `booking_date_time`) VALUES ('3', '26', 'edward sen', 'btm y', '9742083546', '100', 'M', 'Dr. Vishal', 'x-ray', '0', '0', '0', '2017-05-21 14:56:59');
INSERT INTO `medicare`.`appointment` (`id`, `age`, `name`, `address`, `contact_no`, `commision`, `gender`, `ref_doc`, `service_type`, `is_deleted`, `is_modified`, `is_cancled`, `booking_date_time`) VALUES ('4', '21', 'Sand Man ', 'btm z', '9742083645', '100', 'M', 'Dr. Vishal', 'x-ray', '0', '0', '0', '2017-05-26 14:56:59');
INSERT INTO `medicare`.`appointment` (`id`, `age`, `name`, `address`, `contact_no`, `commision`, `gender`, `ref_doc`, `service_type`, `is_deleted`, `is_modified`, `is_cancled`, `booking_date_time`) VALUES ('5', '23', 'dawyne Johnson', 'btm v', '9742086785', '100', 'M', 'Dr. Vishal', 'x-ray', '0', '0', '0', '2017-05-25 14:56:59');

UPDATE `medicare`.`appointment` SET `token`='4434314' WHERE `id`='1';
UPDATE `medicare`.`appointment` SET `token`='34324342' WHERE `id`='2';
UPDATE `medicare`.`appointment` SET `token`='234324' WHERE `id`='3';
UPDATE `medicare`.`appointment` SET `token`='4234242' WHERE `id`='4';
UPDATE `medicare`.`appointment` SET `token`='234234234' WHERE `id`='5';


CREATE TABLE service_type (
	id Int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar(255) NOT NULL,
	price double
);

INSERT INTO `service_type` (`id`, `name`, `price`) VALUES
(1, 'ram', 20),
(2, 'shyam', 30);


CREATE TABLE invoice (id INTEGER(11) NOT NULL AUTO_INCREMENT,  apointment_id INTEGER(11) , total_bill INT(11), date_bill DATETIME,  generated_by_user INTEGER, status VARCHAR(20),  PRIMARY KEY ( id ));

CREATE TABLE doctor (id INTEGER(11) NOT NULL AUTO_INCREMENT,  name VARCHAR(20), contact_no BIGINT(11), email VARCHAR(20), hospital_name VARCHAR(20), qualification VARCHAR(20), speciality VARCHAR(20), address VARCHAR(20),is_deleted boolean default 0, commision BIGINT(11),  PRIMARY KEY ( id ));

CREATE TABLE patient (id INTEGER(11) NOT NULL AUTO_INCREMENT,  name VARCHAR(20), age int, gender CHAR(1), contact_no BIGINT(11), email VARCHAR(20),  address VARCHAR(20), f_name VARCHAR(20), m_name VARCHAR(20), alt_contact_no BIGINT(11), appointment_id INTEGER(11),  PRIMARY KEY ( id ));

  
INSERT INTO `medicare`.`invoice` (`id`, `apointment_id`, `total_bill`, `date_bill`, `generated_by_user`, `status`) VALUES ('1', '2', '1100', '2017-05-21 14:56:59', '1', 'paid');
INSERT INTO `medicare`.`invoice` (`id`, `apointment_id`, `total_bill`, `date_bill`, `generated_by_user`, `status`) VALUES ('2', '3', '1150', '2017-05-24 14:56:59', '1', 'paid');
    
	
INSERT INTO `medicare`.`doctor` (`id`, `name`, `contact_no`, `email`, `hospital_name`, `qualification`, `speciality`, `address`, `is_deleted`,`commision`) VALUES ('1', 'Ankit Saini', '9742085972', 'ankit@gmail.com', 'jayadeva Hospital', 'MBBS','x-ray','btm 2 Stage','0','1000');
INSERT INTO `medicare`.`doctor` (`id`, `name`, `contact_no`, `email`, `hospital_name`, `qualification`, `speciality`, `address`, `is_deleted`,`commision`) VALUES ('2', 'Ankit Verma', '9742597772', 'ankitsaini@gmail.com', 'snn Hospital', 'MA','scan','btm 3 Stage','0','1500');	
	

INSERT INTO `medicare`.`patient` (`id`, `name`, `age`, `gender`, `contact_no`, `email`, `address`,  `f_name`, `m_name`, `alt_contact_no`,`appointment_id`) VALUES ('1', 'Ankit Saini', '22', 'M','974208972', 'ankit@gmail.com' ,'btm 2 Stage', 'Ankit', 'Saini', '974208972', '2');
INSERT INTO `medicare`.`patient` (`id`, `name`, `age`, `gender`,`contact_no`, `email`,`address`,  `f_name`, `m_name`, `alt_contact_no`, `appointment_id`) VALUES ('2', 'Ankit Verma', '22','M', '974208972', 'ankitsaini@gmail.com', 'btm 3 Stage', 'Ankit', 'Verma', '974208972', '3');	
	
DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8; 

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `role` VALUES (1,'SUPERADMIN');
