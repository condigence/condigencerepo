
#DROP SCHEMA IF EXISTS `visharya_medicare_db`;

#create database visharya_medicare_db;

use visharya_medicare_db;

INSERT INTO `role` (`role_id`, `role`, `is_deleted`) VALUES
(1, 'SUPERADMIN', 0);

INSERT INTO `role` (`role_id`, `role`, `is_deleted`) VALUES
(2, 'ADMIN', 0);

INSERT INTO `user` (`user_id`, `active`, `is_deleted`, `email`, `last_name`, `name`, `password`) VALUES
(1, 1, 0, 'condigence@gmail.com', 'Saini', 'Ankit', '$2a$10$j7wqSscsLrPTVEffNhSBt.Dm6.U2R8tUX/unPpoKb9ICUnqe1OW9m');

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1);

INSERT INTO `service_type` (`service_type_id`, `service_type`, `price`, `is_deleted`, `created_date_time`, `modified_date_time`, `created_by_user_id`) VALUES
(1, 'X-ray', 5000, 0, '2017-05-22 14:56:59', '2017-05-23 14:56:59', 1),
(2, 'Abdomen/ Pelvis', 900, 0, NULL, NULL, 1),
(3, 'Abdomen & Pelvis with TVS', 1600, 0, NULL, NULL, 1),
(4, 'KUB ', 800, 0, NULL, NULL, 1),
(5, 'Pelvis', 800, 0, NULL, NULL, 1),
(6, 'Antenatal', 1200, 0, NULL, NULL, 1),
(7, 'Antenatal TVS', 1600, 0, NULL, NULL, 1),
(8, 'NT Scan', 1400, 0, NULL, NULL, 1),
(9, 'NT with TVS', 2400, 0, NULL, NULL, 1),
(10, 'Anomaly Scan', 1600, 0, NULL, NULL, 1),
(11, 'Anomaly with TVS', 2600, 0, NULL, NULL, 1),
(12, 'Obstetric Scan', 1200, 0, NULL, NULL, 1),
(13, 'Obstetric Doppler', 1600, 0, NULL, NULL, 1),
(14, 'HD Live', 2500, 0, NULL, NULL, 1),
(15, '3D Scan', 3000, 0, NULL, NULL, 1),
(16, '4D Scan', 4000, 0, NULL, NULL, 1),
(17, 'Follicular Study', 1600, 0, NULL, NULL, 1),
(18, 'Foetus Echo', 2000, 0, NULL, NULL, 1),
(19, 'Anomaly with Foetal Echo', 3600, 0, NULL, NULL, 1),
(20, 'TVS', 1000, 0, NULL, NULL, 1),
(21, 'Neurosonogram', 900, 0, NULL, NULL, 1),
(22, 'Chest / Thorax', 900, 0, NULL, NULL, 1),
(23, 'Thyroid', 1000, 0, NULL, NULL, 1),
(24, 'Scrotum', 1000, 0, NULL, NULL, 1),
(25, 'Scrotum Doppler', 1300, 0, NULL, NULL, 1),
(26, 'USG - Neck', 1000, 0, NULL, NULL, 1),
(27, 'Thyroid - Elastography', 1000, 0, NULL, NULL, 1),
(28, 'Thyroid - Doppler', 1300, 0, NULL, NULL, 1),
(29, 'Ocular Scan', 1000, 0, NULL, NULL, 1),
(30, 'Trus', 900, 0, NULL, NULL, 1),
(31, 'USG - Shoulder', 900, 0, NULL, NULL, 1),
(32, 'USG - Wrist', 900, 0, NULL, NULL, 1),
(33, 'USG - Ankle', 900, 0, NULL, NULL, 1),
(34, 'USG - Knee', 900, 0, NULL, NULL, 1),
(35, 'USG - Hip', 900, 0, NULL, NULL, 1),
(36, 'Hernia', 900, 0, NULL, NULL, 1),
(37, 'Power Doppler, HD-Flow', 1000, 0, NULL, NULL, 1),
(38, 'Elbow', 900, 0, NULL, NULL, 1),
(39, 'Elastography Breast', 1200, 0, NULL, NULL, 1),
(40, 'Breast', 1000, 0, NULL, NULL, 1),
(41, 'Local Parts', 900, 0, NULL, NULL, 1),
(42, 'Carotid', 1000, 0, NULL, NULL, 1),
(43, 'Single Limb (Artery)(Right/Left)', 1000, 0, NULL, NULL, 1),
(44, 'Single Limb (Vein)(Right/Left)', 1000, 0, NULL, NULL, 1),
(45, 'Both Limbs (Artery)', 2000, 0, NULL, NULL, 1),
(46, 'Both Limbs (Vein)', 2000, 0, NULL, NULL, 1),
(47, 'DVT (Both/Single Limb)(Right/Left)', 2000, 0, NULL, NULL, 1),
(48, 'Renal', 1000, 0, NULL, NULL, 1),
(49, 'Mesenteric', 1000, 0, NULL, NULL, 1),
(50, 'Hepatic', 1000, 0, NULL, NULL, 1),
(51, 'Infertility', 1200, 0, NULL, NULL, 1),
(52, 'Male Infertility', 1300, 0, NULL, NULL, 1),
(53, 'Female Infertility', 1500, 0, NULL, NULL, 1),
(54, 'MRI Scan', 10000, 0, NULL, NULL, 1),
(55, 'MRI Scan', 15000, 1, NULL, NULL, 1),
(56, 'Antenatal ..', 1000, 0, NULL, NULL, 5),
(57, 'Antenatal+TVS...', 1300, 0, NULL, NULL, 5),
(58, 'OBG...', 1000, 0, NULL, NULL, 5),
(59, 'OBG DOPPLER...', 1300, 0, NULL, NULL, 5),
(60, 'ABDOMEN/PELVIS', 500, 0, NULL, NULL, 5),
(61, 'KUB /', 500, 0, NULL, NULL, 5);



INSERT INTO `doctor` (`doctor_id`, `name`, `contact_no`, `email`, `hospital_name`, `qualification`, `speciality`, `address`, `is_deleted`, `commission`, `added_by_user_id`) VALUES
(1, 'Ankit ', 9876543210, 'ankit@gmail.com', 'BTM', 'MBBS`', 'Bone', 'BTM', 0, 500, 1),
(2, 'Dr.Sooraj', 1234567890, 'sooraj@gmail.com', 'MCH', 'DGO', 'Gyn', 'calicut', 0, 0, 1),
(3, 'Kalyan', 8088887846, 'dkalyan5@gmail.com', 'Cloud 9', 'MBBS', 'General', 'Bangalore', 0, 0, 1),
(4, 'Sujesh', 9995427896, 'sujes@gmail.com', 'bmh', 'mbbs', 'doppler', 'calicut', 0, 0, 1),
(5, 'Dr. Sooraj s', 9497570765, 'sooraj@gmail', 'MCH', 'MBBS,MD', 'Gynaecologist', 'Kakkodi', 0, 0, 1),
(6, 'Dr. Geetha devaraj', 9447075033, 'geethadevaraj@gmail.com', 'W&C', 'MBBS DGO', 'GYNAECOLAOGY', 'CALICUT', 0, 0, 1),
(7, 'Dr. RANJINI', 9847165947, 'ranjiniprasannan@gmail.com', 'ASOKA ', 'MBBS DGO', 'GYNAECOLOGY', 'CHEVAYOOR', 0, 0, 1),
(8, 'Dr.Sreena.K', 9447356260, 'ramesankc@gmail.com', 'Beach', 'MBBS DGO', 'GYNAECOLAOGY', 'calicut', 0, 0, 1),
(9, 'BINITHA SHAJEEM', 9895344187, 'binitha@gmail.com', 'IQRRA', 'MBBS DGO', 'GYNAECOLAOGY', 'CALICUT', 0, 0, 1),
(10, 'Dr.SUSHEELA', 9847092238, 'susheela@gmail.com', 'Calicut Nursing Home', 'MBBS DGO', 'GYNAECOLAOGY', 'CALICUT', 0, 0, 1),
(11, 'SheilaMadhusudhan', 9847111062, 'drmadhu@hotmail.com', 'BMH', 'MBBS DGO', 'GYNAECOLOGY', 'CALICUT', 0, 0, 1),
(12, 'SHYLAJ VRAO', 9387296290, 'shylajavrao@gma.com', 'Co.Op Hospital', 'MBBS.MD DGO', 'GYNAECOLOGY', 'THIRUVANNUR', 0, 0, 1),
(13, 'SULOCHANA', 9895664251, 'dr_sulochanakorth@gmail.com', 'Iqraa', 'MD,DGO', 'GYNAECOLOGY', 'ERANJIPALAM', 0, 0, 1),
(14, 'USHASGURUJAR', 9447424898, 'ushas@gmail.com', 'PVS', 'MBBS', 'GYNAECOLOGY', 'calicut', 0, 0, 1),
(15, 'USHA', 8281382102, 'ushap@gmail.com', 'BMH', 'MBBS DGO', 'GYNAECOLOGY', 'CALICUT', 0, 0, 1),
(16, 'Nalinimenon', 9895869063, 'menonnalini@gmail.com', 'MCH', 'MBBS DGO', 'GYNAECOLOGY', 'PALAZHI', 0, 0, 1),
(17, 'SheelaNoon', 2770062, 'sheelanoon@gmail.com', 'Rajenthra', 'MBBS DGO', 'GYNAECOLOGY', 'CALICUT', 0, 0, 1),
(18, 'ShamniShajudeen', 9562910004, 'drshamnisalam@gmail.com', 'STAR CARE', 'MBBS ,MD', 'GYNAECOLOGY', 'CALICUT', 0, 0, 1),
(19, 'Sathi John', 2770659, 'sathyjohn@gmail.com', 'Fathima', 'MBBS ,MD', 'GYNAECOLOGY', 'CALICUT', 0, 0, 1),
(20, 'SabithaNithyanandan', 9446015211, 'sabithanithyanandan@gmail.com', 'BMH', 'MBBS DGO', 'GYNAECOLOGY', 'CALICUT', 0, 0, 1),
(21, 'RUPA M GOPAL', 2352547, 'rupasunildr@rediffmail.com', 'Iqraa', 'MBBS,DGO,DNB', 'GYNAECOLOGY', 'CALICUT', 0, 0, 1),
(22, 'Rabiyabi', 9847252979, 'rabiyaazzez@yahoo.in', 'MCH', 'MBBS.MD DGO', 'GYNAECOLOGY', 'CALICUT', 0, 0, 1),
(23, 'Prabavathy', 9847252979, 'drprabavathy.c@gmail.com', 'ASOKA ', 'MBBS DGO', 'GYNAECOLOGY', 'west hill', 0, 0, 1),
(24, 'rineesha p k', 9856783457, 'riniiba@gmail.com', 'bmh', 'md ', 'gynacology', 'beypore', 0, 0, 1),
(25, 'K P MOHANAN', 9048566342, 'mohanankp@gmail.com', 'PRIVET', 'MBBS ,MD', 'PHYSICIAN', 'KAKKODY', 0, 0, 1);


