-- 外键演示 FOREIGN KEY REFERENCES
-- 1.创建主表 my_class
CREATE TABLE my_class(
	id INT PRIMARY KEY, -- 班级编号
	`name` VARCHAR(32) NOT NULL DEFAULT ''
);

-- 2.创建从表
CREATE TABLE my_stu(
	id INT PRIMARY KEY,  # 学生编号
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	class_id INT, # 学生所在班级的编号
	# 下面指定外健关系
	FOREIGN KEY (class_id) REFERENCES my_class(`id`)
);
DESC my_stu;

-- 测试数据
INSERT INTO my_class VALUES(100, 'java'), (200, 'web');
INSERT INTO my_class VALUES(300, 'php');
SELECT * FROM my_class;

INSERT INTO my_stu VALUES(1, 'tom', 100);
INSERT INTO my_stu VALUES(2, 'jack', 200);
INSERT INTO my_stu VALUES(3, 'hsp', 300);
# Cannot add or update a child row: a foreign key constraint fails(`db01`.`my_stu`, CONSTRAINT 
# `my_stu_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `my_class` (`id`))
INSERT INTO my_stu VALUES(4, 'mary', 400); -- 这里会失败...因为 400 班级不存在

INSERT INTO my_stu VALUES(5, 'king', NULL); -- 可以, 外键 没有写 not null
SELECT * FROM my_stu;

-- 一旦建立主外键的关系，数据不能随意删除了
-- 除非先删除 my_stu 的 class_id = 100 的记录之后，才能删除 my_class 的 id = 100
DELETE FROM my_class WHERE id = 100;
