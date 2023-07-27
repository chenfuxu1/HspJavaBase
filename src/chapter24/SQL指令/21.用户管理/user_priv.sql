-- 演示用户权限的管理
# 1.创建用户 fuxu，密码 123，从本地登录
CREATE USER 'fuxu'@'localhost' IDENTIFIED BY '123';
SELECT * FROM mysql.user;

# 2.使用 root 用户创建testdb 数据库，news 表
CREATE DATABASE testdb;
CREATE TABLE news(
	id INT,
	content VARCHAR(32)
);
INSERT INTO news VALUES(1, '吴亦凡入狱'), (2, '李易峰也是'), (3, '马蓉出轨宋哲');
SELECT * FROM news;

# 3.使用 root 用户给 fuxu 用户分配 news 表的查看和添加数据的权限
GRANT SELECT, INSERT
	ON testdb.news
	TO 'fuxu'@'localhost';
	
# 4.在 fuxu 用户的终端查询、插入、更新数据
SELECT * FROM testdb.news; # 生效
INSERT INTO testdb.news VALUES(4, '韩寒写的书'); # 生效
# UPDATE command denied to user 'fuxu'@'localhost' for table 'news'
UPDATE news SET content = '郭小四的小时代' WHERE id = 1; # 不生效

# 5.新增权限
GRANT UPDATE
	ON testdb.news
	TO 'fuxu'@'localhost';
	
# 6.修改 fuxu 用户的密码 为 'abc'
SET PASSWORD FOR 'fuxu'@'localhost' = PASSWORD('abc');

# 7.root 用户回收 fuxu 用户在 testdb.news 的所有权限
REVOKE SELECT, INSERT, UPDATE
	ON testdb.news
	FROM 'fuxu'@'localhost'; # 方式 1
	
REVOKE ALL
	ON testdb.news
	FROM 'fuxu'@'localhost'; # 方式 2
	
# 8.删除 fuxu 用户
DROP USER 'fuxu'@'localhost';
