# 演示字符串类型使用 char varchar
# 注释的快捷键 shift+ctrl+c , 注销注释 shift+ctrl+r
-- CHAR(size)
-- 固定长度字符串最大 255 字符
-- VARCHAR(size) 0~65535 字节
-- 可变长度字符串最大 65532 字节 (utf8 编码最大 21844 字符 1-3 个字节用于记录大小)
-- utf8 编码一个字符占用三个字节，gbk 一个字符占用两个字节
-- 65535-3 是保留一到三个字节用于记录数据大小
-- 如果表的编码是 utf8 varchar(size) size = (65535-3) / 3 = 21844
-- 如果表的编码是 gbk varchar(size) size = (65535-3) / 2 = 32766
# 1.创建 char
CREATE TABLE t7(
	`name` CHAR(255)
);

# 创建成功
CREATE TABLE t8(
	`name` VARCHAR(21843)
);

# 创建失败，超出范围
CREATE TABLE t9(
	`name` VARCHAR(21845)
);

# 2.创建 varcahr 类型的表，并设置编码格式 gbk
CREATE TABLE t10(
	`name` VARCHAR(32766)
) CHARSET gbk;

# 3.字符串类型的使用细节
# char(4) 和 varchar(4) 这个 4 表示的是字符，而不是字节,
# 不区分字符是汉字还是字母
CREATE TABLE t11(
	`name` CHAR(4)
)
INSERT INTO t11 VALUES('张三李四');
INSERT INTO t11 VALUES('张三李四无'); # 插入失败，超出范围
SELECT * FROM t11;

CREATE TABLE t12(
	`name` VARCHAR(4)
);
INSERT INTO t12 VALUES('张三李四');
INSERT INTO t12 VALUES('ab李四'); # 都是存放 4 个字符
SELECT * FROM t12;

# 4.如果 varchar 不够用，可以使用 mediumtext 或者 longtext,
# 如果想简单点，可以使用直接使用 text
# 创建 text，默认是 2^16 个字节
CREATE TABLE t13(
	content1 TEXT,
	content2 MEDIUMTEXT,
	content3 LONGTEXT
);
INSERT INTO t13 VALUES('发发斯蒂芬', '大师的撒的防守打法打算', '分到时间方女士的粉红色的会发生');
INSERT INTO t13 VALUES('发', '大', '分');
SELECT * FROM t13;
