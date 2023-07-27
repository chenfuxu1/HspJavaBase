-- 视图的使用
-- 创建一个视图 emp_view01，只能查询 emp2 表的(empno, ename, job, deptno) 信息
-- 其他信息无法查询

# 1.创建视图
CREATE VIEW emp_view01
	AS
	SELECT empno, ename, job, deptno FROM emp2;
	
# 2.查看视图
DESC emp_view01;

# 3.查询视图
SELECT * FROM emp_view01;

# 4.查看创建视图的指令
SHOW CREATE VIEW emp_view01;

# 5.删除视图
DROP VIEW emp_view01;

-- 视图的细节
# 6.数据共享，会相互影响
# 改变视图，基表也变化
UPDATE emp_view01
	SET job = 'MANAGER'
	WHERE empno = 7369;
# 改变基表，视图也变化
UPDATE emp2
	SET job = 'SALESMAN'
	WHERE empno = 7369;

SELECT * FROM emp_view01;	
SELECT * FROM emp2;

# 7.视图中再使用视图，比如从 emp_view01 视图中，选择出 empno, ename 做出新视图 emp_view02
CREATE VIEW emp_view02
	AS
	SELECT empno, ename FROM emp_view01;

SELECT * FROM emp_view02;

