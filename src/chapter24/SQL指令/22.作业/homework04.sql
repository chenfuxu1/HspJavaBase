-- 根据 emp2 员工表，写出正确的 sql 语句
-- 13.显示不带有 "R" 的员工的姓名.
SELECT ename FROM emp2 WHERE ename NOT LIKE '%R%';

-- 14.显示所有员工姓名的前三个字符.
SELECT LEFT(ename, 3) FROM emp2;

-- 15.显示所有员工的姓名, 用 a 替换所有 "A"
SELECT REPLACE(ename, 'A', 'a') FROM emp2;

-- 16.显示满 10 年服务年限的员工的姓名和受雇日期.
SELECT ename, hiredate FROM emp2
	WHERE DATE_ADD(hiredate, INTERVAL 10 YEAR) <= NOW();

-- 17.显示员工的详细资料, 按姓名排序.
SELECT * FROM emp2 ORDER BY ename DESC;

-- 18.显示员工的姓名和受雇日期, 根据其服务年限, 将最老的员工排在最前面.
SELECT ename, hiredate FROM emp2
	ORDER BY hiredate ASC;

-- 19.显示所有员工的姓名、工作和薪金, 按工作降序排序, 若工作相同则按薪金排序.
SELECT ename, job, sal FROM emp2
	ORDER BY job DESC, sal DESC;

-- 20.显示所有员工的姓名、加入公司的年份和月份, 按受雇日期所在月排序, 若月份相同则将最早年份的员工排在最前面.
SELECT ename, YEAR(hiredate), MONTH(hiredate)  FROM emp2
	ORDER BY MONTH(hiredate) ASC, YEAR(hiredate) ASC;

-- 21.显示在一个月为 30 天的情况所有员工的日薪金, 忽略余数.
SELECT FLOOR(sal / 30), sal / 30 FROM emp2;

-- 22.找出在(任何年份的) 2 月受聘的所有员工
SELECT * FROM emp2 WHERE MONTH(hiredate) = 2;

-- 23.对于每个员工, 显示其加入公司的天数.
SELECT ename, DATEDIFF(NOW(), hiredate) FROM emp2;

-- 24.显示姓名字段的任何位置包含 "A" 的所有员工的姓名.
SELECT ename FROM emp2 WHERE ename LIKE '%A%';

-- 25.以年月日的方式显示所有员工的服务年限.
SELECT ename, FLOOR(DATEDIFF(NOW(), hiredate) / 365) AS '工作年',
	FLOOR(DATEDIFF(NOW(), hiredate) % 365 / 30) AS '工作月',
	(DATEDIFF(NOW(), hiredate) % 30) AS '工作天'
	FROM emp2;
