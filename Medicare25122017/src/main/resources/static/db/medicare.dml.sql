use medicare_db;

INSERT INTO `medicare_db`.`doctor` (`doctor_id`, `name`, `contact_no`, `email`, `hospital_name`, `qualification`, `speciality`, `address`, `is_deleted`, `commission`, `added_by_user_id`) VALUES ('1', 'Ankit ', '9876543210', 'ankit@gmail.com', 'BTM', 'MBBS`', 'Bone', 'BTM', '0', '500', '1');
INSERT INTO `medicare_db`.`doctor` (`doctor_id`, `name`, `contact_no`, `email`, `hospital_name`, `qualification`, `speciality`, `address`, `is_deleted`, `commission`, `added_by_user_id`) VALUES ('2', 'Vishal', '9876543210', 'vishal@gmail.com', 'HSR', 'MBBS', 'Neuro', 'HSR', '0', '300', '1');
INSERT INTO `medicare_db`.`doctor` (`doctor_id`, `name`, `contact_no`, `email`, `hospital_name`, `qualification`, `speciality`, `address`, `is_deleted`, `commission`, `added_by_user_id`) VALUES ('3', 'Mohit', '9876543210', 'mohit@gmail.com', 'madivala', 'MBBS', 'skin', 'Madivala', '0', '400', '1');
INSERT INTO `medicare_db`.`doctor` (`doctor_id`, `name`, `contact_no`, `email`, `hospital_name`, `qualification`, `speciality`, `address`, `is_deleted`, `commission`, `added_by_user_id`) VALUES ('4', 'Sanjay', '9876543210', 'sanjay@gmail.com', 'banashankri', 'MBBS', 'tooth', 'banshankari', '0', '600', '1');

INSERT INTO `medicare_db`.`patient` (`patient_id`, `first_name`, `last_name`, `age`, `address`, `email`, `contact_number`, `gender`) VALUES ('1', 'rani', 'mukari', '44', 'Mumbai', 'rani@gmail.com', '9876543210', 'F');
INSERT INTO `medicare_db`.`patient` (`patient_id`, `first_name`, `last_name`, `age`, `address`, `email`, `contact_number`, `gender`) VALUES ('2', 'mahesh', 'batt', '44', 'Mumbai', 'mahes@gmail.com', '9876543210', 'M');
INSERT INTO `medicare_db`.`patient` (`patient_id`, `first_name`, `last_name`, `age`, `address`, `email`, `contact_number`, `gender`) VALUES ('3', 'Akil', 'Bharti', '40', 'Mumbai', 'akhil@gmail.com', '9876543210', 'F');
INSERT INTO `medicare_db`.`patient` (`patient_id`, `first_name`, `last_name`, `age`, `address`, `email`, `contact_number`, `gender`) VALUES ('4', 'Amit', 'Sharma', '55', 'Mumbai', 'amit@gmail.com', '9742085972', 'M');

INSERT INTO `medicare_db`.`service_type` (`service_type_id`, `service_type`, `price`, `created_date_time`, `modified_date_time`, `created_by_user_id`) VALUES ('1', 'X-ray', '5000', '2017-05-22 14:56:59', '2017-05-23 14:56:59', '1');
INSERT INTO `medicare_db`.`service_type` (`service_type_id`, `service_type`, `price`, `created_date_time`, `modified_date_time`, `created_by_user_id`) VALUES ('2', 'CT-Scan', '10000', '2017-05-22 14:56:59', '2017-05-23 14:56:59', '1');
INSERT INTO `medicare_db`.`service_type` (`service_type_id`, `service_type`, `price`, `created_date_time`, `modified_date_time`, `created_by_user_id`) VALUES ('3', 'Blood-Test', '7000', '2017-05-22 14:56:59', '2017-05-23 14:56:59', '1');
INSERT INTO `medicare_db`.`service_type` (`service_type_id`, `service_type`, `price`, `created_date_time`, `modified_date_time`, `created_by_user_id`) VALUES ('4', 'Urine test', '8000', '2017-05-22 14:56:59', '2017-05-23 14:56:59', '1');

INSERT INTO `medicare_db`.`appointment` (`appointment_id`, `patient_id`, `referred_by_doctor_id`, `service_type_id`, `created_by_user_id`, `is_deleted`, `is_modified`, `is_cancled`, `token`, `date_time`, `modified_date_time`, `status`, `slot`) VALUES ('1', '1', '1', '1', '2', '0', '0', '0', '123456', '2017-05-25 14:56:59', '2017-05-25 14:56:59', '1', '1');
INSERT INTO `medicare_db`.`appointment` (`appointment_id`, `patient_id`, `referred_by_doctor_id`, `service_type_id`, `created_by_user_id`, `is_deleted`, `is_modified`, `is_cancled`, `token`, `date_time`, `modified_date_time`, `status`, `slot`) VALUES ('2', '1', '1', '2', '2', '0', '0', '0', '123434', '2017-05-25 14:56:59', '2017-05-25 14:56:59', '1', '1');
INSERT INTO `medicare_db`.`appointment` (`appointment_id`, `patient_id`, `referred_by_doctor_id`, `service_type_id`, `created_by_user_id`, `is_deleted`, `is_modified`, `is_cancled`, `token`, `date_time`, `modified_date_time`, `status`, `slot`) VALUES ('3', '2', '2', '1', '2', '0', '0', '0', '123578', '2017-05-25 14:56:59', '2017-05-25 14:56:59', '1', '2');
INSERT INTO `medicare_db`.`appointment` (`appointment_id`, `patient_id`, `referred_by_doctor_id`, `service_type_id`, `created_by_user_id`, `is_deleted`, `is_modified`, `is_cancled`, `token`, `date_time`, `modified_date_time`, `status`, `slot`) VALUES ('4', '3', '4', '4', '2', '0', '0', '0', '234555', '2017-05-25 14:56:59', '2017-05-25 14:56:59', '1', '2');
INSERT INTO `medicare_db`.`appointment` (`appointment_id`, `patient_id`, `referred_by_doctor_id`, `service_type_id`, `created_by_user_id`, `is_deleted`, `is_modified`, `is_cancled`, `token`, `date_time`, `modified_date_time`, `status`, `slot`) VALUES ('5', '4', '3', '2', '2', '0', '0', '0', '234344', '2017-05-25 14:56:59', '2017-05-25 14:56:59', '1', '3');

INSERT INTO `medicare_db`.`invoice` (`invoice_id`, `appointment_id`, `total_invoice`, `created_date_time`, `modified_date_time`, `created_by_user_id`, `status`) VALUES ('1', '1', '5500', '2017-05-22 14:56:59', '2017-05-23 14:56:59', '2', '1');
INSERT INTO `medicare_db`.`invoice` (`invoice_id`, `appointment_id`, `total_invoice`, `created_date_time`, `modified_date_time`, `created_by_user_id`, `status`) VALUES ('2', '2', '11000', '2017-05-22 14:56:59', '2017-05-23 14:56:59', '2', '1');
INSERT INTO `medicare_db`.`invoice` (`invoice_id`, `appointment_id`, `total_invoice`, `created_date_time`, `modified_date_time`, `created_by_user_id`, `status`) VALUES ('3', '3', '5500', '2017-05-22 14:56:59', '2017-05-23 14:56:59', '2', '1');
INSERT INTO `medicare_db`.`invoice` (`invoice_id`, `appointment_id`, `total_invoice`, `created_date_time`, `modified_date_time`, `created_by_user_id`, `status`) VALUES ('4', '4', '8750', '2017-05-22 14:56:59', '2017-05-23 14:56:59', '2', '1');
INSERT INTO `medicare_db`.`invoice` (`invoice_id`, `appointment_id`, `total_invoice`, `created_date_time`, `modified_date_time`, `created_by_user_id`, `status`) VALUES ('5', '5', '11000', '2017-05-22 14:56:59', '2017-05-23 14:56:59', '2', '1');
