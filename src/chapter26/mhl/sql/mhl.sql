-- 创建满汉楼数据库
CREATE DATABASE mhl;

-- 1.创建员工表(id, empId, name, pwd, job)
CREATE TABLE employee(
	id INT PRIMARY KEY AUTO_INCREMENT, # 主键自增长
	empId VARCHAR(50) NOT NULL DEFAULT '', # 员工号
	`name` VARCHAR(50) NOT NULL DEFAULT '', # 员工姓名
	pwd VARCHAR(50) NOT NULL DEFAULT '', # 密码
	job VARCHAR(50) NOT NULL DEFAULT '' # 工作岗位
) CHARSET = utf8;

-- 2.添加默认员工
INSERT INTO employee VALUES
	(NULL, '111', '荒天帝', MD5('12345'), '经理'),
	(NULL, '222', '火灵儿', MD5('12345'), '服务员'),
	(NULL, '333', '云曦', MD5('12345'), '收银员'),
	(NULL, '444', '月禅', MD5('12345'), '经理');
	
SELECT * FROM employee;

-- 3.创建餐桌表
CREATE TABLE diningTable(
	id INT PRIMARY KEY AUTO_INCREMENT, # 自增，表示餐桌编号
	state VARCHAR(20) NOT NULL DEFAULT '', # 餐桌状态
	orderName VARCHAR(50) NOT NULL DEFAULT '', # 预定人的姓名
	orderTel VARCHAR(20) NOT NULL DEFAULT '' # 预定号码
) CHARSET = utf8;

-- 4.插入餐桌数据
INSERT INTO diningTable VALUES
	(NULL, '空', '', ''),
	(NULL, '空', '', ''),
	(NULL, '空', '', '');

SELECT * FROM diningTable;

-- 5.创建菜谱表
CREATE TABLE menu(
	id INT PRIMARY KEY AUTO_INCREMENT, # 菜谱编号
	`name` VARCHAR(30) NOT NULL DEFAULT '', # 菜谱名称
	`type` VARCHAR(30) NOT NULL DEFAULT '', # 菜谱种类
	price DOUBLE NOT NULL DEFAULT 0 # 价格
) CHARSET = utf8;

-- 6.插入菜谱数据
INSERT INTO menu VALUES
	(NULL, '八宝饭', '主食', 10),
	(NULL, '叉烧包', '主食', 20),
	(NULL, '宫保鸡丁', '热菜', 30),
	(NULL, '山药鲅鱼', '凉菜', 14),
	(NULL, '银丝卷', '甜食', 9),
	(NULL, '水煮鱼', '热菜', 26),
	(NULL, '甲鱼汤', '汤类', 100),
	(NULL, '鸡蛋汤', '汤类', 16);
	
SELECT * FROM menu;

-- 7.创建账单表
CREATE TABLE bill(
	id INT PRIMARY KEY AUTO_INCREMENT, # 自增主键
	billId VARCHAR(50) NOT NULL DEFAULT '', # 账单号可以按照自己的规则生成 UUID
	menuId INT NOT NULL DEFAULT 0, # 菜品编号，也可以使用外健
	nums INT NOT NULL DEFAULT 0, # 菜品数量
	money DOUBLE NOT NULL DEFAULT 0, # 金额
	diningTableId INT NOT NULL DEFAULT 0, # 餐桌号
	billDate DATETIME NOT NULL, # 订单日期
	state VARCHAR(50) NOT NULL DEFAULT '' # 状态，'未结账'，'已经结账'，'挂单'，'现金'，'支付宝'
) CHARSET = utf8;
SELECT * FROM bill;
