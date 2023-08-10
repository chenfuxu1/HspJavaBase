package chapter26.mhl.domain;


/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/8/10 0:07
 *
 * 多表查询的实体类，与 bill 和 menu 两个表相映射
 *
 * 注意：查询 sql 语句时，sql 中的列名保持一致，因为底层会根据 sql 的列名来找
 * javaBean 中的 setXX 方法进行赋值
 * 所以：
 * 1.如果 setXX 方法中的 xx 和 sql 列名对应不上，会报错，需要保持一致
 * 2.如果多表查询时，sql 字段的列名中有相同的字段该如何处理呢？
 * 可以查询时给列名取别名，然后定义 javaBean 时 setXX 方法与 sql 的别名对应即可
 **/
public class MultiTableBean {
    private Integer mId; // 编号
    private Integer mMenuId; // 菜品编号
    private Integer mNums; // 菜品数量
    private String mName; // 菜谱名称，来自 menu 表
    private String mType; // 菜谱种类，来自 menu 表
    private Double mMoney; // 金额
    private Integer mDiningTableId; // 餐桌号
    private String mState; // 状态，'未结账'，'已经结账'，'挂单'，'现金'，'支付宝'

    public MultiTableBean() {
    }

    public MultiTableBean(Integer id, Integer menuId, Integer nums, String name, String type, Double money, Integer diningTableId, String state) {
        mId = id;
        mMenuId = menuId;
        mNums = nums;
        mName = name;
        mType = type;
        mMoney = money;
        mDiningTableId = diningTableId;
        mState = state;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
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

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
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

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    @Override
    public String toString() {
        return "MultiTableBean{" +
                "mId=" + mId +
                ", mMenuId=" + mMenuId +
                ", mNums=" + mNums +
                ", mName='" + mName + '\'' +
                ", mType='" + mType + '\'' +
                ", mMoney=" + mMoney +
                ", mDiningTableId=" + mDiningTableId +
                ", mState='" + mState + '\'' +
                '}';
    }
}
