package chapter25.myjdbc;


/**
 * 测试入口
 */
public class TestJDBC {
    public static void main(String[] args) {
        // 完成对 mysql 的操作
        JdbcInterface jdbcInterface = new MysqlJdbcImpl();
        jdbcInterface.getConnection(); // 通过接口来调用实现类(动态绑定)
        jdbcInterface.crud();
        jdbcInterface.close();

        // 完成对 oracle 的操作
        System.out.println("==============================");
        jdbcInterface = new OracleJdbcImpl();
        jdbcInterface.getConnection(); // 通过接口来调用实现类(动态绑定)
        jdbcInterface.crud();
        jdbcInterface.close();
    }
}
