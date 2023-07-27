# 字符串相关函数的使用，使用 emp2 表来演示
-- 1.CHARSET(str) 返回字串字符集
-- 2.CONCAT(str [,... ]) 连接字串, 将多个列拼接成一列
-- 3.INSTR(str, substring) 返回 substring 在 str 中出现的位置, 没有返回 0
-- dual 亚元表,系统表可以作为测试表使用
-- 4.UCASE(str) 转换成大写
-- 5.LCASE(str) 转换成小写
-- 6.LEFT(str, length) 从str 中的左边起取 length 个字符
-- 7.RIGHT(str, length) 从 str 中的右边起取 length 个字符
-- 8.LENGTH(str) str长度(按照字节)
-- 9.REPLACE(str, search_str, replace_str)
-- 10.STRCMP (string1 ,string2 ) 逐字符比较两字串大小
-- 11.SUBSTRING (str, position, length)
-- 12.LTRIM (string2 ) RTRIM (string2 ) TRIM(string)

SELECT * FROM emp2;

# 1.CHARSET(str) 返回字串字符集
SELECT CHARSET(ename) FROM emp2; # 都是 utf8 格式

# 2.CONCAT(str [,... ]) 连接字串, 将多个列拼接成一列
SELECT CONCAT(ename, ' 的工作是 ', job) FROM emp2;

# 3.INSTR(str, substring) 返回 substring 在 str 中出现的位置, 没有返回 0
# DUAL 是亚元表, 系统表，可以作为测试表使用
SELECT INSTR('hanshunping', 'ping') FROM DUAL; # 返回 8

# 4.UCASE(str) 转换成大写
SELECT UCASE(ename) FROM emp2;

# 5.LCASE(str) 转换成小写
SELECT LCASE(ename) FROM emp2;

# 6.LEFT(str, length) 从str 中的左边起取 length 个字符
SELECT LEFT('张三李四王五赵六', 3) FROM DUAL; # 张三李

# 7.RIGHT(str, length) 从 str 中的右边起取 length 个字符
SELECT RIGHT('张三李四王五赵六', 2) FROM DUAL; # 赵六

# 8.LENGTH(str) str长度(按照字节)
SELECT LENGTH('张三李四') FROM DUAL; # 12 个字节
SELECT LENGTH('cfx') FROM DUAL; # 3 个字节

# 9.REPLACE(str, search_str, replace_str)
SELECT REPLACE('石昊的打算阿迪王', '石昊', '云曦') FROM DUAL; # 云曦的打算阿迪王
# 在 str 中用 replace_str 替换 search_str
# 如果是 manager 就替换成经理
SELECT REPLACE(job, 'MANAGER', '经理') FROM emp2;

# 10.STRCMP (string1 ,string2 ) 逐字符比较两字串大小
SELECT STRCMP('asp', 'bsp') FROM DUAL; # -1

# 11.SUBSTRING (str, position, length)
# position 是字符串的起始位置(从 1 开始计算)，length 是截取的长度
SELECT SUBSTRING('发生的房间第三', 1, 3) FROM DUAL;  # 发生的

# 12.LTRIM(string2) RTRIM(string2) TRIM(STRING)
# 去除前端空格或后端空格
SELECT LTRIM(' 恢复好说的 ') FROM DUAL; # 恢复好说的 , 去除左边空格
SELECT RTRIM(' 恢复好说的 ') FROM DUAL; #  恢复好说的, 去除右边空格
SELECT TRIM(' 恢复好说的 ') FROM DUAL; # 恢复好说的, 去除两边空格

# 练习：以首字母小写的方式显示所有员工 emp2 表的姓名
#方法 1 先获取所有姓名首字母，并转成小写
SELECT LCASE(LEFT(ename, 1)) FROM emp2;
# 进行拼接首字母之后的字符串, SUBSTRING(ename, 2) 表示截取从位置 2 开始到最后字符位置
SELECT CONCAT(LCASE(LEFT(ename, 1)), SUBSTRING(ename, 2)) FROM emp2;

# 方法 2
SELECT REPLACE(UCASE(ename), SUBSTRING(ename, 1, 1), LCASE(SUBSTRING(ename, 1, 1))) FROM emp2;

# 方法 3
SELECT CONCAT(LCASE(SUBSTRING(ename, 1, 1)), SUBSTRING(UCASE(ename), 2, LENGTH(ename))) AS new_name FROM emp2;
