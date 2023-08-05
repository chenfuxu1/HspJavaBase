package chapter25.dao.test;


import chapter25.dao.dao.ActorDao;
import chapter25.dao.dao.GoodsDao;
import chapter25.dao.daomain.Actor;
import chapter25.dao.daomain.Goods;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDAO {
    // 测试 actor
    @Test
    public void testActorDao(){
        ActorDao actorDao = new ActorDao();
        // 1.查询多行
        String sql = "select * from actor where id >= ?";
        List<Actor> actors = actorDao.queryMulti(sql, Actor.class, 1);
        System.out.println("=====查询结果======");
        for (Actor actor : actors) {
            System.out.println(actor);
        }

        // 2.查询单行记录
        String sql2 = "select * from actor where id = ?";
        Actor actor = actorDao.querySingle(sql2, Actor.class, 1);
        System.out.println("======查询单行======");
        System.out.println(actor);

        // 3.查询单行单列
        String sql3 = "select name from actor where id = ?";
        Object obj = actorDao.queryScalar(sql3, 1);
        System.out.println("====单行单列====");
        System.out.println(obj);

        // 4.dml 操作 insert, update, delete
        String sql4 = "update actor set name = ? where id = ?";
        int i = actorDao.update(sql4, "张无忌", 2);
        System.out.println(i > 0 ? "dml成功" : "dml失败");
    }

    // 测试 goods 表
    @Test
    public void testGoodsDao(){
        GoodsDao goodsDao = new GoodsDao();
        // 1.查询多行
        String sql = "select * from goods where id >= ?";
        List<Goods> goods = goodsDao.queryMulti(sql, Goods.class, 1);
        System.out.println("=====查询结果======");
        for (Goods good : goods) {
            System.out.println(good);
        }

        // 2.查询单行记录
        String sql2 = "select * from goods where id = ?";
        Goods good1 = goodsDao.querySingle(sql2, Goods.class, 10);
        System.out.println("======查询单行======");
        System.out.println(good1);

        // 3.查询单行单列
        String sql3 = "select goods_name from goods where id = ?";
        Object obj = goodsDao.queryScalar(sql3, 10);
        System.out.println("======查询单行单列======");
        System.out.println(obj);

        // 4.dml 操作 insert, update, delete
        String sql4 = "insert into goods values(?, ?, ?)";
        int i = goodsDao.update(sql4, 90, "熊猫手机", 6000);
        System.out.println(i > 0 ? "dml成功" : "dml失败");
    }
}
