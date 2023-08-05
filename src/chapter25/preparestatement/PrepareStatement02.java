package chapter25.preparestatement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/7/30 23:10
 *
 * 演示 dml 语句
 **/
public class PrepareStatement02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入姓名：");
        String userName = scanner.nextLine(); // 这里使用 nextLine 方法，回车才会结束，如果使用 next 方法，遇到空格就会结束
        System.out.print("请输入密码：");
        String userPwd = scanner.nextLine();
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
            // 添加数据
            // String sql = "insert into admin2 values(?, ?)";

            // 修改数据
            // String sql = "update admin2 set pwd = ? where name = ?";

            // 删除数据
            String sql = "delete from admin2 where name = ?";

            // 4.获取 PrepareStatement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 5.给 preparedStatement 的 ？号赋值
            preparedStatement.setString(1, userName); // 给第一个 ？号赋值
            // preparedStatement.setString(2, userPwd); // 给第二个 ？号赋值
            int row = preparedStatement.executeUpdate();
            System.out.println(row > 0 ? ("插入成功 row：" + row) : "更新失败");
            // 6.关闭连接
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
