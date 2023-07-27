# 创建一个 db01 数据库
CREATE DATABASE db01;
# 删除数据库 db01
DROP DATABASE db01;
# 创建一个使用 utf8 字符集的 db02 数据库
CREATE DATABASE db02 CHARACTER SET utf8;
# 创建一个使用 utf8 字符集，并带校对规则的db03数据库
CREATE DATABASE db03 CHARACTER SET utf8 COLLATE utf8_bin;
# 校对规则 utf8_bin  区分大小写，默认的 utf8_general_ci 不区分大小写
# 如果指定了校对规则，那么下面的表也遵从这一规则