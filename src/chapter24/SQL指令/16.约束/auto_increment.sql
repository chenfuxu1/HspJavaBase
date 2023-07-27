-- 演示自增长的使用
-- 创建表
CREATE TABLE t25(
	id INT PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(32) NOT NULL DEFAULT '',
	`name` VARCHAR(32) NOT NULL DEFAULT ''
);
DESC t25;
-- 测试自增长的使用
INSERT INTO t25 VALUES(NULL, 'tom@qq.com', 'tom');
INSERT INTO t25(email, `name`) VALUES ('hsp@sohu.com', 'hsp');
SELECT * FROM t25;

-- 修改默认的自增长开始值
CREATE TABLE t26(
	id INT PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(32) NOT NULL DEFAULT '',
	`name` VARCHAR(32) NOT NULL DEFAULT ''
);
ALTER TABLE t26 AUTO_INCREMENT = 50; # 修改默认的自增长初始值为 50
INSERT INTO t26 VALUES(NULL, 'mary@qq.com', 'mary'); # 默认 id 为 50 了
INSERT INTO t26 VALUES(665, 'hsp@qq.com', 'hsp');
SELECT * FROM t26;