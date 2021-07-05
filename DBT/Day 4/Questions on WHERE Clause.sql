#1
select * from emp where DEPTNO = 10;
#2
select ename, sal from emp where job='clerk' or job='salesman';
#3
select ename from emp where hiredate > '1981-1-1';
#4
select ename from emp 
where hiredate > '1981-1-1' and hiredate < '1981-12-31';
#5
select * from emp
where job = 'clerk' and sal > 1000;
#6
select * from emp
where job != 'manager' and job != 'president'; 
#7
select * from emp
where comm is null;
#8
select * from emp
where sal+
case
	when comm is null then 0
    else comm
end > 2000;
#9
select * from emp
where job = 'salesman' and deptno in (10,30);
#10
select * from emp
where job = 'salesman' and deptno = 30 and comm is not null;

