package chapter25.datasource;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;


/**
 * 测试 druid 的使用
 */
public class Druid_ {
    @Test
    public void testDruid() throws Exception {
        /**
         * 1.加入 Druid jar 包
         * 2.加入配置文件 druid.properties, 将该文件拷贝项目的 src 目录
         * 3.创建 Properties 对象, 读取配置文件
         */
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));
        // 4.创建一个指定参数的数据库连接池，Druid 连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            // 这个方法就是从 DataSource 接口 实现的
            Connection connection = dataSource.getConnection();
            // class com.alibaba.druid.pool.DruidPooledConnection
            // System.out.println(connection.getClass());
            connection.close();
        }
        long end = System.currentTimeMillis();
        // Druid 连接 500000 次数据库耗时：350 ms
        System.out.println("Druid 连接 500000 次数据库耗时：" + (end - start) + " ms");
    }
}
