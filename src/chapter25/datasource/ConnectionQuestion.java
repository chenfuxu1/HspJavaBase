package chapter25.datasource;

import chapter25.jdbcutils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

/**
 * 传统方法连接数据库 5000 次，观察耗时 -- 太久，还容易造成数据库坍塌 -> 数据库连接池
 */
public class ConnectionQuestion {
    // 代码连接 mysql 5000 次
    @Test
    public void testCon() {
        // 看看连接 - 关闭 connection 会耗时多久
        long start = System.currentTimeMillis();
        System.out.println("开始连接......");
        for (int i = 0; i < 5000; i++) {
            // 传统的 JDBC 连接方式
            Connection connection = JdbcUtils.getConnection();
            /**
             * 不处理.......
             * 只看连接耗时
             */
            JdbcUtils.close(null, null, connection);
        }
        long end = System.currentTimeMillis();
        System.out.println("传统连接 5000 次数据库耗时：" + (end - start)); // 传统连接 5000 次数据库耗时：12963
    }
}
