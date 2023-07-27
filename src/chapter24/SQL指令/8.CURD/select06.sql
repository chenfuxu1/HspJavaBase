# 练习，分页查询
-- 语法：select ... limit start, rows
-- 表示从 start + 1 行开始取，取出 rows 行，start 从 0 开始计算
-- 1.按雇员的 id 号升序取出，每页显示 3 条记录，请分别
-- 显示第1页，第2页，第3页
SELECT * FROM emp2 ORDER BY empno LIMIT 0, 3; # 第一页
SELECT * FROM emp2 ORDER BY empno LIMIT 3, 3; # 第二页
SELECT * FROM emp2 ORDER BY empno LIMIT 6, 3; # 第三页

# 2.推导一个公式
# LIMIT 每页显示记录数 * (第几页 - 1), 每页显示记录数
SELECT * FROM emp2 ORDER BY empno LIMIT (3 * (3 - 1)), 3; # 这样会报错，要把结果算出来

# 3.显示每种岗位的雇员总数、平均工资
SELECT COUNT(*), AVG(sal), job FROM emp2 GROUP BY job;
SELECT * FROM emp2;

# 4.显示雇员总数，以及获得补助的雇员数
SELECT COUNT(*), COUNT(comm) FROM emp2;

# 5.显示雇员总数，以及没有获得补助的雇员数
SELECT COUNT(*), COUNT(IF(comm IS NULL, 1, NULL)) FROM emp2;

# 6.显示管理者的总人数
SELECT COUNT(DISTINCT mgr) FROM emp2;

# 7.显示雇员工资的最大差额
SELECT MAX(sal) - MIN(sal) FROM emp2;