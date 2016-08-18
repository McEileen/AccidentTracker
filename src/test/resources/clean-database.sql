use accidenttracker_test;
set FOREIGN_KEY_CHECKS = 0;
truncate table cars;
truncate table persons;

INSERT INTO `accidenttracker_test`.`persons` (`name`, `age`, `gender`, `payment`) VALUES ('Bob', '17', 'M', '50.00');
INSERT INTO `accidenttracker_test`.`persons` (`name`, `age`, `gender`, `payment`) VALUES ('Jen', '20', 'M', '50.00');


INSERT INTO `accidenttracker_test`.`cars` (`make`, `model`, `year`, `person_id`) VALUES ('Toyota', 'Cor', 2017, 1);
INSERT INTO `accidenttracker_test`.`cars` (`make`, `model`, `year`, `person_id`) VALUES ('Toyota', 'High', 2016, 2);
set FOREIGN_KEY_CHECKS = 1;
