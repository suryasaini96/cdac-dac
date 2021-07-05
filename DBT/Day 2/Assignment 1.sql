#1
# mysql.exe -u root -p

#2
show databases;

#3
use information_schema;

#4
show tables;

#5
use mysql;

#6
# source D:\Libraries\Desktop\CDAC\Subjects\DBT\hrschema.sql
use humanresource;

#7
show tables;

#8
desc countries;
desc departments;
desc emp_details_view;
desc employees;
desc job_history;
desc jobs;
desc locations;
desc regions;

#9
select * from countries;
select * from departments;
select * from emp_details_view;
select * from employees;
select * from job_history;
select * from jobs;
select * from locations;
select * from regions;

#10
#Interacted with MySQL Workbench

#11
# System cls;

#12
select current_user();

#13
select current_date(); # Date
select current_time(); # Time
select current_timestamp(); # Date with timestamp

#14
# Shows a null field with null column
# Null means no data
select null;

#15
create table mytable(
	id int primary key,
    name varchar(30),
    email varchar(20) unique,
    dob date
);









