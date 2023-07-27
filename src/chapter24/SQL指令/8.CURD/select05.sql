# 查询加强
# 使用 where 子句
-- 如何查找 1992.1.1 后入职的员工
-- 说明：在 mysql 中, 日期类型可以直接比较,  需要注意查询格式保持一致
SELECT * FROM emp2;
SELECT * FROM dept;
SELECT * FROM salgrade;

# 1.查找 1992.1.1 后入职的员工
SELECT * FROM emp2 WHERE hiredate > '1992-01-01';

# 2.使用 like 操作符(模糊)
# %: 表示 0 到多个任意字符 
# _: 表示单个任意字符
# 如何显示首字符为 S 的员工姓名和工资?
SELECT ename, sal FROM emp2 WHERE ename LIKE 'S%';
#如何显示第三个字符为大写 O 的所有员工的姓名和工资
SELECT ename, sal FROM emp2 WHERE ename LIKE '__O%'; # 此处有两个 _

# 3.如何显示没有上级的雇员的情况
SELECT * FROM emp2 WHERE mgr IS NULL;

# 4.使用 order by 子句
# 如何按照工资的从低到高的顺序(升序)，显示雇员的信息
SELECT * FROM emp2 ORDER BY sal ASC;
# 按照部门号升序而雇员的工资降序排列, 显示雇员信息
SELECT * FROM emp2 ORDER BY deptno ASC, sal DESC;

