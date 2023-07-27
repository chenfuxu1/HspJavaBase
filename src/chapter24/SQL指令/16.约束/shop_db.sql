-- 使用约束的课堂练习
/*
现有一个商店的数据库 shop_db，记录客户及其购物情况，由下面三个表组成：
商品 goods（商品号 goods_id，商品名 goods_name，单价 unitprice，商品类别 category，供应商 provider);
客户 customer（客户号 customer_id, 姓名 name, 住址 address, 电邮 email, 性别 sex, 身份证 card_Id);
购买 purchase（购买订单号 order_id，客户号 customer_id, 商品号 goods_id, 购买数量 nums);
1.每个表的主外健
2.客户的姓名不能为空
3.email 不能重复
4.客户的性别(男|女)枚举
5.单价 unitprice 在 1.0-9999.99 之间 check
*/
# 1.创建数据库 shop_db
CREATE DATABASE shop_db;

# 2.创建商品 goods 表
/*
商品号 goods_id 主键
商品名 goods_name
单价 unitprice 范围在 1.0-9999.99 之间 check
商品类别 category
供应商 provider
*/
CREATE TABLE goods(
	goods_id INT PRIMARY KEY,
	goods_name VARCHAR(60) NOT NULL DEFAULT '',
	unitprice DECIMAL(10, 2) NOT NULL DEFAULT 0 CHECK(unitprice IN (1.0, 9999.99)) ,
	category INT NOT NULL DEFAULT 0,
	provider VARCHAR(60) NOT NULL DEFAULT ''
);
DESC goods;

-- 客户 customer（客户号 customer_id, 姓名 name, 住址 address, 电邮 email, 性别 sex, 身份证 card_Id)
# 3.创建 customer 表 
CREATE TABLE customer(
	customer_id INT PRIMARY KEY,
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	address VARCHAR(60) NOT NULL DEFAULT '',
	email VARCHAR(32) UNIQUE NOT NULL,
	sex ENUM('男', '女') NOT NULL, -- 这里使用枚举类型，是生效的
	card_id CHAR(18)
);
DESC customer;

-- 购买 purchase（购买订单号 order_id，客户号 customer_id, 商品号 goods_id, 购买数量 nums)
# 4.创建 purchase 表
CREATE TABLE purchase(
	order_id INT UNSIGNED PRIMARY KEY,
	customer_id INT NOT NULL DEFAULT 0, -- 外键约束在后
	goods_id INT NOT NULL DEFAULT 0, -- 外键约束在后
	nums INT NOT NULL DEFAULT 0,
	FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
	FOREIGN KEY(goods_id) REFERENCES goods(goods_id)
);
DESC purchase;

