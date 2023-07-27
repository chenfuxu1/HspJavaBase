# 1.删除表中名称为 ’老妖怪’ 的记录
DELETE FROM t15 WHERE user_name = '老妖怪';

# 2.删除表中所有记录，一定要小心
DELETE FROM t15;

# 3.Delete 语句不能删除某一列的值(可使用update设为 null 或者'')
UPDATE t15 SET job = '', `resume` = NULL WHERE user_name = '老妖怪';
SELECT * FROM t15;

# 4.要删除这个表
DROP TABLE t15;