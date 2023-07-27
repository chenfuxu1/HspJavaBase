-- 2.查看 dept 和 emp2 表的结构
DESC dept;
DESC emp2;

-- 3.使用简单查询语句完成
# 3.1显示所有部门名称
SELECT dname FROM dept;
# 3.2 显示所有员工名及其全年收入(工资 + 补助)(13 个月计算)，并指定列别名为 年收入
SELECT ename, (sal + IFNULL(comm, 0)) * 13 AS '年收入' FROM emp2;

-- 4.限制查询数据
# 4.1 显示工资超过 2850 的员工和工资
SELECT ename, sal FROM emp2 WHERE sal > 2850;
# 4.2 显示工资不在 1500 到 2850 之间的所有员工名和工资
SELECT ename, sal FROM emp2
	WHERE sal > 2850 OR sal < 1500;
# 4.3 显示编号为 7566 的员工名和所在部门编号
SELECT ename, deptno FROM emp2 WHERE empno = 7566;
# 4.4 显示部门 10 和 30 中工资超过 1500 的员工名及工资
SELECT ename, sal, deptno FROM emp2
	WHERE sal > 1500 AND deptno IN (10, 30);
# 4.5 显示无管理者的员工名及岗位
SELECT ename, job FROM emp2 WHERE mgr IS NULL;

-- 5.排序数据
# 5.1 显示在 1991 年 2 月 1 日到 1991 年 5 月 1 日之间雇用的员工名及雇用日期，并以雇用日期进行排序
SELECT ename, hiredate FROM emp2 WHERE hiredate >= '1991-02-01' AND hiredate <= '1991-05-01'
	ORDER BY hiredate;
# 5.2 显示获得补助的所有员工名、工资以及补助，并以工资降序排序
SELECT ename, sal, comm FROM emp2
	WHERE comm IS NOT NULL
	ORDER BY comm DESC;
