-- 根据 emp2 员工表、dept 部门表，工资 = 薪金 + 佣金
-- 9.列出与 “SCOTT” 从事相同工作的所有员工
SELECT job FROM emp2 WHERE ename = 'SCOTT';
SELECT * FROM emp2
	WHERE job = (SELECT job FROM emp2 WHERE ename = 'SCOTT');

-- 10.列出薪金高于在部门 30 工作的所有员工的薪金的员工姓名和薪金
-- 10.1 找到部门 30 的最高员工工资
SELECT MAX(sal) FROM emp2 WHERE deptno = 30;
-- 10.2 列出高于该工资的员工
SELECT ename, sal FROM emp2
	WHERE sal > (SELECT MAX(sal) FROM emp2 WHERE deptno = 30);

-- 11.列出在每个部门工作的员工数量、平均工资和平均服务期限
SELECT COUNT(*) AS '员工数量', AVG(sal) AS '平均工资', AVG(DATEDIFF(NOW(), hiredate)) AS '平均服务期限'
	FROM emp2
	GROUP BY deptno
	ORDER BY deptno;

-- 12.列出所有员工的姓名、部门名称和工资
SELECT ename, dname, sal
	FROM emp2, dept
	WHERE emp2.deptno = dept.deptno;

-- 13.列出所有部门的详细信息和部门人数
SELECT dept.*, IFNULL(temp.cou, 0)
	FROM dept LEFT JOIN (
		SELECT COUNT(*) AS cou, deptno FROM emp2 GROUP BY deptno
	) temp
	ON dept.deptno = temp.deptno
	
-- 14.列出各种工作的最低工资
SELECT job, MIN(sal + IFNULL(comm, 0))
	FROM emp2
	GROUP BY job;

-- 15.列出 MANAGER(经理)的最低薪金
SELECT job, MIN(sal)
	FROM emp2
	GROUP BY job
	HAVING job = 'MANAGER';

-- 16.列出所有员工的年工资, 按年薪从低到高排序
SELECT ename, (sal + IFNULL(comm, 0)) * 12 AS nian_gong_zi
	FROM emp2
	ORDER BY nian_gong_zi ASC;
