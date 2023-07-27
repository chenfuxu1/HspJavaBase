-- 表类型和存储引擎
# 1.查看所有的存储引擎
SHOW ENGINES;

# 2.InnoDB 存储引擎，支持事务，支持外键，支持行级锁

# 3. myisam 存储引擎
# 特点：添加速度快，不支持事务和外键，支持表级锁
CREATE TABLE t30(
	id INT,
	`name` VARCHAR(32)
) ENGINE MYISAM;

START TRANSACTION;
SAVEPOINT a;
INSERT INTO t30 VALUES(1, 'tom');
SELECT * FROM t30; # 添加成功
ROLLBACK; # 无法回滚

# 4.memory 存储引擎
# 特点：数据存储在内存(关闭了 mysql 数据就丢失了，但表的结构还在)；执行速度快(没有 IO 读写)，默认支持索引(hash 表)
CREATE TABLE t31(
	id INT,
	`name` VARCHAR(32)
) ENGINE MEMORY;

INSERT INTO t31 VALUES(1, 'tom'), (2, 'marry'), (3, 'jack');
SELECT * FROM t31;