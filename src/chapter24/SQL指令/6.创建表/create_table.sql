# 创建表的课堂练习
-- 字段属性
-- Id 整形
-- name 字符型
-- sex 字符型
-- brithday 日期型（date）
-- entry_date 日期型 (date)
-- job 字符型
-- Salary 小数型
-- resume 文本型
CREATE TABLE t15(
	id INTEGER,
	`name` VARCHAR(32),
	sex CHAR(1),
	birthday DATE,
	entry_date DATE,
	job VARCHAR(32),
	salary FLOAT,
	`resume` TEXT
) CHARSET utf8 COLLATE utf8_bin ENGINE INNODB;

INSERT INTO t15 VALUES(100, '小妖怪', '男', '2023-07-09', '2023-07-11', '应用软件开发', 10000.0, '加班吧，牛马');
SELECT * FROM t15;