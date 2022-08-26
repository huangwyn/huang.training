CREATE TABLE IF NOT EXISTS `departments` (
`department_id`        int(11)       NOT NULL   AUTO_INCREMENT  COMMENT 'department key', 
`dept_name`                 varchar(100)  NOT NULL                	COMMENT 'The name of the department',
PRIMARY KEY (`department_id`)
);