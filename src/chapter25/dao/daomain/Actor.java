package chapter25.dao.daomain;

import java.util.Date;


/**
 * 该类对象用来存储 executeQuery 返回的 ResultSet
 * Actor 对象和 actor 表的记录对应
 */
public class Actor { // Javabean, POJO, Domain 对象
    private Integer mId;
    private String mName;
    private String mSex;
    private Date mBornDate;
    private String mPhone;

    public Actor() { // 一定要给一个无参构造器，反射需要
    }

    public Actor(Integer id, String name, String sex, Date bornDate, String phone) {
        this.mId = id;
        this.mName = name;
        this.mSex = sex;
        this.mBornDate = bornDate;
        this.mPhone = phone;
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

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getSex() {
        return mSex;
    }

    public void setSex(String sex) {
        this.mSex = sex;
    }

    public Date getBornDate() {
        return mBornDate;
    }

    public void setBornDate(Date bornDate) {
        this.mBornDate = bornDate;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        this.mPhone = phone;
    }
}
