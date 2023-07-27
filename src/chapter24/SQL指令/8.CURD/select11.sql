-- 查询 ecshop 的 ecs_goods 中各个类别中，价格最高的商品
# 1.先得到各个类别中，价格最高的商品, 当做临时表
SELECT cat_id, MAX(shop_price) FROM ecs_goods GROUP BY cat_id;
# 2.查出具体的商品信息
SELECT goods_id, cat_id, goods_name, shop_price FROM ecs_goods;
# 3.临时表子查询
SELECT goods_id, ecs_goods.cat_id, goods_name, shop_price
	FROM (
		SELECT cat_id, MAX(shop_price) AS max_price FROM ecs_goods GROUP BY cat_id
	)  temp, ecs_goods
	WHERE 
		temp.cat_id = ecs_goods.cat_id AND temp.max_price = ecs_goods.shop_price;