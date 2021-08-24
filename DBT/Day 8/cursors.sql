Cursors
---------

1. Prepare a program to display the comma separated list of employee names in following format

   Deptno    Employees
   -------   ------------
   10        Scott, Smith, Jones
   20        Allen, Ford
   30 

Answer:

-- With Cursor

DELIMITER $$
DROP PROCEDURE IF EXISTS P12 $$
CREATE PROCEDURE P12()
BEGIN
   DECLARE dept_id INT;
   DECLARE loop_done INT DEFAULT 0;
   DECLARE dept_cursor CURSOR
      FOR SELECT DISTINCT deptno FROM emp;

   DECLARE CONTINUE HANDLER FOR 1050
      BEGIN
         SELECT 'Temporary Table Already Exists. Deleting all records.' as Message;
         DELETE FROM emp_dept;
      END;

   DECLARE CONTINUE HANDLER FOR NOT FOUND SET loop_done = 1;

   CREATE TEMPORARY TABLE emp_dept ( deptno INT PRIMARY KEY, employees VARCHAR(100));

   OPEN dept_cursor;
   
   DEPTS : LOOP
      FETCH dept_cursor INTO dept_id;

      IF loop_done = 1
         THEN LEAVE DEPTS;
      END IF;

      INSERT INTO emp_dept (SELECT dept_id, GROUP_CONCAT(ename) FROM emp WHERE deptno = dept_id);

   END LOOP DEPTS;

   CLOSE dept_cursor;

   SELECT * FROM emp_dept;

   DROP TABLE emp_dept;
END $$
DELIMITER ;

-- Without Cursor

DELIMITER $$
DROP PROCEDURE IF EXISTS P12 $$
CREATE PROCEDURE P12()
BEGIN
   CREATE TEMPORARY TABLE emp_dept (
      SELECT deptno, GROUP_CONCAT(ename) FROM emp GROUP BY deptno
   );
   SELECT * FROM emp_dept;
   DROP TABLE emp_dept;
END $$
DELIMITER ;

--------------------------------------------------------------------------------
2. Prepare a program to show the details in following format

  Deptno     Dname      Employees
  -------   -------    -------------
  10         SALES     Scott, Smith, Jones

Answer:

DELIMITER $$
DROP PROCEDURE IF EXISTS P13 $$
CREATE PROCEDURE P13()
BEGIN
   CREATE TEMPORARY TABLE emp_dept (
      SELECT e.deptno, d.dname, GROUP_CONCAT(e.ename)
         FROM emp e
         JOIN dept d ON e.deptno = d.deptno
         GROUP BY deptno
   );
   SELECT * FROM emp_dept;
   DROP TABLE emp_dept;
END $$
DELIMITER ;

--------------------------------------------------------------------------------
3. For performance testing we are trying to increase number of records by 10 times
for each department. For eg: If there are 3 employees in dept 10 then
we should be able to increase the employee count to 30 using same / random values 

eg:

+-------+--------+-----------+------+------------+------+------+--------+
| EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL  | COMM | DEPTNO |
+-------+--------+-----------+------+------------+------+------+--------+
|  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |
+-------+--------+-----------+------+------------+------+------+--------+

Should Become

+-------+--------+-----------+------+------------+------+------+--------+
| EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL  | COMM | DEPTNO |
+-------+--------+-----------+------+------------+------+------+--------+
|  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7783 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7784 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7785 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7786 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
|  7787 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |
...........
|  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7840 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7841 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7842 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7843 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
|  7844 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |
...........
|  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |
+-------+--------+-----------+------+------------+------+------+--------+
  
--------------------------------------------------------------------------------
4. Prepare a program to create clone of all tables in given schema

Answer:

DELIMITER $$
DROP PROCEDURE IF EXISTS P14 $$
CREATE PROCEDURE P14()
BEGIN

   DECLARE tab_name VARCHAR(64);
   DECLARE tabs_over INT DEFAULT 0;

   DECLARE tabs_cursor CURSOR FOR
      SELECT t.table_name
         FROM information_schema.tables t
         WHERE t.table_schema = database();

   DECLARE CONTINUE HANDLER FOR NOT FOUND SET tabs_over = 1;

   OPEN tabs_cursor;

   TABS : LOOP

      FETCH tabs_cursor INTO tab_name;

      IF tabs_over = 1 THEN
         LEAVE TABS;
      END IF;

      SET @create_tbl = CONCAT('CREATE TABLE ', tab_name, '_copy LIKE ', tab_name);
      SET @populate_tbl = CONCAT('INSERT INTO ', tab_name, '_copy SELECT * FROM ', tab_name);

      PREPARE stmt1 FROM @create_tbl;
      EXECUTE stmt1;
      DEALLOCATE PREPARE stmt1;

      PREPARE stmt2 FROM @populate_tbl;
      EXECUTE stmt2;
      DEALLOCATE PREPARE stmt2;

   END LOOP TABS;

   CLOSE tabs_cursor;

   SHOW TABLES;
END $$
DELIMITER ;
