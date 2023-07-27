-- 表的复制
-- 为了对某个 sql 语句进行效率测试，我们需要海量数据时， 
-- 可以使用此法为表创建海量数据
CREATE TABLE my_tab01(
	`id` INT,
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	`sal` DOUBLE NOT NULL DEFAULT 0.0,
	`job` VARCHAR(32),
	deptno INT
);

# 自我复制
# 1.先把 emp2 表的记录复制到 my_tab01
INSERT INTO my_tab01(`id`, `name`, sal, job, deptno)
	SELECT empno, ename, sal, job, deptno FROM emp2;
SELECT * FROM my_tab01; # 完成复制

# 2.进行自我复制
INSERT INTO my_tab01
	SELECT * FROM my_tab01;
SELECT COUNT(*) FROM my_tab01;

-- 如何删除掉一张表重复记录
-- 1. 先创建一张表 my_tab02,
-- 2. 让 my_tab02 有重复的记录
CREATE TABLE my_tab02 LIKE emp2; # 这个语句把 emp2 表的结构(列)，复制到 my_tab02
DESC my_tab02;
INSERT INTO my_tab02 
	SELECT * FROM emp2; #执行3次，有了39行
SELECT * FROM my_tab02;

#3.对my_tab02进行去重
/* 思路
(1) 先创建一张临时表 temp, 该表的结构和 my_tab02 一样
(2) 把 temp 的记录通过 distinct 关键字处理后把记录复制到 temp
(3) 清除掉 my_tab02 记录
(4) 把 temp 表的记录复制到 my_tab02
(5) drop 掉临时表 temp
*/
# 3.1创建临时表
CREATE TABLE temp LIKE my_tab02;
# 3.2将 my_tab02 去重的数据 copy 到 temp 表
INSERT INTO temp
	SELECT DISTINCT * FROM my_tab02;
SELECT * FROM temp; # 得到去重 的 13 行
# 3.3将 my_tab02 数据删除
DELETE FROM my_tab02;
# 3.4将 temp 数据 copy 到 my_tab02
INSERT INTO my_tab02
	SELECT * FROM temp;
SELECT * FROM my_tab02; # 完成去重
# 3.5删除 temp 表
DROP TABLE temp;
#3.2步骤之后也可直接将 temp 表改名为 my_tab02，将原 my_tab02 删除即可

	