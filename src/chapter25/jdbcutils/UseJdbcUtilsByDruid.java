package chapter25.jdbcutils;


import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


/**
 * 测试 druid 的连接池工具类
 */
public class UseJdbcUtilsByDruid {
    @Test
    public void testSelect() {
        System.out.println("使用 druid 方式完成");
        // 1.得到连接
        Connection connection = null;
        // 2.组织一个 sql
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        // 3.创建 PreparedStatement 对象
        try {
            connection = JdbcUtilsByDruid.getConnection();
            System.out.println(connection.getClass()); // 运行类型 com.alibaba.druid.pool.DruidPooledConnection
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1); // 给 ? 号赋值
            // 执行, 得到结果集
            resultSet = preparedStatement.executeQuery();
            // 遍历该结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name"); // getName()
                String sex = resultSet.getString("sex"); // getSex()
                Date bornDate = resultSet.getDate("borndate");
                String phone = resultSet.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + bornDate + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JdbcUtilsByDruid.close(resultSet, preparedStatement, connection);
        }
    }
}
