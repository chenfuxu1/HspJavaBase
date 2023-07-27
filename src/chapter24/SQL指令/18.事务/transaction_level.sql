-- 演示 mysql 的事务隔离级别
-- 1.开启两个 mysql 的控制台
-- 2.查看当前的 mysql 的隔离级别
SELECT @@tx_isolation;

-- 控制台 1
-- mysql> SELECT @@tx_isolation;
-- +-----------------+
-- | @@tx_isolation  |
-- +-----------------+
-- | REPEATABLE-READ |
-- +-----------------+

-- 控制台 2
-- mysql> SELECT @@tx_isolation;
-- +-----------------+
-- | @@tx_isolation  |
-- +-----------------+
-- | REPEATABLE-READ |
-- +-----------------+

-- 3.将控制台 2 隔离级别设置为 Read uncommitted
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

-- mysql> SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
-- Query OK, 0 rows affected (0.00 sec)
-- 
-- mysql> SELECT @@tx_isolation;
-- +------------------+
-- | @@tx_isolation   |
-- +------------------+
-- | READ-UNCOMMITTED |
-- +------------------+

-- 4.两个控制台都开启事务
START TRANSACTION;

-- 5.两个控制台都使用 db01 数据库
USE db01;

-- 6.创建表 account，任意一个终端创建即可
CREATE TABLE `account`(
	id INT,
	`name` VARCHAR(32),
	money INT
);

-- 7.在终端 1 插入一条记录
INSERT INTO `account` VALUES(100, 'tom', 1000);
-- 此时终端 1 并没有提交 commit，但是在终端 2 查询，可以查到记录
-- mysql> select * from account;
-- +------+------+-------+
-- | id   | name | money |
-- +------+------+-------+
-- |  100 | tom  |  1000 |
-- +------+------+-------+
-- 这就是脏读

