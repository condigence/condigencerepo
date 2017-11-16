-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: medicare_db
-- ------------------------------------------------------
-- Server version	5.7.13-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointment` (
  `appointment_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) DEFAULT NULL,
  `referred_by_doctor_id` int(11) DEFAULT NULL,
  `service_type_id` int(11) DEFAULT NULL,
  `created_by_user_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `is_modified` tinyint(1) DEFAULT '0',
  `is_cancled` tinyint(1) DEFAULT '0',
  `token` int(11) DEFAULT '1',
  `date_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  `modified_date_time` timestamp NULL DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `slot` int(11) DEFAULT '1',
  PRIMARY KEY (`appointment_id`),
  KEY `fk_patient_id` (`patient_id`),
  KEY `fk_referred_by_doctor_id` (`referred_by_doctor_id`),
  KEY `fk_service_type_id` (`service_type_id`),
  KEY `fk_created_by_user_id` (`created_by_user_id`),
  CONSTRAINT `fk_created_by_user_id` FOREIGN KEY (`created_by_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_patient_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_referred_by_doctor_id` FOREIGN KEY (`referred_by_doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_service_type_id` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`service_type_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,1,1,1,2,0,0,0,123456,'2017-05-25 14:56:59','2017-05-25 14:56:59','1',1),(2,1,1,2,2,0,0,0,123434,'2017-05-25 14:56:59','2017-05-25 14:56:59','1',1),(3,2,2,1,2,0,0,0,123578,'2017-05-25 14:56:59','2017-05-25 14:56:59','1',2),(4,3,4,4,2,0,0,0,234555,'2017-05-25 14:56:59','2017-05-25 14:56:59','1',2),(5,4,3,2,2,0,0,0,234344,'2017-05-25 14:56:59','2017-05-25 14:56:59','1',3),(6,5,5,1,2,0,0,0,123456,'2017-05-25 14:56:59','2017-05-25 14:56:59','1',1),(7,5,5,8,2,0,0,0,123434,'2017-05-25 14:56:59','2017-05-25 14:56:59','1',1),(8,6,6,7,2,0,0,0,123578,'2017-05-25 14:56:59','2017-05-25 14:56:59','1',4),(9,7,7,10,2,0,0,0,234555,'2017-05-25 14:56:59','2017-05-25 14:56:59','1',4),(10,7,8,9,2,0,0,0,234344,'2017-05-25 14:56:59','2017-05-25 14:56:59','1',3);
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-25  2:57:40
