-- 根据 emp2 员工表、dept 部门表，工资 = 薪金 + 佣金
-- 1.列出至少有一个员工的所有部门
SELECT COUNT(*) AS c, deptno FROM emp2
	GROUP BY deptno
	HAVING c >= 1;

-- 2.列出薪金比 “SMITH” 多的所有员工
SELECT ename, sal FROM emp2
	WHERE sal > (SELECT sal FROM emp2 WHERE ename = 'SMITH');

-- 3.列出受雇日期晚于其直接上级的所有员工
SELECT ename, hiredate FROM emp2
	WHERE hiredate > (SELECT hiredate FROM emp2 AS temp WHERE temp.empno = emp2.mgr);

-- 4.列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门
SELECT dname, emp2.*
	FROM dept LEFT JOIN emp2 ON dept.deptno = emp2.deptno
	ORDER BY dept.deptno;

-- 5.列出所有 “CLERK” (办事员)的姓名及其部门名称
SELECT ename, job, dname, emp2.deptno 
	FROM emp2, dept
	WHERE emp2.deptno = dept.deptno AND emp2.job = 'CLERK';

-- 6.列出最低薪金大于 1500 的各种工作
SELECT DISTINCT job
	FROM emp2
	WHERE (sal + IFNULL(comm, 0)) > 1500;

-- 7.列出在部门 “SALES” (销售部)工作的员工的姓名
SELECT ename, dname
	FROM emp2, dept
	WHERE emp2.deptno = dept.deptno AND dept.dname = 'SALES';

-- 8.列出薪金高于公司平均薪金的所有员工
SELECT ename, sal FROM emp2
	WHERE sal > (
		SELECT AVG(sal) FROM emp2
	); # 方式 1
	
SELECT emp2.ename, emp2.sal, temp.avg_sal
	FROM(
		SELECT AVG(sal) AS avg_sal FROM emp2
	) temp, emp2
	WHERE emp2.sal > temp.avg_sal; # 方式 2