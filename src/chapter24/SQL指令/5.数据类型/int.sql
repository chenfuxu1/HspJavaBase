# 演示整型的数值类型
# 使用 tinyint 来演示范围有符号 -128 ~ 127 如果没有符号 0-255
# 说明：表的字符集，校验规则,  存储引擎使用默认
# 如果没有指定 unsinged, 则 TINYINT 就是有符号
# 如果指定 unsinged, 则TINYINT 就是无符号 0-255
# 1.整型 tinyint 有符号
CREATE TABLE t1(
	id TINYINT
);
# INSERT INTO t1 VALUES(-129); 插入失败，最小是 -128
INSERT INTO t1 VALUES(-128); # 插入成功
# INSERT INTO t1 VALUES(128); 插入失败，最大是127
INSERT INTO t1 VALUES(127);  # 插入成功
SELECT * FROM t1;

# 2.创建 tinyint 型无符号的表, 范围 0-255
CREATE TABLE t2(
	id TINYINT UNSIGNED
);
# insert into t2 values(-1); 插入失败，最小是 -128
INSERT INTO t2 VALUES(0);
INSERT INTO t2 VALUES(255);
SELECT * FROM t2;

# 3.创建 bit 型的表
# bit(m) m 在1-64
# 添加数据范围按照你给的位数来确定，比如 m = 8 表示一个字节 0~255
# 显示按照 bit 显示
# 查询时，仍然可以按照数来查询
CREATE TABLE t3(
	num BIT(8)
);
INSERT INTO t3 VALUES(3);
INSERT INTO t3 VALUES(255);
SELECT * FROM t3;
SELECT * FROM t3 WHERE num = 3; # 通过数值来查询

# 4.数值型(小数)的基本使用
# 演示 decimal、float、double 使用
# decimal(M,D) M 表示总位数，默认为10；D 表示小数位数，默认 0
# DECIMAL(30,20) 表示总位数 30 位，小数位数20位
# 创建表
CREATE TABLE t4(
	num1 FLOAT, # 小数默认 4 位
	num2 DOUBLE, # 小数默认 14 位
	num3 DECIMAL(30, 20)
);
# 添加数据
INSERT INTO t4 VALUES(88.123456789123456789, 88.123456789123456789, 88.123456789123456789);
SELECT * FROM t4;

# decimal 可以存放很大的数
CREATE TABLE t5(
	num DECIMAL(65)
);
INSERT INTO t5 VALUES(8999999933338388388383838838383009338388383838383838383);
SELECT * FROM t5;

CREATE TABLE t6(
	num BIGINT UNSIGNED
);
# 插入不了，该数太大超出范围，bigint 最大数是 2^64-1
INSERT INTO t6 VALUES(8999999933338388388383838838383009338388383838383838383);
SELECT * FROM t6;
