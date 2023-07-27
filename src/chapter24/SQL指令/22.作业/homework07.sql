-- 8.设学校环境如下: 一个系有若干个专业，每个专业一年只招一个班，每个班有若干个学生。
-- 现要建立关于系、学生、班级的数据库，关系模式为:
-- 班 CLASS (班号 classid，专业名 subject，系名 deptname，入学年份 enrolltime，人数 num)
-- 学生 STUDENT (学号 studentid，姓名 name，年龄 age，班号 classid)
-- 系 DEPARTMENT(系号 departmentid，系名 deptname)试用 SQL 语言完成以下功能
-- 1.建表，在定义中要求声明:
# 1.1每个表的主外码
# 1.2 deptname 是唯一约束
# 1.3学生姓名不能为空

-- 2.插入如下数据
-- DEPARTMENT (001, 数学; 002, 计算机; 003, 化学; 004, 中文; 005, 经济;)

-- 3.完成以下查询功能
# 3.1找出所有姓李的学生
# 3.2列出所有开设超过 1 个专业的系的名字
# 3.3列出人数大于等于 30 的系的编号和名字

-- 4.学校又新增加了一个物理系，编号为 006
-- 5.学生张三退学，请更新相关的表

-- 1.创建表
CREATE TABLE department(
	departmentid VARCHAR(32) PRIMARY KEY,
	deptname VARCHAR(32) UNIQUE NOT NULL
);

CREATE TABLE class(
	classid INT PRIMARY KEY,
	`subject` VARCHAR(60) NOT NULL DEFAULT '',
	deptname VARCHAR(32) NOT NULL DEFAULT '',
	enrolltime INT NOT NULL DEFAULT 2000,
	num INT NOT NULL DEFAULT 0,
	FOREIGN KEY(deptname) REFERENCES department (deptname)
);

CREATE TABLE student2(
	studentid INT PRIMARY KEY,
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	age INT NOT NULL DEFAULT 0,
	classid INT NOT NULL DEFAULT 0,
	FOREIGN KEY (classid) REFERENCES class(classid)
);

-- 2. 添加测试数据
INSERT INTO department VALUES('001', '数学');
INSERT INTO department VALUES('002', '计算机');
INSERT INTO department VALUES('003', '化学');
INSERT INTO department VALUES('004', '中文');
INSERT INTO department VALUES('005', '经济');

INSERT INTO class VALUES
	(101, '软件', '计算机', 1995, 20),
	(102, '微电子', '计算机', 1996, 30),
	(111, '无机化学', '化学', 1995, 29),
	(112, '高分子化学', '化学', 1996, 25),
	(121, '统计数学', '数学', 1995, 20),
	(131, '现代语言', '中文', 1996, 20),
	(141, '国际贸易', '经济', 1997, 30),
	(142, '国际金融', '经济', 1997, 20);
	
INSERT INTO student2 VALUES
	(8101, '张三', 18, 101),
	(8102, '钱四', 16, 121),
	(8103, '王玲', 17, 131),
	(8105, '李飞', 19, 102),
	(8109, '赵四', 18, 141),
	(8110, '李可', 20, 142),
	(8201, '张飞', 18, 111),
	(8302, '周瑜', 16, 112),
	(8203, '王亮', 17, 111),
	(8305, '董庆', 19, 102),
	(8409, '赵龙', 18, 101);
	
# 3.1找出所有姓李的学生
SELECT * FROM student2 WHERE `name` LIKE '李%';

# 3.2列出所有开设超过 1 个专业的系的名字
SELECT deptname, COUNT(deptname) 
	FROM class
	GROUP BY deptname
	HAVING COUNT(deptname) > 1;
	
# 3.3列出人数大于等于 30 的系的编号和名字
SELECT departmentid, department.deptname, SUM(num) AS '总人数'
	FROM department, class
	WHERE department.deptname = class.deptname
	GROUP BY department.deptname
	HAVING SUM(num) >= 30; # 方式 1

SELECT temp.*, department.departmentid
	FROM department, (
		SELECT SUM(num) AS nums, deptname
			FROM class
			GROUP BY deptname
			HAVING nums >= 30
	) temp
	WHERE department.deptname = temp.deptname; # 方法 2
	
-- 4.学校又新增加了一个物理系，编号为 006
INSERT INTO department VALUES('006', '物理系');

-- 5.学生张三退学，请更新相关的表
# 5.1 张三所在班级人数减 1
# 5.2 将张三从学生表删除
# 5.3 需要事务控制

START TRANSACTION;
# 5.1 张三所在班级人数减 1
UPDATE class SET num = num - 1
	WHERE classid = (
		SELECT classid FROM student2 WHERE `name` = '张三'
	);
	
# 5.2 将张三从学生表删除
DELETE FROM student2 WHERE `name` = '张三';
COMMIT;

SELECT * FROM department
SELECT* FROM class
SELECT * FROM student2
