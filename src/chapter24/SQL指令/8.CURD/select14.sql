-- 练习- from 子句中使用子查询
-- 请思考：查找每个部门工资高于本部门平均工资的人的资料
-- 这里要用到数据查询的小技巧，把一个子查询当作一个临时表使用
# 1.1查询每个部门的平均工资
SELECT AVG(sal) AS avg_sal, deptno FROM emp2 GROUP BY deptno;
# 1.2查找每个部门工资高于本部门平均工资的人
SELECT ename, sal, temp.avg_sal, emp2.deptno FROM
	emp2, (SELECT AVG(sal) AS avg_sal, deptno FROM emp2 GROUP BY deptno) temp WHERE
	emp2.deptno = temp.deptno AND emp2.sal > temp.avg_sal ORDER BY
	emp2.deptno;

# 2.查找每个部门工资最高的人的详细资料
# 2.1查找每个部门工资最高的数据
SELECT MAX(sal) AS max_sal, deptno FROM emp2 GROUP BY deptno;
# 2.2根据临时表查询最高的详细信息
SELECT empno, ename, job, mgr, hiredate, sal, comm, emp2.deptno, max_sal FROM emp2,
	(SELECT MAX(sal) AS max_sal, deptno FROM emp2 GROUP BY deptno) temp WHERE
	emp2.deptno = temp.deptno AND emp2.sal = temp.max_sal
	ORDER BY emp2.deptno;
	
# 3.查询每个部门的信息(包括：部门名, 编号, 地址)和人员数量
# 部门名, 编号, 地址 来自 dept 表
# 各个部门的人员数量 -> 构建一个临时表
# 3.1 查询各个部门的人数
SELECT COUNT(deptno) AS cou, deptno FROM emp2 GROUP BY deptno;
# 3.2 查询每个部门的信息(包括：部门名, 编号, 地址)和人员数量
SELECT dept.deptno, dname, loc, cou FROM dept,
	(SELECT COUNT(deptno) AS cou, deptno FROM emp2 GROUP BY deptno) temp WHERE 
	dept.deptno = temp.deptno ORDER BY dept.deptno;

-- 还有一种写法 表 .* 表示将该表所有列都显示出来, 可以简化 sql 语句
-- 在多表查询中，当多个表的列不重复时，才可以直接写列名
SELECT temp.*, dname, loc
	FROM dept, (SELECT COUNT(deptno) AS cou, deptno FROM emp2 GROUP BY deptno) temp
	WHERE dept.deptno = temp.deptno
	ORDER BY dept.deptno;