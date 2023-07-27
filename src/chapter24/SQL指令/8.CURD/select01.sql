# 练习单表查询 1
# 1.创建 student 表
CREATE TABLE student(
	id INT NOT NULL DEFAULT 1,
	`name` VARCHAR(20) NOT NULL DEFAULT '',
	`chinese` FLOAT NOT NULL DEFAULT 0.0,
	`english` FLOAT NOT NULL DEFAULT 0.0,
	`math` FLOAT NOT NULL DEFAULT 0.0
);

#2.插入数据
INSERT INTO student(id, `name`, chinese, english, math) VALUES(1, '韩顺平', 89, 78, 90);
INSERT INTO student(id, `name`, chinese, english, math) VALUES(2, '张飞', 67, 98, 56);
INSERT INTO student(id, `name`, chinese, english, math) VALUES(3, '宋江', 87, 78, 77);
INSERT INTO student(id, `name`, chinese, english, math) VALUES(4, '关羽', 88, 98, 90);
INSERT INTO student(id, `name`, chinese, english, math) VALUES(5, '赵云', 82, 84, 67);
INSERT INTO student(id, `name`, chinese, english, math) VALUES(6, '欧阳锋', 55, 85, 45);
INSERT INTO student(id, `name`, chinese, english, math) VALUES(7, '黄蓉', 75, 65, 30);
INSERT INTO student(id, `name`, chinese, english, math) VALUES(8, '韩信', 45, 65, 99);

# 3.查询表中所有的数据
SELECT * FROM student;

#4.查询表中所有学生的姓名和对应的英语成绩
SELECT `name`, english FROM student;

# 5.过滤表中重复数据 distinct , 要查询的记录，每个字段都相同，才会去重
SELECT DISTINCT english FROM student;

# 如果是下面这种情况，不会去重，因为每个 name 都不相同
SELECT DISTINCT `name`, english FROM student;