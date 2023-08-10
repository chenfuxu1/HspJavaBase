package chapter26.mhl.domain;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/8/6 20:44
 *
 * 实体类对象，和 employee 员工表对应
 **/
public class Employee {
    private Integer mId;
    private String mEmpId; // 员工号
    private String mName; // 员工姓名
    private String mPwd; // 密码
    private String mJob; // 工作岗位

    public Employee() {
    }

    public Employee(Integer id, String empId, String name, String pwd, String job) {
        mId = id;
        mEmpId = empId;
        mName = name;
        mPwd = pwd;
        mJob = job;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getEmpId() {
        return mEmpId;
    }

    public void setEmpId(String empId) {
        mEmpId = empId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPwd() {
        return mPwd;
    }

    public void setPwd(String pwd) {
        mPwd = pwd;
    }

    public String getJob() {
        return mJob;
    }

    public void setJob(String job) {
        mJob = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "mId=" + mId +
                ", mEmpId='" + mEmpId + '\'' +
                ", mName='" + mName + '\'' +
                ", mPwd='" + mPwd + '\'' +
                ", mJob='" + mJob + '\'' +
                '}';
    }
}
