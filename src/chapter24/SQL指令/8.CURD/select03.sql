# select 练习 3
# % - 表示后面还有任意个(可以为 0)
# _ - 表示有一个任意字符(必须为 1 个)
-- 1.查询姓名为赵云的学生成绩
-- 2.查询英语成绩大于 90 分的同学
-- 3.查询总分大于 200 分的所有同学
-- 4.查询 math 大于 60 并且( and ) id 大于 4 的学生成绩
-- 5.查询英语成绩大于语文成绩的同学
-- 6.查询总分大于 200 分并且数学成绩小于语文成绩的姓赵的学生
-- 7.查询英语分数在 80－90 之间的同学
-- 8.查询数学分数为 89, 90, 91 的同学
-- 9.查询所有姓韩的学生成绩
-- 10.查询数学分 >80，语文分 >80 的同学

# 1.查询姓名为赵云的学生成绩
SELECT * FROM student WHERE `name` = '赵云';

# 2.查询英语成绩大于 90 分的同学
SELECT * FROM student WHERE english > 90;

# 3.查询总分大于 200 分的所有同学
SELECT `name`, (chinese + english + math) AS total_score FROM student WHERE (chinese + english + math) > 200;

# 4.查询 math 大于 60 并且( and ) id 大于 4 的学生成绩
SELECT * FROM student WHERE math > 60 AND `id` > 4;

# 5.查询英语成绩大于语文成绩的同学
SELECT * FROM student WHERE english > chinese;

# 6.查询总分大于 200 分并且数学成绩小于语文成绩的姓赵的学生
SELECT `name`, chinese, math, (chinese + english + math) AS total_score FROM student 
	WHERE (chinese + english + math) > 200 AND math < chinese AND `name` LIKE '赵%';
	
# 7.查询英语分数在 80－90 之间的同学 between 是闭区间，两端都包含
SELECT `name`, english FROM student WHERE english BETWEEN 80 AND 90;

# 8.查询数学分数为 89, 90, 91 的同学
SELECT `name`, math FROM student WHERE math IN (89, 90, 91);

# 9.查询所有姓韩的学生成绩
SELECT * FROM student WHERE `name` LIKE '韩%';

# 10.查询数学分 >80，语文分 >80 的同学
SELECT * FROM student WHERE math > 80 AND chinese > 80;

#课堂练习
#11.查询语文在 70-80 之间的同学
SELECT * FROM student WHERE chinese BETWEEN 70 AND 80;

#12.查询总分为 170, 185, 191 的同学
SELECT `name`, (chinese + english + math) AS total_score FROM student
	WHERE (chinese + english + math) IN (170, 185, 191);

#13.查询所有姓韩或者姓宋的学生成绩
SELECT * FROM student WHERE `name` LIKE '韩%' OR `name` LIKE '宋%';

#14.查询数学比语文多54分的同学
SELECT * FROM student WHERE math = chinese + 54;
