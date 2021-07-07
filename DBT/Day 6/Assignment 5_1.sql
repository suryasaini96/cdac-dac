use scott;

#1
select * from emp 
where HIREDATE < (select HIREDATE from emp where ENAME = 'scott');
#2
select * from dept
where deptno in 
(select deptno from emp group by deptno having count(*) = 3);
#3
select * from dept where deptno in 
(select deptno from emp
where sal = (select min(sal) from emp)
union
select deptno from emp
where sal = (select max(sal) from emp));

# OR: --- solution 2 ---
select * from dept where deptno in 
(select deptno from emp
where sal = (select min(sal) from emp)
   or sal = (select max(sal) from emp));

#4   
select ename,sal,e.deptno,d.dname from emp e
right join dept d
on e.deptno = d.deptno;
#5
select ename,sal, e.deptno from emp e
left join dept d
on e.deptno = d.deptno;

#6
select ename, sal, d.dname from emp e
left join dept d
on e.deptno = d.deptno
union
select ename, sal, d.dname from emp e
right join dept d
on e.deptno = d.deptno;

#7
select e.ename,e.empno,d.dname 
from emp e,dept d
where e.deptno = d.deptno;

#8
select * from dept
where deptno not in
(select deptno from emp);

#9
select * from dept
where deptno in
(select distinct deptno from emp);

#10
select * from emp
where job != 'manager';

#11
select * from dept
where deptno in 
(select deptno from emp
where ename = 'james');

#12
select * from emp
where sal <= (select sal from emp where ename = 'adams');

#13
select e.ename,e.sal,g.grade,d.dname,d.loc
from emp e
inner join salgrade g on e.sal>=g.losal and e.sal<=g.hisal
inner join dept d on e.deptno = d.deptno;
# OR -- solution 2: --
select e.ename,e.sal,g.grade,d.dname,d.loc
from emp e, salgrade g, dept d
where e.sal>=g.losal and e.sal<=g.hisal
and e.deptno = d.deptno;
# OR -- solution 3: --
select e.ename,e.sal,
(select grade from salgrade g where e.sal>=g.losal and e.sal<=g.hisal) grade,
(select dname from dept d where e.deptno = d.deptno) dname,
(select loc from dept d where e.deptno = d.deptno) loc
from emp e order by grade;

#14
select e.ename 
from emp e
where e.deptno in (select deptno from dept d where d.loc = 'dallas');
# OR -- solution 2: --
select e.ename
from emp e
inner join dept d on d.loc = 'dallas' and e.deptno = d.deptno;
