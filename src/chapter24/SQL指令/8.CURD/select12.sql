# all 和 any 的使用
# 1.显示工资比部门 30 的所有员工的工资高的员工的姓名、工资和部门号
# 方法 1
SELECT ename, sal, deptno FROM emp2 WHERE
	sal > (SELECT MAX(sal) FROM emp2 WHERE deptno = 30);
	
# 方法 2，使用 all
SELECT ename, sal, deptno FROM emp2 WHERE
	sal > ALL (SELECT sal FROM emp2 WHERE deptno = 30);
	
# 2.如何显示工资比部门 30 的其中一个员工的工资高的员工的姓名、工资和部门号
# 方法 1
SELECT ename, sal, deptno FROM emp2 WHERE
	sal > (SELECT MIN(sal) FROM emp2 WHERE deptno = 30);
	
# 方法 2，使用 all
SELECT ename, sal, deptno FROM emp2 WHERE
	sal > ANY (SELECT sal FROM emp2 WHERE deptno = 30);