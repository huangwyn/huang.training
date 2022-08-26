CREATE TABLE IF NOT EXISTS `employees` (
`employee_id`          int(11)       NOT NULL AUTO_INCREMENT 	COMMENT 'The organization id',
`department_id`        int(11)       NOT NULL                	COMMENT 'Position key', 
`name`                 varchar(100)  NOT NULL                	COMMENT 'The name of the Experience',
PRIMARY KEY (`employee_id`),
FOREIGN KEY (department_id) REFERENCES departments(department_id)
);