-- 练习十四-多列子查询
-- 请思考如何查询与 allen 的部门和岗位完全相同的所有雇员(并且不含 allen 本人)
-- (字段 1，字段 2 ...) = (select 字段 1，字段 2 from 。 。 。 。 )
# 1.得到 allen 的部门和岗位
SELECT deptno, job FROM emp2 WHERE ename = 'ALLEN';

# 2.查询与 allen 的部门和岗位完全相同的所有雇员
SELECT * FROM emp2 WHERE
	(deptno, job) = (SELECT deptno, job FROM emp2 WHERE ename = 'ALLEN')
	AND ename != 'ALLEN';
	
-- 查询和宋江数学，英语，语文
-- 成绩完全相同的学生
# 1.查询宋江数学，英语，语文成绩
SELECT chinese, english, math FROM student WHERE `name` = '宋江';
# 2.查询和宋江相同的学生
SELECT * FROM student WHERE 
	(chinese, english, math) = (SELECT chinese, english, math FROM student WHERE `name` = '宋江')
	AND `name` != '宋江';