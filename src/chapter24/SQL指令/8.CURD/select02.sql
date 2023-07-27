# select 练习 2
-- 1.统计每个学生的总分
-- 2.给所有学生总分加 10 分
-- 3.使用别名表示学生分数
-- 4.在赵云的总分上增加 60%
-- 5.统计关羽的总分
-- 6.使用别名表示学生的数学分数
# 1.统计每个学生的总分
SELECT `name`, (chinese + english + math) FROM student;

# 2.给所有学生总分加 10 分
SELECT `name`, (chinese + english + math + 10) FROM student;

# 3.使用别名表示学生分数
SELECT `name`, (chinese + english + math) AS total_score FROM student;

# 4.在赵云的总分上增加 60%
SELECT `name`, (chinese + english + math) * (1 + 0.6) AS total_score FROM student WHERE `name` = '赵云';

# 5.统计关羽的总分
SELECT `name`, (chinese + english + math) AS total_score FROM student WHERE `name` = '关羽';

# 6.使用别名表示学生的数学分数
SELECT `name`, math AS '数学分数' FROM student;