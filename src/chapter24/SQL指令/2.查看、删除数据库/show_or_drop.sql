# 查看当前数据库服务器中的所有数据库
SHOW DATABASES;
# 查看前面创建的 db01 数据库的定义信息
SHOW CREATE DATABASE db01;
# 在创建数据库, 表的时候，为了规避关键字，可以使用反引号解决
CREATE DATABASE `CREATE`;
# 删除前面创建的 CREATE 数据库
DROP DATABASE `CREATE`;
