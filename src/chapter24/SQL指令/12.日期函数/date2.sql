-- 10.year | Month | date(datetime)
-- 11.unix_timestamp(): 返回的是 1970-1-1 到现在的秒数 
-- 12.from_unixtime() 可以把一个 unix_timestamp 秒数(时间戳)，转成指定格式的日期

# 10.year | Month | date(datetime)
SELECT YEAR(NOW()) FROM DUAL;
SELECT MONTH(NOW()) FROM DUAL;
SELECT DAY(NOW()) FROM DUAL;
SELECT MONTH('2013-11-10') FROM DUAL;

# 11.unix_timestamp(): 返回的是 1970-1-1 到现在的秒数
SELECT UNIX_TIMESTAMP() FROM DUAL;
SELECT UNIX_TIMESTAMP() / (60 * 60 * 24 * 365) FROM DUAL;

# 12.from_unixtime() 可以把一个 unix_timestamp 秒数(时间戳)，转成指定格式的日期
SELECT FROM_UNIXTIME(1625153750, '%Y-%m-%d') FROM DUAL; # 2021-07-01
SELECT FROM_UNIXTIME(1689352161, '%Y-%m-%d %H:%i:%s') FROM DUAL; # 2023-07-15
