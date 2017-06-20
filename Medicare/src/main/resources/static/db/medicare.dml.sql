use medicare_db;

INSERT INTO `role` VALUES (1,'SUPERADMIN');
INSERT INTO `role` VALUES (2,'ADMIN');

INSERT INTO `medicare_db`.`service_type` (`service_type`, `price`, `created_by_user_id`) VALUES ('ECG', '5000', '1');

INSERT INTO `medicare_db`.`doctor` (`name`, `contact_no`, `email`, `hospital_name`, `qualification`, `speciality`, `address`, `commission`, `added_by_user_id`) VALUES ('Vishal', '9742503868', 'test@gmail.com', 'HSR', 'MBBS', 'Brain', 'HSR', '50000', '1');

INSERT INTO `medicare_db`.`appointment` (`patient_id`, `referred_by_doctor_id`, `service_type_id`, `created_by_user_id`, `slot`) VALUES ('1', '1', '1', '1', '1');

INSERT INTO `medicare_db`.`patient` (`first_name`, `last_name`, `age`, `address`, `email`, `contact_number`, `gender`) VALUES ('Chita', 'Ranjan', '30', 'SMNagar', 'abc@gnamil', '7476476', 'M');


