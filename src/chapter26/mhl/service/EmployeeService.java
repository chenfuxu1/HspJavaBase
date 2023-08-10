package chapter26.mhl.service;

import chapter26.mhl.dao.EmployeeDao;
import chapter26.mhl.domain.Employee;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/8/6 20:51
 *
 * 该类完成对 employee 表的各种操作(通过调用 EmployeeDao 来完成)
 **/
public class EmployeeService {
    private EmployeeDao mEmployeeDao = new EmployeeDao();

    /**
     * 根据用户 id 和密码返回员工对象
     * 如果数据库中不存在，或者匹配不成功，返回空
     * @param userId 用户 id
     * @param pwd 输入的密码
     * @return
     */
    public Employee getEmployeeByIdAndPwd(String userId, String pwd) {
        if (userId == null || pwd == null) {
            return null;
        }
        String sql = "select * from employee where empId = ? and pwd = md5(?)";
        Employee employee = mEmployeeDao.querySingle(sql, Employee.class, userId, pwd);
        return employee;
    }
}
