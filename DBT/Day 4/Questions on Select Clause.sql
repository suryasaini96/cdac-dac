use scott;

#1
select * from emp;
#2
select empno, ename from emp;
#3
desc emp;
desc dept;
desc salgrade;
#4
select distinct job from emp;
#5
select concat(ename,' is earning ', sal, ' dollars') from emp where ename='scott';
#6
select ename as 'Employee Name', job as 'Designation' from emp;
#7
select ename, sal+
case
	when comm is null then 0
    else comm
end + 1000 as 'Annual Salary' from emp;
#8
select empno as 'Manager Number' from emp 
where job='MANAGER' 
and empno is not null;
#9
select ename, sal, 
case 
	when comm is null then 1500
    else comm
end as 'comm' from emp;


