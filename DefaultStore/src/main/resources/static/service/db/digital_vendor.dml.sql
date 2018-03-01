
use digital_vendor_db;

INSERT INTO `role` (`role_id`, `role`, `is_deleted`) VALUES
(1, 'ADMIN', 0);

INSERT INTO `role` (`role_id`, `role`, `is_deleted`) VALUES
(2, 'VENDOR', 0);

INSERT INTO `user` (`user_id`, `active`, `is_deleted`, `email`, `last_name`, `name`, `password`) VALUES
(1, 1, 0, 'digital@gmail.com', 'Aryan', 'Vishal', '$2a$10$j7wqSscsLrPTVEffNhSBt.Dm6.U2R8tUX/unPpoKb9ICUnqe1OW9m');

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1);



