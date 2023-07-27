# max 和 min 函数
# 1.求班级最高分和最低分（数值范围在统计中特别有用）
SELECT MAX(chinese + english + math) AS '最高分' FROM student;
SELECT MIN(chinese + english + math) AS '最低分' FROM student;

# 2.求出班级数学最高分和最低分
SELECT MAX(math) FROM student;
SELECT MIN(math) FROM student;
SELECT MAX(math) AS '最高分', MIN(math) AS '最低分' FROM student;