-- 创建临时数据库
CREATE DATABASE tmp;

# 创建部门表
CREATE TABLE dept(
	deptno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,
	dname VARCHAR(20) NOT NULL DEFAULT "",
	loc VARCHAR(13) NOT NULL DEFAULT ""
) ;

# 创建表 EMP 雇员
CREATE TABLE emp(
	empno  MEDIUMINT UNSIGNED  NOT NULL  DEFAULT 0, /*编号*/
	ename VARCHAR(20) NOT NULL DEFAULT "", /*名字*/
	job VARCHAR(9) NOT NULL DEFAULT "", /*工作*/
	mgr MEDIUMINT UNSIGNED NOT NULL DEFAULT 0, /*上级编号*/
	hiredate DATE NOT NULL, /*入职时间*/
	sal DECIMAL(7,2) NOT NULL, /*薪水*/
	comm DECIMAL(7,2) NOT NULL, /*红利*/
	deptno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0 /*部门编号*/
) ;

# 工资级别表
CREATE TABLE salgrade(
	grade MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,
	losal DECIMAL(17,2) NOT NULL,
	hisal DECIMAL(17,2) NOT NULL
);

# 测试数据
INSERT INTO salgrade VALUES (1, 700, 1200);
INSERT INTO salgrade VALUES (2, 1201, 1400);
INSERT INTO salgrade VALUES (3, 1401, 2000);
INSERT INTO salgrade VALUES (4, 2001, 3000);
INSERT INTO salgrade VALUES (5, 3001, 9999);

DELIMITER $$

# 创建一个函数，名字 rand_string，可以随机返回我指定的个数字符串
CREATE FUNCTION rand_string(n INT)
RETURNS VARCHAR(255) # 该函数会返回一个字符串
BEGIN
# 定义了一个变量 chars_str，类型  varchar(100)
# 默认给 chars_str 初始值  'abcdefghijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUVWXYZ'
DECLARE chars_str VARCHAR(100) DEFAULT 'abcdefghijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUVWXYZ'; 
DECLARE return_str VARCHAR(255) DEFAULT '';
DECLARE i INT DEFAULT 0; 
	WHILE i < n DO
	# concat 函数 : 连接函数 mysql 函数
	SET return_str = CONCAT(return_str, SUBSTRING(chars_str, FLOOR(1 + RAND() * 52), 1));
	SET i = i + 1;
	END WHILE;
	RETURN return_str;
 END $$


# 这里我们又自定了一个函数, 返回一个随机的部门号
CREATE FUNCTION rand_num( )
RETURNS INT(5)
BEGIN
DECLARE i INT DEFAULT 0;
SET i = FLOOR(10 + RAND() * 500);
RETURN i;
END $$

# 创建一个存储过程，可以添加雇员
CREATE PROCEDURE insert_emp(IN START INT(10), IN max_num INT(10))
BEGIN
DECLARE i INT DEFAULT 0;
# set autocommit =0 把 autocommit 设置成 0
# autocommit = 0 含义: 不要自动提交
SET autocommit = 0; # 默认不提交 sql 语句
REPEAT
SET i = i + 1;
# 通过前面写的函数随机产生字符串和部门编号，然后加入到 emp 表
INSERT INTO emp VALUES ((START+i), rand_string(6), 'SALESMAN', 0001, CURDATE(), 2000, 400, rand_num());
UNTIL i = max_num
END REPEAT;
# commit 整体提交所有 sql 语句，提高效率
COMMIT;
END $$

# 添加 8000000 数据
CALL insert_emp(100001,8000000)$$

# 命令结束符，再重新设置为;
DELIMITER ;


-- 在没有创建索引时，测试查询一条记录耗时
SELECT * FROM emp WHERE empno = 1234567; # 耗时 2.785 s

-- 创建索引优化
-- empno_index 表示索引名称，ON emp(empno) 表示在 emp 表的 empno 列上创建索引
-- 创建索引后 emp.ibd 文件变大，因为索引本身占内存
-- 创建索引后，只会对创建索引的列生效
CREATE INDEX empno_index ON emp(empno); # 耗时 11.54 s

-- 在创建索引后，测试查询一条记录耗时
SELECT * FROM emp WHERE empno = 1234568; # 0.005 s
