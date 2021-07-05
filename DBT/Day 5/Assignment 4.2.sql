use humanresource;
desc employees;
#1
select first_name as 'First Name', last_name as 'Last Name'
from employees;
#2
select distinct department_id from departments;
#3
select * from employees order by first_name desc;
#4
select first_name,last_name,salary, 0.15*salary as pf from employees;
#5
select employee_id,first_name,last_name,salary from employees
order by salary;
#6
select sum(salary) from employees;
#7
select min(salary),max(salary) from employees;
#8
select avg(salary), count(*) from employees;
#9
select count(*) from employees;
#10
select count(distinct job_id) from employees;
#11
select upper(first_name) from employees;
#12
select substr(first_name,1,3) from employees;
#13
select 171*214+625 as result;
#14
select concat(first_name, ' ', last_name) as 'Name' from employees;
#15
select trim(first_name) from employees;
#16
select length(first_name),length(last_name) from employees;
#17
select * from employees where first_name regexp '[0-9]';
#18
select * from employees limit 10;
#19
select round(salary,2) from employees; 



