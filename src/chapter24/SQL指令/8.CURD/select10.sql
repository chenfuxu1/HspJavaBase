-- 单行子查询的演示
-- 1.请思考：如何显示与 SMITH 同一部门的所有员工?
# 1.1.先查询 SMITH 所在的部门
SELECT deptno FROM emp2 WHERE ename = 'SMITH';
# 1.2.将 1 查询结果给 2 使用
SELECT * FROM emp2 
	WHERE deptno = (SELECT deptno FROM emp2 WHERE ename = 'SMITH');
	
# 多行子查询，关键字 in
# 2.如何查询和部门 10 的工作相同的雇员的
-- 名字、岗位、工资、部门号、但是不含十号部门自己的雇员

# 2.1 找到 10 号部门的工作 job 有哪些
SELECT DISTINCT job FROM emp2 WHERE deptno = 10;
# 2.2 查询与 10 号部门相同的工作
SELECT ename, job, sal, deptno FROM emp2 WHERE
	job IN (SELECT DISTINCT job FROM emp2 WHERE deptno = 10);
# 2.3 去除 10 号部门的员工
SELECT ename, job, sal, deptno FROM emp2 WHERE
	job IN (SELECT DISTINCT job FROM emp2 WHERE deptno = 10) AND deptno != 10;
