-- phpMyAdmin SQL Dump
-- version 4.0.10.18
-- https://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Oct 25, 2017 at 09:45 PM
-- Server version: 5.5.54-38.6-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `medicare_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE IF NOT EXISTS `appointment` (
  `appointment_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) DEFAULT NULL,
  `referred_by_doctor_id` int(11) DEFAULT NULL,
  `service_type_id` int(11) DEFAULT NULL,
  `created_by_user_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `is_modified` tinyint(1) DEFAULT '0',
  `is_cancled` tinyint(1) DEFAULT '0',
  `token` int(11) DEFAULT '1',
  `date_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_date_time` timestamp NULL DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `slot` int(11) DEFAULT '1',
  PRIMARY KEY (`appointment_id`),
  KEY `fk_patient_id` (`patient_id`),
  KEY `fk_referred_by_doctor_id` (`referred_by_doctor_id`),
  KEY `fk_service_type_id` (`service_type_id`),
  KEY `fk_created_by_user_id` (`created_by_user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`appointment_id`, `patient_id`, `referred_by_doctor_id`, `service_type_id`, `created_by_user_id`, `is_deleted`, `is_modified`, `is_cancled`, `token`, `date_time`, `modified_date_time`, `status`, `slot`) VALUES
(1, 1, 1, 1, 2, 0, 0, 0, 123456, '2017-05-25 14:56:59', '2017-05-25 14:56:59', '1', 1),
(2, 1, 1, 2, 2, 0, 0, 0, 123434, '2017-05-25 14:56:59', '2017-05-25 14:56:59', '1', 1),
(3, 2, 2, 1, 2, 0, 0, 0, 123578, '2017-05-25 14:56:59', '2017-05-25 14:56:59', '1', 2),
(4, 3, 4, 4, 2, 0, 0, 0, 234555, '2017-05-25 14:56:59', '2017-05-25 14:56:59', '1', 2),
(5, 4, 3, 2, 2, 0, 0, 0, 234344, '2017-05-25 14:56:59', '2017-05-25 14:56:59', '1', 3),
(6, 5, 5, 1, 2, 0, 0, 0, 123456, '2017-05-25 14:56:59', '2017-05-25 14:56:59', '1', 1),
(7, 5, 5, 8, 2, 0, 0, 0, 123434, '2017-05-25 14:56:59', '2017-05-25 14:56:59', '1', 1),
(8, 6, 6, 7, 2, 0, 0, 0, 123578, '2017-05-25 14:56:59', '2017-05-25 14:56:59', '1', 4),
(9, 7, 7, 10, 2, 0, 0, 0, 234555, '2017-05-25 14:56:59', '2017-05-25 14:56:59', '1', 4),
(10, 7, 8, 9, 2, 0, 0, 0, 234344, '2017-05-25 14:56:59', '2017-05-25 14:56:59', '1', 3);

-- --------------------------------------------------------

--
-- Table structure for table `appointment_services`
--

CREATE TABLE IF NOT EXISTS `appointment_services` (
  `appointment_id` int(11) NOT NULL,
  `service_type_id` int(11) NOT NULL,
  PRIMARY KEY (`appointment_id`,`service_type_id`),
  KEY `FK_con_app_ser2` (`service_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `appointment_services`
--

INSERT INTO `appointment_services` (`appointment_id`, `service_type_id`) VALUES
(1, 1),
(3, 1),
(2, 2),
(5, 2),
(4, 4),
(6, 6),
(6, 7),
(10, 7),
(7, 8),
(8, 9),
(9, 10);

-- --------------------------------------------------------

--
-- Table structure for table `commission`
--

CREATE TABLE IF NOT EXISTS `commission` (
  `commission_id` int(11) NOT NULL AUTO_INCREMENT,
  `total_commission` bigint(11) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`commission_id`),
  KEY `fk_doctor_id` (`doctor_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `commission`
--

INSERT INTO `commission` (`commission_id`, `total_commission`, `status`, `doctor_id`) VALUES
(1, 300, '1', 5),
(2, 400, '1', 6),
(3, 500, '1', 7),
(4, 600, '1', 8),
(5, 300, '1', 1),
(6, 500, '1', 2),
(7, 600, '1', 3),
(8, 600, '1', 4);

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE IF NOT EXISTS `doctor` (
  `doctor_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `contact_no` bigint(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `hospital_name` varchar(20) DEFAULT NULL,
  `qualification` varchar(20) DEFAULT NULL,
  `speciality` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `commission` bigint(11) DEFAULT NULL,
  `added_by_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`doctor_id`),
  KEY `fk_added_by_user_id` (`added_by_user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`doctor_id`, `name`, `contact_no`, `email`, `hospital_name`, `qualification`, `speciality`, `address`, `is_deleted`, `commission`, `added_by_user_id`) VALUES
(1, 'Ankit ', 9876543210, 'ankit@gmail.com', 'BTM', 'MBBS`', 'Bone', 'BTM', 0, 500, 1),
(2, 'Vishal', 9876543210, 'vishal@gmail.com', 'HSR', 'MBBS', 'Neuro', 'HSR', 0, 300, 1),
(3, 'Mohit', 9876543210, 'mohit@gmail.com', 'madivala', 'MBBS', 'skin', 'Madivala', 0, 400, 1),
(4, 'Sanjay', 9876543210, 'sanjay@gmail.com', 'banashankri', 'MBBS', 'tooth', 'banshankari', 0, 600, 1),
(5, 'Ankit ', 9876543210, 'ankit@gmail.com', 'BTM', 'MBBS`', 'Bone', 'BTM', 0, 500, 1),
(6, 'Vishal', 9876543210, 'vishal@gmail.com', 'HSR', 'MBBS', 'Neuro', 'HSR', 0, 300, 1),
(7, 'Mohit', 9876543210, 'mohit@gmail.com', 'madivala', 'MBBS', 'skin', 'Madivala', 0, 400, 1),
(8, 'Sanjay', 9876543210, 'sanjay@gmail.com', 'banashankri', 'MBBS', 'tooth', 'banshankari', 0, 600, 1);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE IF NOT EXISTS `invoice` (
  `invoice_id` int(11) NOT NULL AUTO_INCREMENT,
  `appointment_id` int(11) DEFAULT NULL,
  `total_invoice` int(11) DEFAULT NULL,
  `created_date_time` datetime DEFAULT NULL,
  `modified_date_time` datetime DEFAULT NULL,
  `created_by_user_id` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`invoice_id`),
  KEY `fk_inv_created_by_user_id` (`created_by_user_id`),
  KEY `fk_inv_appointment_id` (`appointment_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoice_id`, `appointment_id`, `total_invoice`, `created_date_time`, `modified_date_time`, `created_by_user_id`, `status`) VALUES
(1, 1, 5500, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 2, '1'),
(2, 2, 11000, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 2, '1'),
(3, 3, 5500, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 2, '1'),
(4, 4, 8750, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 2, '1'),
(5, 5, 11000, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 2, '1'),
(6, 6, 5500, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 2, '1'),
(7, 7, 11000, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 2, '1'),
(8, 8, 5500, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 2, '1'),
(9, 9, 8750, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 2, '1'),
(10, 10, 11000, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 2, '1');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `contact_number` bigint(10) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patient_id`, `first_name`, `last_name`, `age`, `address`, `email`, `contact_number`, `gender`) VALUES
(1, 'rani', 'mukari', 44, 'Mumbai', 'rani@gmail.com', 9876543210, 'F'),
(2, 'mahesh', 'batt', 44, 'Mumbai', 'mahes@gmail.com', 9876543210, 'M'),
(3, 'Akil', 'Bharti', 40, 'Mumbai', 'akhil@gmail.com', 9876543210, 'F'),
(4, 'Amit', 'Sharma', 55, 'Mumbai', 'amit@gmail.com', 9742085972, 'M'),
(5, 'mahesh', 'batt', 44, 'Mumbai', 'mahes@gmail.com', 9876543210, 'M'),
(6, 'Akil', 'Bharti', 40, 'Mumbai', 'akhil@gmail.com', 9876543210, 'F'),
(7, 'Amit', 'Sharma', 55, 'Mumbai', 'amit@gmail.com', 9742085972, 'M');

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE IF NOT EXISTS `report` (
  `report_id` int(11) NOT NULL AUTO_INCREMENT,
  `report_type` varchar(20) DEFAULT NULL,
  `report_created_date_time` datetime DEFAULT NULL,
  `generated_by_user_id` int(11) DEFAULT NULL,
  `total_appointment` int(11) DEFAULT NULL,
  `total_services` int(11) DEFAULT NULL,
  `total_doctors` int(11) DEFAULT NULL,
  `total_patient` int(11) DEFAULT NULL,
  `total_commission` int(11) DEFAULT NULL,
  `total_service_charge` int(11) DEFAULT NULL,
  `total_users` int(11) DEFAULT NULL,
  `total_canceled_appointment` int(11) DEFAULT NULL,
  PRIMARY KEY (`report_id`),
  KEY `fk_report_generated_by_user_id` (`generated_by_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'SUPERADMIN'),
(2, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `service_type`
--

CREATE TABLE IF NOT EXISTS `service_type` (
  `service_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_type` varchar(255) NOT NULL,
  `price` double DEFAULT NULL,
  `created_date_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_date_time` timestamp NULL DEFAULT NULL,
  `created_by_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`service_type_id`),
  KEY `fk_created_by_user_id` (`created_by_user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `service_type`
--

INSERT INTO `service_type` (`service_type_id`, `service_type`, `price`, `created_date_time`, `modified_date_time`, `created_by_user_id`) VALUES
(1, 'X-ray', 5000, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 1),
(2, 'CT-Scan', 10000, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 1),
(3, 'Blood-Test', 7000, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 1),
(4, 'Urine test', 8000, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 1),
(6, 'X-ray bone', 5000, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 1),
(7, 'CT-Scan body', 10000, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 1),
(8, 'Blood-Test body', 7000, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 1),
(9, 'Abc test ', 8000, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 1),
(10, 'RCT Teeth', 5000, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` char(1) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `active`, `email`, `last_name`, `name`, `password`) VALUES
(1, '1', 'superadmin@gmail.com', 'Saini', 'Ankit', '$2a$10$0odvGBBbpN8zbdpO0d.g0egviheDG5rnV0GYIVuyCbTz2HkBVTEGe'),
(2, '1', 'admin@gmail.com', 'aryan', 'Vishal', '$2a$10$fGF/DXGywLay7KyLbXxPkOxO27YPT/exidSBSy18263H5vPpMjx52');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user_type`
--

CREATE TABLE IF NOT EXISTS `user_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `fk_created_by_user_id` FOREIGN KEY (`created_by_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_patient_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_referred_by_doctor_id` FOREIGN KEY (`referred_by_doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_service_type_id` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`service_type_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `appointment_services`
--
ALTER TABLE `appointment_services`
  ADD CONSTRAINT `FK_con_app_ser1` FOREIGN KEY (`appointment_id`) REFERENCES `appointment` (`appointment_id`),
  ADD CONSTRAINT `FK_con_app_ser2` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`service_type_id`);

--
-- Constraints for table `commission`
--
ALTER TABLE `commission`
  ADD CONSTRAINT `fk_doctor_id` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`);

--
-- Constraints for table `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `added_by_user_id` FOREIGN KEY (`added_by_user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `fk_inv_appointment_id` FOREIGN KEY (`appointment_id`) REFERENCES `appointment` (`appointment_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_inv_created_by_user_id` FOREIGN KEY (`created_by_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `report`
--
ALTER TABLE `report`
  ADD CONSTRAINT `fk_report_generated_by_user_id` FOREIGN KEY (`generated_by_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `service_type`
--
ALTER TABLE `service_type`
  ADD CONSTRAINT `created_by_user_id` FOREIGN KEY (`created_by_user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
