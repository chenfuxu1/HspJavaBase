# 加密函数和系统函数
-- 1.USER() 查询用户, 可以查看登录到 mysql 的有哪些用户，以及登录的 IP
-- 2.DATABASE() 查询当前使用数据库名称
-- 3.MD5(str) 为字符串算出一个 MD5 32 的字符串，常用(用户密码)加密
-- 4.PASSWORD(str) -- 加密函数, MySQL 数据库的用户密码就是 PASSWORD 函数加密

# 1.USER() 查询用户, 可以查看登录到 mysql 的有哪些用户，以及登录的 IP
SELECT USER() FROM DUAL;

# 2.DATABASE() 查询当前使用数据库名称
SELECT DATABASE();
SELECT DATABASE() FROM DUAL;

# 3.MD5(str) 为字符串算出一个 MD5 32 的字符串，常用(用户密码)加密
# root 密码是 12345 -> 加密 md5 -> 在数据库中存放的是加密后的密码
SELECT MD5('12345') FROM DUAL;
SELECT LENGTH(MD5('12345')) FROM DUAL;

# 4.演示用户表，存放密码时，是md5加密后的密码
CREATE TABLE cfx_user(
	id INT,
	`name` VARCHAR(32) NOT NULL DEFAULT ' ',
	pwd CHAR(32) NOT NULL DEFAULT ' '
);
INSERT INTO cfx_user VALUES(1, '荒天帝', MD5('123'));
INSERT INTO cfx_user VALUES(2, '叶天帝', MD5('456'));
INSERT INTO cfx_user VALUES(3, '楚天帝', MD5('789'));
SELECT * FROM cfx_user;
SELECT * FROM cfx_user WHERE `name`='荒天帝' AND pwd = MD5('123'); -- SQL 注入问题

# 5.PASSWORD(str) --加密函数, MySQL 数据库的用户密码就是 PASSWORD 函数加密
SELECT PASSWORD('12345') FROM DUAL; # *00A51F3F48415C7D4E8908980D443C29C69B60C9

-- select * from mysql.user 从原文密码 str 计算并返回密码字符串
-- 通常用于对 mysql 数据库的用户密码加密
-- mysql.user 表示 数据库.表
SELECT * FROM mysql.user;
SELECT * FROM db01.t1;
