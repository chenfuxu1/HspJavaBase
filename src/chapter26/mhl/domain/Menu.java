package chapter26.mhl.domain;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/8/7 23:49
 *
 * 这是一个实体类对象，和 menu 菜谱表对应
 **/
public class Menu {
    private Integer mId; // 菜谱编号
    private String mName; // 菜谱名称
    private String mType; // 菜谱种类
    private Double mPrice; // 价格

    public Menu() {
    }

    public Menu(Integer id, String name, String type, Double price) {
        mId = id;
        mName = name;
        mType = type;
        mPrice = price;
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

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
        mPrice = price;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mType='" + mType + '\'' +
                ", mPrice=" + mPrice +
                '}';
    }
}
