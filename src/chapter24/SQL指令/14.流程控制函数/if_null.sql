# 流程控制语句
-- 1.IF(expr1, expr2, expr3) 如果 expr1 为True,则返回 expr2 否则返回 expr3
-- 2.IFNULL(expr1,expr2) 如果 expr1 不为空 NULL, 则返回expr1, 否则返回 expr2
-- 3.SELECT CASE WHEN expr1 THEN expr2 WHEN expr3 THEN expr4 ELSE expr5 END; 
-- (类似多重分支)

# 1.IF(expr1, expr2, expr3) 如果 expr1 为True, 则返回 expr2 否则返回 expr3
SELECT IF(TRUE, '南京', '北京') FROM DUAL; # 南京
SELECT IF(FALSE, '南京', '北京') FROM DUAL; # 北京

# 2.IFNULL(expr1,expr2) 如果 expr1 不为空 NULL, 则返回expr1, 否则返回 expr2
SELECT IFNULL('哈哈', '默认值') FROM DUAL; # 哈哈
SELECT IFNULL(NULL, '默认值') FROM DUAL; # 默认值

# 3.SELECT CASE WHEN expr1 THEN expr2 WHEN expr3 THEN expr4 ELSE expr5 END; 
# (类似多重分支) 如果 expr1 为 TRUE, 则返回 expr2, 如果 expr3 为 t, 返回 expr4, 否则返回 expr5
SELECT CASE WHEN TRUE THEN '路飞'
	WHEN FALSE THEN '娜美'
	ELSE '索隆' END;
	
# 练习 1.查询 emp2 表, 如果 comm 是 null, 则显示 0.0
# 判断是否为 null 要使用 is null, 判断不为空 使用 is not
SELECT ename, IF(comm IS NULL, 0.0, comm) FROM emp2; # 方法 1
SELECT ename, IFNULL(comm, 0.0) FROM emp2;  # 方法 2

# 2.如果 emp2 表的 job 是 CLERK 则显示职员，如果是 MANAGER 则显示经理
# 如果是 SALESMAN 则显示销售人员，其它正常显示
SELECT ename, (CASE WHEN job = 'CLERK' THEN '职员'
	WHEN job = 'MANAGER' THEN '经理'
	WHEN job = 'SALESMAN' THEN '销售人员'
	ELSE job END) AS '工作'
	FROM emp2;
SELECT * FROM emp2;