-- 视图练习
-- 针对 emp2，dept，salgrade 三张表，创建一个视图 emp_view03
-- 可以显示雇员编号、雇员名、部门名称、薪水级别(即使用三张表，创建一个视图)

CREATE VIEW emp_view03
	AS
	SELECT empno, ename, emp2.deptno, grade FROM emp2, dept, salgrade
	WHERE emp2.deptno = dept.deptno AND (emp2.sal BETWEEN salgrade.losal AND salgrade.hisal);

DESC emp_view03;
SELECT * FROM emp_view03;
