-- 根据 emp2 表写出正确的 sql
-- 1.选择部门 30 中的所有员工
SELECT * FROM emp2 WHERE deptno = 30;

-- 2.列出所有办事员(CLERK)的姓名，编号和部门编号
SELECT ename, empno, deptno FROM emp2 WHERE job = 'CLERK';

-- 3.找出佣金高于薪金的员工.
SELECT * FROM emp2 WHERE comm > sal;

-- 4.找出佣金高于薪金 60% 的员工.
SELECT * FROM emp2 WHERE comm > (sal * 0.6);

-- 5.找出部门 10 中所有经理(MANAGER)和部门 20 中所有办事员(CLERK)的详细资料
SELECT * FROM emp2
	WHERE (deptno = 10 AND job = 'MANAGER') OR (deptno = 20 AND job = 'CLERK');

-- 6.找出部门 10 中所有经理(MANAGER), 部门 20 中所有办事员(CLERK)，还有既不是
-- 经理又不是办事员但其薪金大于或等于 2000 的所有员工的详细资料.
SELECT * FROM emp2
	WHERE (deptno = 10 AND job = 'MANAGER') OR (deptno = 20 AND job = 'CLERK') OR (job != 'MANAGER' AND job != 'CLERK' AND sal >= 2000);

-- 7.找出收取佣金的员工的不同工作.
SELECT DISTINCT job
	FROM emp2
	WHERE comm IS NOT NULL;

-- 8.找出不收取佣金或收取的佣金低于 100 的员工.
SELECT *
	FROM emp2
	WHERE (comm IS NULL) OR IFNULL(comm, 0) < 100;

-- 9.找出各月倒数第 3 天受雇的所有员工.
-- last_day(日期) 可以返回该日期所在月的最后一天
-- LAST_DAY(hiredate) - 2 得到的日期就是所在月份的倒数第三天
SELECT *
	FROM emp2
	WHERE LAST_DAY(hiredate) - 2 = hiredate;

-- 10.找出早于 12 年前受雇的员工(即入职时间超过了 12 年)
SELECT * FROM emp2
	WHERE DATE_ADD(hiredate, INTERVAL 12 YEAR) < NOW();

-- 11.以首字母小写的方式显示所有员工的姓名.
SELECT CONCAT(LCASE(SUBSTRING(ename, 1, 1)), SUBSTRING(ename, 2)) FROM emp2;

-- 12.显示正好为 5 个字符的员工的姓名.
SELECT ename FROM emp2 WHERE LENGTH(ename) = 5;
