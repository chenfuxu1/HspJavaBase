# 练习 insert 语句
-- 创建一张商品表 goods (id int, goods_name varchar(10), price double);
-- 添加 2 条记录
CREATE TABLE `goods`(
	`id` INT,
	goods_name VARCHAR(10),
	price DOUBLE
);
# 添加数据
INSERT INTO goods VALUES(1, '联想电脑', 5500.0);
INSERT INTO goods VALUES(2, '小杜音响', 1200.5);
SELECT * FROM goods;

# insert 语句的细节
# 1.插入的数据应与字段的数据类型相同。
# 比如把 'abc' 添加到 int 类型会错误
INSERT INTO goods(`id`, goods_name, price) VALUES('abc', 'vivo手机', 1200.5);

# 2.数据的长度应在列的规定范围内，例如：不能将
# 一个长度为 80 的字符串加入到长度为 40 的列中。
INSERT INTO goods(`id`, goods_name, price) VALUES(100, '战三李四分到时间副驾驶的解放军都是就', 5600);

# 3.在 values 中列出的数据位置必须与被加入的列的排列位置相对应。
INSERT INTO goods(id, goods_name, price) -- 不对
	VALUES('vovo手机', 40, 2000);
	
# 4.字符和日期型数据应包含在单引号中。
INSERT INTO goods(id, goods_name, price) VALUES(40, vovo手机, 3000); -- 错误的 vovo 手机应该 'vovo手机'

# 5.列可以插入空值(前提是该字段允许为空) insert into table value(null)
INSERT INTO goods(`id`, goods_name, price) VALUES(102, 'OPPO手机', NULL);

# 6.insert into tab_name (列名..) values (),(),() 形式添加多条记录
INSERT INTO goods(`id`, goods_name, price) VALUES
(103, '冰箱', 2131),
(104, '彩电', 5243),
(105, '投影仪',6423);

# 7.如果是给表中的所有字段添加数据，可以不写前面的字段名称
INSERT INTO goods VALUES(106, '热水壶', 132);

# 8.默认值的使用，当不给某个字段值时，如果有默认值就会添加默认值，否则报错
# 如果某个列没有指定not null, 那么当添加数据时没有给定值，则会默认给 null
# 如果我们希望指定某个列的默认值，可以在创建表时指定
INSERT INTO goods(id, goods_name) VALUES(80, '格力手机');
SELECT * FROM goods;