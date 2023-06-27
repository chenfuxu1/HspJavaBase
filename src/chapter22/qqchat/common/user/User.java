package chapter22.qqchat.common.user;

import java.io.Serializable;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/18 23:01
 *
 * 用户对象
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String mUserId; // 用户 id
    private String mPasswd; // 用户密码

    public User() {
    }

    public User(String userId, String passwd) {
        mUserId = userId;
        mPasswd = passwd;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

    public String getPasswd() {
        return mPasswd;
    }

    public void setPasswd(String passwd) {
        mPasswd = passwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "mUserId='" + mUserId + '\'' +
                ", mPasswd='" + mPasswd + '\'' +
                '}';
    }
}
