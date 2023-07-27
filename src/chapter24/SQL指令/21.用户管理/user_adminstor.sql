-- MySql 用户管理
-- 原因：项目开发时，可以根据不同人员拥有不同的权限
-- 所以，MySql 数据库管理人员(root)，根据需要创建不同的用户，赋予相应的权限，供人员使用

# 1.创建新的用户
# 'cfx'@'localhost' 表示用户的完整信息，'cfx'  表示用户名；'localhost' 表示登录 ip；'12345' 表示密码
# 存放到 mysql.user 表时，是 password('12345') 加密后的密码
CREATE USER 'cfx'@'localhost' IDENTIFIED BY '12345';
SELECT PASSWORD('12345') FROM DUAL; # *00A51F3F48415C7D4E8908980D443C29C69B60C9
SELECT `host`, `user`, `authentication_string` FROM mysql.user;

# 2.删除用户
DROP USER 'cfx'@'localhost';

# 3.修改自己的密码
SET PASSWORD = PASSWORD('abcde');

# 4.root 用户修改 'cfx'@'localhost' 的密码
SET PASSWORD FOR 'cfx'@'localhost' = PASSWORD('abcde');
