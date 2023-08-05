-- 演示 sql 注入
-- 创建一张表
-- 管理员表
CREATE TABLE admin2 (
	`name` VARCHAR(32) NOT NULL UNIQUE,
	pwd VARCHAR(32) NOT NULL DEFAULT ''
) CHARACTER SET utf8;

-- 添加数据
INSERT INTO admin2 VALUES('tom', '123');
INSERT INTO admin2 VALUES('jak', '456');

-- 查找某个管理是否存在
SELECT *
	FROM admin2
	WHERE NAME = 'tom' AND pwd = '123'

-- SQL
-- 输入用户名 为 1' or
-- 输入万能密码 为 or '1'= '1
SELECT * 
	FROM admin2
	WHERE `NAME` = '1' OR' AND pwd = 'OR '1'= '1'
