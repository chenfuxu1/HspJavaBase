# 练习: 备份 db02 和 db03 库中的数据，并恢复
# 备份, 要在 Dos 下执行 mysqldump 指令, 其实是在 mysql 安装目录 \bin 下执行
# 这个备份的文件，就是对应的 sql 语句
mysqldump -u root -p -B db02 db03 > d:\\test\\bak.sql
# 删除 db02 db03 数据库
DROP DATABASE db02;
DROP DATABASE db03;
# 通过 d:\\test\\bak.sql 进行恢复(命令在 Mysql 中执行)
source d:\\test\\bak.sql;
# 第二个恢复方法，直接将 bak.sql 的内容放到查询编辑器中，执行
