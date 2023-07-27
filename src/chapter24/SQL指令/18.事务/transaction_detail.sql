-- 事务细节
# 1.如果不开启事务，默认情况下，dml 操作是自动提交的，不能回滚
INSERT INTO t29 VALUES(300, 'milan');
SELECT * FROM t29;

# 2.如果一个事务，没有创建保存点，也可以执行 rollback
# 默认回滚到的就是事务开始的状态
START TRANSACTION;
INSERT INTO t29 VALUES(400, 'king');
INSERT INTO t29 VALUES(500, 'scott');
ROLLBACK; # 回滚到的就是事务开始的状态
COMMIT;

# 3.可以在事务还没有提交的时候创建多个保存点

# 4.可以在事务没有提交前，选择回退到对应的保存点

# 5.InnoDB 存储引擎支持事务，MyISAM 不支持

# 6.开启事务的方法
# 方法1：start transaction;
# 方法2：set autocommit = off;

