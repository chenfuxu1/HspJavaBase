# 数学相关函数
-- 1.ABS(num) 绝对值
-- 2.BIN(decimal_number) 十进制转二进制
-- 3.CEILING(number) 向上取整, 得到比 num 大的最小整数
-- 4.CONV(number, from_base, to_base) 进制转换
-- 5.FLOOR(number) 向下取整, 得到比 num 小的最大整数
-- 6.FORMAT(number, decimal_places) 保留小数位数(四舍五入)
-- 7.HEX(DecimalNumber) 转十六进制
-- 8.LEAST(number, number2, number3....) 求最小值
-- 9.MOD(numerator, denominator) 求余
-- 10.RAND([seed]) RAND([seed])返回随机数，其范围为 0 ≤ v ≤ 1.0

# 1.ABS(num) 绝对值
SELECT ABS(2) FROM DUAL; # 2
SELECT ABS(-2) FROM DUAL; # 2

# 2.BIN(decimal_number) 十进制转二进制
SELECT BIN(8) FROM DUAL; # 1000

# 3.CEILING(number) 向上取整, 得到比 num 大的最小整数
SELECT CEILING(2.1) FROM DUAL; # 3
SELECT CEILING(1.9) FROM DUAL; # 2
SELECT CEILING(-1.2) FROM DUAL; # -1

# 4.CONV(number, from_base, to_base) 进制转换
SELECT CONV(8, 10, 2) FROM DUAL; # 1000, 将 8 由 10 进制转为 2 进制
#下面的含义是 16 是 16 进制的 16, 转成 10 进制输出
SELECT CONV(16, 16, 10) FROM DUAL; # 22
 
# 5.FLOOR(number) 向下取整, 得到比 num 小的最大整数
SELECT FLOOR(2.1) FROM DUAL; # 2
SELECT FLOOR(1.9) FROM DUAL; # 1
SELECT FLOOR(-1.2) FROM DUAL; # -2
 
# 6.FORMAT(number, decimal_places) 保留小数位数(四舍五入)
SELECT FORMAT(123.444, 2) FROM DUAL; # 123.44
SELECT FORMAT(123.448, 2) FROM DUAL; # 123.45

# 7.HEX(DecimalNumber) 转十六进制
SELECT HEX(10) FROM DUAL; # A

# 8.LEAST(number, number2, number3....) 求最小值
SELECT LEAST(5, 7, 2, 9, 8) FROM DUAL; # 2

# 9.MOD(numerator, denominator) 求余
SELECT MOD(5, 3) FROM DUAL; # 5 / 3 余数为 2

#10.RAND([seed]) RAND([seed])返回随机数，其范围为 0 ≤ v ≤ 1.0
-- 1.如果使用rand()每次返回不同的随机数，在 0 ≤ v ≤ 1.0
-- 2. 如果使用rand(seed)返回随机数, 范围 0 ≤ v ≤ 1.0, 
-- 如果 seed 不变，该随机数也不变了
SELECT RAND() FROM DUAL;
SELECT RAND(3) FROM DUAL;
SELECT RAND(5) FROM DUAL;
 