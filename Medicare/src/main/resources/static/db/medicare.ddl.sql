
DROP SCHEMA IF EXISTS `medicare_db`;

create database medicare_db;

use medicare_db;

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` char(1) DEFAULT NULL,
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

DROP TABLE IF EXISTS `service_type`;

CREATE TABLE service_type (
  service_type_id Int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  service_type varchar(255) NOT NULL,
  price double,
  created_date_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  modified_date_time DATETIME DEFAULT CURRENT_TIMESTAMP, 
  created_by_user_id INTEGER
);

DROP TABLE IF EXISTS `doctor`;

CREATE TABLE doctor (
		doctor_id INTEGER(11) NOT NULL AUTO_INCREMENT,
		name VARCHAR(20),
		contact_no BIGINT(11),
		email VARCHAR(20),
		hospital_name VARCHAR(20),
		qualification VARCHAR(20),
		speciality VARCHAR(20),
		address VARCHAR(20),
		is_deleted boolean default 0,
		commission BIGINT(11),
		added_by_user_id INTEGER,
		PRIMARY KEY ( doctor_id )
);

DROP TABLE IF EXISTS `commission`;

CREATE TABLE commission 
		(commission_id INTEGER(11) NOT NULL AUTO_INCREMENT,
		total_commission BIGINT(11),
		status CHAR(1) DEFAULT NULL,
		doctor_id INTEGER,
		PRIMARY KEY ( commission_id )
);

DROP TABLE IF EXISTS `patient`;

CREATE TABLE patient (
		  patient_id INTEGER NOT NULL AUTO_INCREMENT, 
          first_name VARCHAR(20),
          last_name VARCHAR(20),
          age int,           
          address VARCHAR(20),  
          email VARCHAR(20),  
          contact_number BIGINT(10), 
          gender CHAR(1), 
		PRIMARY KEY ( patient_id )
);

DROP TABLE IF EXISTS `appointment`;

CREATE TABLE appointment (
          appointment_id INTEGER NOT NULL AUTO_INCREMENT,          
          patient_id INTEGER,          
          referred_by_doctor_id VARCHAR(20), 
          service_type_id VARCHAR(20), 
          created_by_user_id INTEGER,
          is_deleted boolean default 0, 
          is_modified boolean default 0, 
          is_cancled boolean default 0, 
          token INTEGER default 1, 
          date_time DATETIME DEFAULT CURRENT_TIMESTAMP,
          modified_date_time DATETIME DEFAULT CURRENT_TIMESTAMP,        
          status VARCHAR(20),
          slot INTEGER default 1,          
          PRIMARY KEY ( appointment_id )
);


DROP TABLE IF EXISTS `invoice`;

CREATE TABLE invoice (
		invoice_id INTEGER(11) NOT NULL AUTO_INCREMENT,
		apointment_id INTEGER(11) ,
		total_invoice INT(11),
		created_date_time DATETIME,
	    modified_date_time DATETIME, 
		created_by_user_id INTEGER,
		status VARCHAR(20),
		PRIMARY KEY ( invoice_id )
);

DROP TABLE IF EXISTS `report`;

CREATE TABLE report (
        report_id INTEGER(11) NOT NULL AUTO_INCREMENT,
		report_type VARCHAR(20),
		report_created_date_time DATETIME,
		generated_by_user_id INTEGER,
		total_appointment INTEGER,
		total_services INTEGER,
		total_doctors INTEGER,
		total_patient INTEGER,
		total_commission INTEGER,
		total_service_charge INTEGER,
		total_users INTEGER,
		total_canceled_appointment INTEGER,
		PRIMARY KEY ( report_id )
);

