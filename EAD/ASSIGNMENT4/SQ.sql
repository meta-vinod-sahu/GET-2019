create database employee;
use employee;

create table add_employee(
  id int primary key auto_increment,
  employee_name varchar(40),
  employee_password varchar(40),
  employee_emailid varchar(40) UNIQUE,
  employee_contact varchar(30),
  organization_type varchar(40),
  employee_gender varchar(10)
);
describe add_employee;

drop table add_employee;

select * from add_employee;