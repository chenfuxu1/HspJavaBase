# sum 函数，统计某一列所有的值的和
# 1.统计一个班级数学总成绩？
SELECT SUM(math) FROM student;

# 2.统计一个班级语文、英语、数学各科的总成绩
SELECT SUM(chinese), SUM(english), SUM(math) FROM student;

# 3.统计一个班级语文、英语、数学的成绩总和
SELECT SUM(chinese + english + math) FROM student;

# 4.统计一个班级语文成绩平均分
SELECT SUM(chinese) / COUNT(math) FROM student;

 # 类型错误，只对数值类型生效
SELECT SUM(`name`) FROM student;