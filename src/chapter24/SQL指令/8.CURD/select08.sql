-- 多表查询
# 1.显示雇员名,雇员工资及所在部门的名字(笛卡尔集)
-- 1.雇员名, 雇员工资来自 emp2 表
-- 2.部门的名字来自 dept 表
-- 3.需求对 emp2 和 dept 查询 ename, sal, dname, deptno
-- 4.当我们需要指定显示某个表的列是，需要 表.列名
SELECT ename, sal, dname, emp2.deptno FROM emp2, dept WHERE emp2.deptno = dept.deptno;

-- 小技巧： 多表查询的条件不能少于表的个数 - 1, 否则会出现笛卡尔集
SELECT ename, sal, dname, emp2.deptno FROM emp2, dept;

-- 2.如何显示部门号为 10 的部门名、员工名和工资
# 需要查询 emp2 表 -> 员工名和工资, 部门名 -> dept 表
SELECT dept.deptno, dname, ename, sal FROM dept, emp2
	WHERE dept.deptno = emp2.deptno AND dept.deptno = 10;
	
# 3.显示各个员工的姓名，工资，及其工资的级别
# 3.1姓名，工资 -> emp2
SELECT ename, sal FROM emp2;
# 3.2工资的级别 -> salgrade
SELECT ename, sal, grade FROM emp2, salgrade
	WHERE sal BETWEEN losal AND hisal; # 方法 1
	
SELECT ename, sal, grade FROM emp2, salgrade
	WHERE sal >= salgrade.losal AND sal <= salgrade.hisal; # 方法 2