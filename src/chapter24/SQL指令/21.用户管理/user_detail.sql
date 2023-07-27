-- 说明用户管理的细节
# 1.创建用户时，如果不指定 host，则为 %，表示所有的 ip 都有连接的权限
CREATE USER jack;
SELECT `host`, `user` FROM mysql.user;

# 2.可以指定 ip 登录
# create user 'xxx'@'192.168.1.%' 表示用户 'xxx' 在'192.168.1.*' 的 ip 可以登录 mysql
CREATE USER 'smith'@'192.168.1.%';

# 3.删除用户的时候，如果 host 不是 %，需要明确指定 '用户'@'host值'
DROP USER jack; # 等价于 DROP USER 'jack'@'%';

# 4.删除 smith
DROP USER 'smith'@'192.168.1.%';