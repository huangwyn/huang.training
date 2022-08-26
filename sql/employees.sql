CREATE TABLE IF NOT EXISTS `employees` (
`employee_id`          int(11)       NOT NULL AUTO_INCREMENT 	COMMENT 'The employee id',
`department_id`        int(11)       NOT NULL                	COMMENT 'department key', 
`employee_name`                 varchar(100)  NOT NULL                	COMMENT 'The name of the employee',
PRIMARY KEY (`employee_id`),
FOREIGN KEY (department_id) REFERENCES departments(department_id)
);