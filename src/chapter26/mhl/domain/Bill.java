package chapter26.mhl.domain;

import java.util.Date;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/8/8 0:18
 * <p>
 * 这是一个实体类对象，和 bill 账单表对应
 **/
public class Bill {
    private Integer mId; // 编号
    private String mBillId; // 账单号可以按照自己的规则生成 UUID
    private Integer mMenuId; // 菜品编号
    private Integer mNums; // 菜品数量
    private Double mMoney; // 金额
    private Integer mDiningTableId; // 餐桌号
    private Date mBillDate; // 订单日期
    private String mState; // 状态，'未结账'，'已经结账'，'挂单'，'现金'，'支付宝'

    public Bill() {
    }

    public Bill(Integer id, String billId, Integer menuId, Integer nums, Double money, Integer diningTableId,
                Date billDate, String state) {
        mId = id;
        mBillId = billId;
        mMenuId = menuId;
        mNums = nums;
        mMoney = money;
        mDiningTableId = diningTableId;
        mBillDate = billDate;
        mState = state;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getBillId() {
        return mBillId;
    }

    public void setBillId(String billId) {
        mBillId = billId;
    }

    public Integer getMenuId() {
        return mMenuId;
    }

    public void setMenuId(Integer menuId) {
        mMenuId = menuId;
    }

    public Integer getNums() {
        return mNums;
    }

    public void setNums(Integer nums) {
        mNums = nums;
    }

    public Double getMoney() {
        return mMoney;
    }

    public void setMoney(Double money) {
        mMoney = money;
    }

    public Integer getDiningTableId() {
        return mDiningTableId;
    }

    public void setDiningTableId(Integer diningTableId) {
        mDiningTableId = diningTableId;
    }

    public Date getBillDate() {
        return mBillDate;
    }

    public void setBillDate(Date billDate) {
        mBillDate = billDate;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "mId=" + mId +
                ", mBillId='" + mBillId + '\'' +
                ", mMenuId=" + mMenuId +
                ", mNums=" + mNums +
                ", mMoney=" + mMoney +
                ", mDiningTableId=" + mDiningTableId +
                ", mBillDate=" + mBillDate +
                ", mState='" + mState + '\'' +
                '}';
    }
}
