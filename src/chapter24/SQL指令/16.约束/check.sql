-- 演示 check 的使用
-- mysql5.7 目前还不支持 check, 只做语法校验，但不会生效
-- 了解
-- 学习 oracle, sql server, 这两个数据库是真的生效
-- 测试
CREATE TABLE t24(
	id INT PRIMARY KEY,
	`name` VARCHAR(32) ,
	sex VARCHAR(6) CHECK (sex IN('man', 'woman')),
	sal DOUBLE CHECK ( sal > 1000 AND sal < 2000)
);
-- 添加数据
INSERT INTO t24 VALUES(1, 'jack', 'mid', 1); # 能插入成功，mysql 的 check 不能成功
SELECT * FROM t24;