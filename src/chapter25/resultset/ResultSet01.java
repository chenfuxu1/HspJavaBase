package chapter25.resultset;

import java.io.FileInputStream;

import java.sql.*;
import java.util.Properties;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/7/29 14:37
 **/
public class ResultSet01 {
    public static void main(String[] args) {
        try {
            // 1.通过 properties 获取配置信息
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driver = properties.getProperty("driver");
            // 2.加载 Driver 类
            Class.forName(driver);
            // 3.获取连接
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "select * from actor";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // 4.遍历结果集
                int id = resultSet.getInt(1); // 第一列
                String name = resultSet.getString(2); // 第二列
                String sex = resultSet.getString(3); // 第三列
                Date date = resultSet.getDate(4); // 第四列
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
            }
            // 5.关闭连接
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
