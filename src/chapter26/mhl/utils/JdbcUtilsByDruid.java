package chapter26.mhl.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 基于 druid 数据库连接池的工具类
 */
public class JdbcUtilsByDruid {
    private static DataSource sDataSource;

    // 在静态代码块中完成 sDataSource 的初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));
            sDataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // getConnection 方法
    public static Connection getConnection() throws SQLException {
        return sDataSource.getConnection();
    }

    /**
     * 关闭连接, 在数据库连接池技术中，close 不是真的断掉连接
     * 而是把使用的 Connection 对象放回连接池
     *
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
