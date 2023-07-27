# 1.主键的使用 primary key
# id name email
CREATE TABLE t17(
	# 表示 id 为主键，不能为 null，不能重复，一个表只能有一个字段为主键
	id INT PRIMARY KEY,
	`name` VARCHAR(32),
	email VARCHAR(32)
);
DESC t17;

# 1.主键的值不可以重复
INSERT INTO t17 VALUES(1, 'jack', 'jack@sohu.com');
INSERT INTO t17 VALUES(2, 'tom', 'tom@sohu.com');
SELECT * FROM t17;
# 开始插入重复数据
INSERT INTO t17 VALUES(1, 'jack', 'jack@sohu.com'); # 插入失败，Duplicate entry '1' for key 'PRIMARY'

# 主键的细节讨论
# 2.主键不能重复，且不能为 null
INSERT INTO t17 VALUES(NULL, 'jack', 'jack@sohu.com'); # Column 'id' cannot be null

# 3.一张表最多只有一个主键，但可以是复合主键(比如 id + name)
# 创建失败，Multiple primary key defined
CREATE TABLE t18(
	id INT PRIMARY KEY,  # id 字段为主键
	`name` VARCHAR(32) PRIMARY KEY, # 错误，只能有一个主键
	email VARCHAR(32)
);

# 4.做成复合主键(id + name)
CREATE TABLE t18(
	id INT, 
	`name` VARCHAR(32),
	email VARCHAR(32),
	PRIMARY KEY(`id`, `name`) # 这里就是复合主键
);
DESC t18;
INSERT INTO t18 VALUES(1, 'tom', 'tom@sohu.com');
INSERT INTO t18 VALUES(1, 'jack', 'jack@sohu.com'); # 可以插入，因为 name 不一样

# 这里就违反了复合主键，id，name全和第一条一样
# Duplicate entry '1-tom' for key 'PRIMARY'
INSERT INTO t18 VALUES(1, 'tom', 'xx@sohu.com'); # 虽然执行成功，但插入数据失败
SELECT * FROM t18;

-- 主键的指定方式有两种
-- 1.直接在字段名后指定：字段名 primakry key
-- 2.在表定义最后写 primary key(列名);
-- 第一种,直接在字段名后指定
CREATE TABLE t20(
	id INT ,
	`name` VARCHAR(32) PRIMARY KEY,
	email VARCHAR(32)
); 
-- 第二种,在表定义最后写 primary key(列名)
CREATE TABLE t21(
	id INT,
	`name` VARCHAR(32),
	email VARCHAR(32),
	PRIMARY KEY(`name`) -- 在表定义最后写 primary key(列名)
);
DESC t20;
DESC t21;
