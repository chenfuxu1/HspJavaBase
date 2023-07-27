# 修改表的操作练习
-- 员工表 t15 增加一个 image 列，varchar 类型(要求在 resume 后面)
# 1.增加新列
ALTER TABLE t15 ADD image VARCHAR(255) NOT NULL DEFAULT '' AFTER `resume`;
# 显示表的结构
DESC t15;

# 2.修改 job 列，使其长度的 60
ALTER TABLE t15 MODIFY `job` VARCHAR(60);
DESC t15;

# 3.删除 sex 列
ALTER TABLE t15 DROP `sex`;
DESC t15;

# 4.修改表名为 employee
RENAME TABLE t15 TO employee;
RENAME TABLE employee TO t15; # 再修改回来

# 5.修改表的字符集为 utf8
ALTER TABLE t15 CHARACTER SET utf8;

# 6.列名 name 修改为 user_name
ALTER TABLE t15 CHANGE `name` `user_name` VARCHAR(32);
SELECT * FROM t15;