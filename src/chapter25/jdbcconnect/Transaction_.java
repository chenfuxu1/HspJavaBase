package chapter25.jdbcconnect;


import chapter25.jdbcutils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * 使用事务解决上述问题-模拟经典的转账业务
 */
public class Transaction_ {
    // 没有使用事务
    @Test
    public void noTransaction() {
        // 操作转账的业务
        // 1.得到连接
        Connection connection = null;
        // 2.组织一个 sql
        String sql = "update account set money = money - 100 where id = 100";
        String sql2 = "update account set money = money + 100 where id = 200";
        PreparedStatement preparedStatement = null;
        // 3.创建 PreparedStatement 对象
        try {
            connection = JdbcUtils.getConnection(); // 在默认情况下，connection 是默认自动提交
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行第 1 条 sql
            int i = 1 / 0; // 抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行第 2 条 sql
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }

    // 开始使用事务
    @Test
    public void useTransaction() {
        // 操作转账的业务
        // 1.得到连接
        Connection connection = null;
        // 2.组织一个 sql
        String sql = "update account set money = money - 100 where id = 100";
        String sql2 = "update account set money = money + 100 where id = 200";
        PreparedStatement preparedStatement = null;
        // 3.创建 PreparedStatement 对象
        try {
            connection = JdbcUtils.getConnection(); // 在默认情况下，connection 是默认自动提交
            connection.setAutoCommit(false); // 将自动提交关闭，并开启了事务，此处是回滚点，遇到异常会回滚到此处
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行第 1 条 sql
            int i = 1 / 0; // 抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 执行第 2 条 sql
            connection.commit(); // 这里最后执行完毕才提交事务
        } catch (Exception e) {
            // 捕获到异常时，让其回滚到开启事务的位置
            System.out.println("回滚到事务开启点");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // 关闭资源
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }
}
