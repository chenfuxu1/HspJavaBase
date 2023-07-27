# 练习 4 order by使用
# 默认什么都不写是升序 Asc，降序要指定 Desc
-- 1.对数学成绩排序后输出(升序)
-- 2.对总分按从高到低的顺序输出(降序) -- 使用别名排序
-- 3.对姓韩的学生成绩(总分)排序输出(升序) where + order by

# 1.对数学成绩排序后输出(升序)
SELECT * FROM student ORDER BY math;

# 2.对总分按从高到低的顺序输出(降序) -- 使用别名排序
SELECT `name`, (chinese + english + math) AS total_score FROM student ORDER BY total_score DESC;

# 3.对姓韩的学生成绩(总分)排序输出(升序) where + order by
SELECT `name`, (chinese + english + math) AS total_score FROM student WHERE `name` LIKE '韩%' ORDER BY total_score ASC;