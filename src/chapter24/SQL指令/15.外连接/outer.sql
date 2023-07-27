-- 外连接
-- 比如：列出部门名称和这些部门的员工名称和工作，
-- 同时要求显示出那些没有员工的部门。
-- 使用我们学习过的多表查询的 SQL，看看效果如何?
SELECT * FROM emp2; # 员工表
SELECT * FROM dept; # 部门表
# 该查询对于没有员工的部门，查询不到，不会显示
SELECT dname, ename, job FROM dept, emp2
	WHERE emp2.deptno = dept.deptno
	ORDER BY emp2.deptno;

-- 创建 stu
/*
id name
1 Jack
2 Tom
3 Kity
4 nono
*/
CREATE TABLE stu(
	`id` INT,
	`name` VARCHAR(32)
);
INSERT INTO stu VALUES
	(1, 'Jack'), (2, 'Tom'), (3, 'Kitty'), (4, 'Nono');
SELECT * FROM stu;

-- 创建 exam
/*
id grade
1 56
2 76
11 8
*/
CREATE TABLE exam(
	id INT,
	grade INT
);
INSERT INTO exam VALUES(1, 56), (2,76), (11, 8);
SELECT * FROM exam;

-- 1.使用左连接
-- 显示所有人的成绩，如果没有成绩，也要显示该人的姓名和 id 号，成绩显示为空
SELECT stu.id, `name`, grade
	FROM stu LEFT JOIN exam
	ON stu.id = exam.id;
	
-- 2.使用右外连接（显示所有成绩，如果没有名字匹配，显示空)
-- 即：右边的表(exam)和左表没有匹配的记录，也会把右表的记录显示出来
SELECT exam.id, `name`, grade
	FROM stu RIGHT JOIN exam
	ON stu.id = exam.id;

-- 练习
-- 列出部门名称和这些部门的员工信息(名字和工作)，
-- 同时列出那些没有员工的部门名。
-- 使用左外连接实现
SELECT dname, ename, job
	FROM dept LEFT JOIN emp2
	ON dept.deptno = emp2.deptno
	ORDER BY dept.deptno; 

-- 使用右外连接实现
SELECT dname, ename, job
	FROM emp2 RIGHT JOIN dept
	ON dept.deptno = emp2.deptno
	ORDER BY dept.deptno; 
