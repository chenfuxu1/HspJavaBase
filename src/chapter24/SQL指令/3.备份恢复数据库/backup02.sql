# 备份恢复数据库中的表
# 备份，在 Dos 命令中执行(不是 Mysql 中), 备份 db02 的 t1 到 d:\\test\\bak2.sql
mysqldump -u root -p db02 t1 > d:\\test\\bak2.sql
# 删除 db02 的 t1 表
DROP TABLE t1;
# 恢复，在 mysql 的 db02 数据库中恢复 t1 表
source d:\\test\\bak2.sql;

# 这是一个 ecshop 的数据库，包括 ecshop 所有的表，请导入到 mysql 数据库中 (备份)
# 进入到 mysql 命令行: source ecshop 备份文件路径
source d:\\test\\ecshop.sql;
# 再将 ecshop 整个数据库备份到你的 d:\\F\\ecshop.sql 到 dos 下:
mysqldump -u root -p -B ecshop > d:\\F\\ecshop.sql