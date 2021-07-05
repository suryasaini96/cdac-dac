use scott;

#1
select * from emp as e, 
(select deptno,avg(sal) as avg_sal from emp group by deptno) as avrg
where e.deptno = avrg.deptno and e.sal > avrg.avg_sal;
#2
select * from emp where length(ename) = 5;
#3
select * from emp where ename like 'J%S';
#4
select * from emp where deptno not in (10,20,40);
#5
select * from emp where job not in ('president', 'manager');
#6
select * from emp where length(sal) = 3;
#7
select * from emp where comm is null;
#8
select * from emp where ename like '_L%';

#9
select max(sal) from emp;
select min(sal) from emp;
#10
select deptno,count(*) as c from emp group by deptno having c=3;
#11
# There's no CONNECT BY clause in mysql!
#12

#13

#14

#15

#16
select deptno from dept where deptno not in
(select deptno from emp);
#17
select deptno from dept where deptno in
(select deptno from emp);
#18
select * from emp where job not in ('manager');
#19
select concat(ename, ' belongs to ', deptno) from emp;







