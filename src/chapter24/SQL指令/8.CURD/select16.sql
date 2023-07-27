-- 合并查询
SELECT ename, sal, job FROM emp2 WHERE sal > 2500; # 5 条记录

SELECT ename, sal, job FROM emp2 WHERE job = 'MANAGER'; # 3 条记录

# 1.union all 是将两个查询的结果合并，不会去重
SELECT ename, sal, job FROM emp2 WHERE sal > 2500
UNION ALL
SELECT ename, sal, job FROM emp2 WHERE job = 'MANAGER'; # 共 8 条记录

# 2.union 是将两个查询的结果合并，会去重
SELECT ename, sal, job FROM emp2 WHERE sal > 2500
UNION
SELECT ename, sal, job FROM emp2 WHERE job = 'MANAGER'; # 共 6 条记录