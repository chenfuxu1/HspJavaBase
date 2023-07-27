-- 设置隔离级别
# 1.查看当前会话的隔离级别
SELECT @@tx_isolation;

# 2.查看系统当前的隔离级别
SELECT @@global.tx_isolation;

# 3.设置当前会话的隔离级别
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

# 4.设置系统当前的隔离级别
SET GLOBAL TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

# 5.默认的隔离级别 repeatable read，一般情况下满足要求，无需修改
