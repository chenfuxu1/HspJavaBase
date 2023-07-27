-- 删除索引
SHOW INDEXES FROM t27;
DROP INDEX id_index ON t27;

-- 删除主键索引
SHOW INDEXES FROM t28;
ALTER TABLE t28 DROP PRIMARY KEY;

-- 修改索引(先删除，再添加索引)

-- 查询索引
# 方式 1
SHOW INDEX FROM t27;

# 方式 2
SHOW INDEXES FROM t28;

# 方式 3
SHOW KEYS FROM t27;

# 方式 4
DESC t28;