# 日期时间相关函数
-- 1.CURRENT_DATE() 当前日期
-- 2.CURRENT_TIME( ) 当前时间
-- 3.CURRENT_TIMESTAMP() 当前时间戳
-- 4.NOW() 返回当前时间
-- 5.date(datetime) 返回datetime的日期部分
-- 6.date_add(date, interval d_value d_type) 在 date 中加上日期或时间
-- 7.date_sub(date, interval d_value d_type) 在 date 中减去日期或时间
-- 8.datediff(date1, date2) 两个日期差(结果是天)
-- 9.timediff(date1, date2) 两个时间差(多少小时多少分钟多少秒)

# 1.CURRENT_DATE() 当前日期
SELECT CURRENT_DATE() FROM DUAL;

# 2.CURRENT_TIME( ) 当前时间
SELECT CURRENT_TIME() FROM DUAL;

# 3.CURRENT_TIMESTAMP() 当前时间戳
SELECT CURRENT_TIMESTAMP() FROM DUAL;

# 4.NOW() 返回当前时间
SELECT NOW() FROM DUAL;

# 创建测试表, 信息表
CREATE TABLE mes(
	id INT,
	content VARCHAR(30),
	send_time DATETIME
);

# 添加记录
INSERT INTO mes VALUES(1, '北京新闻', CURRENT_TIMESTAMP());
INSERT INTO mes VALUES(2, '上海新闻', NOW());
INSERT INTO mes VALUES(3, '广州新闻', NOW());
SELECT * FROM mes;

# 5.date(datetime) 返回datetime的日期部分
# 显示所有的新闻信息，发布日期只显示日期，不显示时间
SELECT id, content, DATE(send_time) FROM mes;

# 6.date_add(date, interval d_value d_type) 在 date 中加上日期或时间
# 查询在 10 分钟内发布的内容
# DATE_ADD(send_time, INTERVAL 10 MINUTE) >= NOW() 表示发布时间加上 10 分钟后是否大于当前时间
SELECT * FROM mes WHERE DATE_ADD(send_time, INTERVAL 10 MINUTE) >= NOW();

# 7.date_sub(date, interval d_value d_type) 在 date 中减去日期或时间
# 查询在 10 分钟内发布的内容
# DATE_SUB(NOW(), INTERVAL 10 MINUTE) <= send_time 表示当前时间减去十分钟后是否小于发布的时间
SELECT * FROM mes WHERE DATE_SUB(NOW(), INTERVAL 10 MINUTE) <= send_time;

# 8.datediff(date1, date2) 两个日期差(结果是天)
# 查询 2011-11-11 与 1990-1-1 相差多少天
SELECT DATEDIFF('2011-11-11', '1990-01-01') FROM DUAL;

# 9.timediff(date1, date2) 两个时间差(多少小时多少分钟多少秒)
SELECT TIMEDIFF('2011-11-11 10:10:10', '2011-11-01 10:10:10') FROM DUAL;

# 查询自己活了多少天
SELECT DATEDIFF(NOW(), '1996-03-30') FROM DUAL;
SELECT DATEDIFF(NOW(), '1996-03-30') / 365 FROM DUAL;

# 如果你能活到 80 岁，求出你还能活多少天
# 先算从出生到活到 80 岁的日期 DATE_ADD('1996-03-30', INTERVAL 80 YEAR)
# 然后再将日期减去当前的时间即可
SELECT DATEDIFF(DATE_ADD('1996-03-30', INTERVAL 80 YEAR), NOW()) FROM DUAL;
