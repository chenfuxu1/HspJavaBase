-- 创建索引
CREATE TABLE t27(
	id INT,
	`name` VARCHAR(32)
);

-- 查询是否有索引
SHOW INDEXES FROM t27;

-- 添加索引
# 1.添加唯一索引
CREATE UNIQUE INDEX id_index ON t27(id);

# 2.添加普通索引
CREATE INDEX id_index ON t27(id); # 方式 1
ALTER TABLE t27 ADD INDEX id_index (id); # 方式 2

-- 如何选择索引
-- 如果某列的值是不重复的，优先选择唯一索引，否则使用普通索引

# 3.添加主键索引
CREATE TABLE t28(
	id INT,
	`name` VARCHAR(32)
);
ALTER TABLE t28 ADD PRIMARY KEY (id);
SHOW INDEXES FROM t28;
