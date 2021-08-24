use humanresource;

show tables;

select * from departments;

select * from employees;

select * from locations where city = 'London';

# ------- Solutions --------

#Q.1
select department_name, concat(first_name, ' ', last_name) name, hire_date, salary
from departments d join employees e 
on (d.manager_id = e.employee_id) 
where (sysdate()-hire_date)/365 > 15;

#Q.2
select manager_id, min(salary) salary
from employees
where manager_id is not null
and salary > 6000
group by manager_id
order by min(salary) desc;

#Q.3
#1.
select e.employee_id, concat(e.first_name, ' ', e.last_name) name, salary
from employees e
where department_id in (select department_id from departments
where location_id in (select location_id from locations where city = 'London'));

#2.
select last_name from employees where first_name like 's%';

#3.
select * from employees where date_format(hire_date, 'month')='October' 
and date_format(hire_date,'day')='Monday';

#4.
select upper(concat(first_name, ' ', last_name)) name, upper(l.city) city from employees e
join departments d
on d.department_id = e.department_id
join locations l
on d.location_id = l.location_id;

#5.
select d.department_name, e.salary from departments d 
join (select department_id, max(salary) salary from employees group by department_id) e
on e.department_id = d.department_id;

#Q.4
create table emp_intermediate like employees;  

insert into emp_intermediate  
select * from employees  
group by employee_id;  

drop table employees;  
alter table emp_intermediate rename to employees; 

#Q.5
create index month_values on employees(hire_date);

#Q.6
create view view_employees as
select employee_id, first_name, last_name, salary
from employees;

select * from view_employees;

update employees set salary = 2000 where employee_id = 105;
delete from employees where employee_id = 106;
update employees set department_id = 100 where employee_id = 108;

#Q7
select j.job_title, d.department_name, concat(e.first_name, ' ', e.last_name) full_name, jh.start_date
from employees e
inner join job_history jh
on e.employee_id = jh.employee_id
and jh.start_date between '1993-01-01' and '1997-08-31'
inner join jobs j
on jh.job_id = j.job_id
inner join departments d
on jh.department_id = d.department_id;

#Q.8
select concat(e.first_name, ' ', e.last_name) full_name,
j.job_title, jh.* 
from employees e
inner join (select max(start_date) starting_date,
	max(end_date) ending_date, employee_id from job_history group by employee_id) jh
on e.employee_id = jh.employee_id
inner join jobs j
on e.job_id = j.job_id
where e.commission_pct = 0;

#Q.9
select e1.first_name as "emp_name", e2.first_name as "mgr_name"
from employees e1
left join employees e2
on e1.manager_id = e2.employee_id;

#Q.10
select e.first_name, e.last_name, d.department_name, l.city, l.state_province
from employees e
inner join departments d
on e.department_id = d.department_id
inner join locations l
on d.location_id = l.location_id
where e.first_name like '%z%';

#Q.11
select concat(e.first_name, ' ', e.last_name) full_name, d.department_id, d.department_name
from departments d
left join employees e
on d.department_id = e.department_id;

#Q.12
select e1.first_name, e1.last_name, e1.salary
from employees e1
inner join employees e2
on e1.salary < e2.salary
and e2.employee_id = 182;

#Q.13
select e1.first_name as "emp_name", e2.first_name as "mgr_name"
from employees e1
inner join employees e2
on e1.manager_id = e2.employee_id;


















