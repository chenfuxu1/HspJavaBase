# avg 函数
#1.求一个班级数学平均分？
SELECT AVG(math) FROM student;

# 2.求一个班级总分平均分
SELECT AVG(chinese + english + math) FROM student;