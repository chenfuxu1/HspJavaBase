package chapter26.mhl.domain;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/8/6 21:41
 *
 * 这是一个实体类对象，和 diningTable 餐桌表对应
 **/
public class DiningTable {
    private Integer mId; // 餐桌编号
    private String mState; // 餐桌状态
    private String mOrderName; // 预定人的姓名
    private String mOrderTel; // 预定号码

    public DiningTable() {
    }

    public DiningTable(Integer id, String state, String orderName, String orderTel) {
        mId = id;
        mState = state;
        mOrderName = orderName;
        mOrderTel = orderTel;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getOrderName() {
        return mOrderName;
    }

    public void setOrderName(String orderName) {
        mOrderName = orderName;
    }

    public String getOrderTel() {
        return mOrderTel;
    }

    public void setOrderTel(String orderTel) {
        mOrderTel = orderTel;
    }

    @Override
    public String toString() {
        return "DiningTable{" +
                "mId=" + mId +
                ", mState='" + mState + '\'' +
                ", mOrderName='" + mOrderName + '\'' +
                ", mOrderTel='" + mOrderTel + '\'' +
                '}';
    }
}
