package chapter25.datasource;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 演示 c3p0 的使用
 */
public class C3P0_ {
    // 方式 1：相关参数，在程序中指定 user、url、password 等
    @Test
    public void testC3p0_01() throws Exception {
        // 1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        // 2.通过配置文件 mysql.properties 获取相关连接的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        // 读取相关的属性值
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        // 给数据源 comboPooledDataSource 设置相关的参数
        // 注意：连接管理是由 comboPooledDataSource 来管理
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        // 设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        // 最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        // 测试连接池的效率, 测试对 mysql 5000 次操作
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            // 这个方法就是从 DataSource 接口 实现的
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0 连接 5000 次数据库耗时：" + (end - start) + " ms");
        // C3P0 连接 5000 次数据库耗时：282 ms
    }

    /**
     * 方式 2 使用配置文件模板来完成
     * 1.将 c3p0 提供的 c3p0.config.xml 拷贝到 src
     * 2.该文件指定了连接数据库和连接池的相关参数
     * @throws SQLException
     */
    @Test
    public void testC3P0_02() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("c3p0_");
        // 测试连接池的效率, 测试对 mysql 5000 次操作
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            // 这个方法就是从 DataSource 接口 实现的
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        // C3P0 连接 5000 次数据库耗时：2906 ms
        System.out.println("C3P0 连接 5000 次数据库耗时：" + (end - start) + " ms");
    }
}
