# 演示时间相关的类型
# 创建一张表, date, datetime, timestamp
CREATE TABLE t14(
	birthday DATE, -- 年月日
	job_time DATETIME, -- 年月日时分秒
	login_time TIMESTAMP -- 时间戳
		NOT NULL DEFAULT CURRENT_TIMESTAMP
		ON UPDATE CURRENT_TIMESTAMP -- 如果希望自动更新，需要配置
);
INSERT INTO t14(birthday, job_time) VALUES('2023-7-7', '2023-7-8 10:10:10');
SELECT * FROM t14;
# 如果我们更新 t14 表的某条记录，login_time 列会自动的以当前时间进行更新