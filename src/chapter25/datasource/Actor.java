package chapter25.datasource;

import java.util.Date;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/8/3 23:45
 *
 * 该类对象用来存储 executeQuery 返回的 ResultSet
 **/
public class Actor {
    private Integer mId;
    private String mName;
    private String mSex;
    private Date mBornDate;
    private String mPhone;

    public Actor() {
    }

    public Actor(Integer id, String name, String sex, Date bornDate, String phone) {
        mId = id;
        mName = name;
        mSex = sex;
        mBornDate = bornDate;
        mPhone = phone;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSex() {
        return mSex;
    }

    public void setSex(String sex) {
        mSex = sex;
    }

    public Date getBornDate() {
        return mBornDate;
    }

    public void setBornDate(Date bornDate) {
        mBornDate = bornDate;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mSex='" + mSex + '\'' +
                ", mBornDate=" + mBornDate +
                ", mPhone='" + mPhone + '\'' +
                '}';
    }
}
