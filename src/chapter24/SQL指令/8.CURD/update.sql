-- 演示 update 语句
-- 要求: 在上面创建的 t15 表中修改表中的纪录
-- 1.将所有员工薪水修改为 5000 元。(如果没有带 where 条件，会修改所有的记录，因此要小心)
UPDATE t15  SET salary = 5000;

# 2.将姓名为小妖怪的员工薪水修改为 3000 元
UPDATE t15 SET salary = 3000 WHERE user_name = '小妖怪';

# 3.将老妖怪的薪水在原有基础上增加 1000 元
UPDATE t15 SET salary = salary + 1000 WHERE user_name = '老妖怪';

# 4.可以修改多个列的值
UPDATE t15 SET salary = 7000, job = '厨师长' WHERE user_name = '中妖怪';
SELECT * FROM t15;
