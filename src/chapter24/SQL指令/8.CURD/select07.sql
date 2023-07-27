-- 顺序：group by, having, order by, limit
-- 应用案例：
-- 1.请统计各个部门 group by 的平均工资 avg，
-- 2.并且是大于 1000 的 having，并且按照平均工资从高到低排序，order by
-- 3.取出前两行记录 limit 0, 2

# 1.请统计各个部门 group by 的平均工资 avg
SELECT deptno, AVG(sal) FROM emp2 GROUP BY deptno;

# 2.并且是大于 1000 的 having，并且按照平均工资从高到低排序，order by
SELECT deptno, AVG(sal) FROM emp2 GROUP BY deptno HAVING AVG(sal) > 1000;

# 3.取出前两行记录 limit 0, 2
SELECT deptno, AVG(sal) FROM emp2 GROUP BY deptno HAVING AVG(sal) > 1000 LIMIT 0, 2;
SELECT * FROM emp2;