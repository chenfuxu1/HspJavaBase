-- 多表查询的 自连接
-- 1.思考题: 显示公司员工名字和他的上级的名字
# 上级的名字即 mgr 对应的数字
-- 1.把同一张表当做两张表使用
-- 2.需要给表取别名 表名 表别名
-- 3.列名不明确，可以指定列的别名 列名 as 列的别名

# 1.输出员工名字和上级的代号
SELECT ename, mgr FROM emp2;

# 2.把同一张表当做两张表使用
SELECT worker.ename, boss.job
	FROM emp2 worker, emp2 boss
	WHERE worker.mgr = boss.empno;

# 3.取别名
SELECT worker.ename AS '员工名', worker.mgr, boss.job AS '上司'
	FROM emp2 worker, emp2 boss
	WHERE worker.mgr = boss.empno;