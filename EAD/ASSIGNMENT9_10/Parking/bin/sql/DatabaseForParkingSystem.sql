
drop database parking;

create database parking;

use parking;

create table employee(
employee_id int auto_increment,
full_name varchar(50),
gender varchar(10) check (gender in('male','female','other')),
email varchar(100) unique,
password varchar(50),
contact_number bigint,
org varchar(50),
primary key(employee_id)
);

create table vehicle(
vehicle_id int auto_increment,
name varchar(50),
type varchar(50) check (type in('cycle','motorcycle','fourwheeler')),
vehicle_number int,
employee_id int,
identification varchar(200),
primary key(vehicle_id),
foreign key(employee_id) references employee(employee_id)
);

alter table vehicle
add index type_index(type);

create table pass(
type varchar(50),
daily decimal(10,2),
monthly decimal(10,2),
yearly decimal(10,2)
);

create table image(
imageURL varchar(100),
email varchar(100),
foreign key(email) references employee(email)
);


Insert into pass values('cycle', 0.070, 1.39, 6.97),
('motorcycle', 0.14, 2.79, 13.95),
('fourwheeler', 0.28, 6.97, 48.81);

select * from employee;
select * from vehicle;
