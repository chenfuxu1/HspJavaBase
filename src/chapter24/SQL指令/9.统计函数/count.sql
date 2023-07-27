# 统计函数的使用 count
-- 1.统计一个班级共有多少学生？
-- 2.统计数学成绩大于 90 的学生有多少个
-- 3.统计总分大于 250 的人数有多少
-- count(*) 和 count(列) 的区别
-- count(*) 返回满足条件的记录的行数	
-- count(列): 统计满足条件的某列有多少个，但是会排除为 null 的情况

# 1.统计一个班级共有多少学生？
SELECT COUNT(*) FROM student;
 
 # 2.统计数学成绩大于 90 的学生有多少个
 SELECT COUNT(*) AS total FROM student WHERE math > 90;
 
 # 3.统计总分大于 250 的人数有多少
 SELECT COUNT(*) AS total FROM student WHERE (chinese + english + math) > 250;
 
 # 4.创建带有 null  的字段
 CREATE TABLE t16(`name` VARCHAR(20));
 INSERT INTO t16 VALUES('张三');
 INSERT INTO t16 VALUES('李四');
 INSERT INTO t16 VALUES('王五');
 INSERT INTO t16 VALUES('赵六');
 INSERT INTO t16 VALUES(NULL);
 SELECT COUNT(*) FROM t16; -- 五条记录
 SELECT COUNT(`name`) FROM t16; -- 四条记录，会排出为空的记录