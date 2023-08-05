package chapter25.myjdbc;


/**
 * 我们规定的 jdbc 接口(方法)
 */
public interface JdbcInterface {
    // 连接
    public Object getConnection();

    // crud
    public void crud();

    // 关闭连接
    public void close();
}
