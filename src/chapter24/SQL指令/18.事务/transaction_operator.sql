-- 事务操作
# 1.创建一张表
CREATE TABLE t29(
	id INT,
	`name` VARCHAR(32)
);

# 2.开始事务
START TRANSACTION;

# 3.设置保存点
SAVEPOINT a;

# 4.执行 dml 操作
INSERT INTO t29 VALUES(100, 'tom');
SELECT * FROM t29;

# 5.设置保存点 b
SAVEPOINT b;

# 6.执行 dml 操作
INSERT INTO t29 VALUES(200, 'Jerry');

# 7.回退到保存点 b
ROLLBACK TO b;

# 8.回退到保存点 a
ROLLBACK TO a;

-- 如果直接执行 ROLLBACk(回退全部事务)，那么会回退到事务开始的位置
-- commit 会提交事务，提交后无法回退
