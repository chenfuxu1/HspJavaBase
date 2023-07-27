-- unique的使用
-- 不可以重复，但可以为空 null，且可以指定多个字段为 unique
-- 当字段指定为 unique，且 not null 时，可以当做 primary key 使用
CREATE TABLE t22(
	id INT UNIQUE ,  -- 表示 id 列是不可以重复的.
	`name` VARCHAR(32),
	email VARCHAR(32)
);
DESC t22;
INSERT INTO t22 VALUES(1, 'jack', 'jack@sohu.com');
# 不能插入，因为id要唯一
# Duplicate entry '1' for key 'id'
INSERT INTO t22 VALUES(1, 'tom', 'tom@sohu.com');

-- unqiue 使用细节
-- 1.如果没有指定 not null, 则 unique 字段可以有多个 null
-- 如果一个列(字段)，是 unique not null 使用效果类似primary key
INSERT INTO t22 VALUES(NULL, 'tom', 'tom@sohu.com');
INSERT INTO t22 VALUES(NULL, 'tom', 'tom@sohu.com');
INSERT INTO t22 VALUES(NULL, 'tom', 'tom@sohu.com'); # 还可以插入，因为可以有多个 null
SELECT * FROM t22;

-- 2.一张表可以有多个unique字段
CREATE TABLE t23(
	id INT UNIQUE, -- 表示 id 列是不可以重复的.
	`name` VARCHAR(32) UNIQUE, -- 表示 name 不可以重复
	email VARCHAR(32)
);
DESC t23;
