package chapter25.dao.daomain;


/**
 * 该类对象用来存储 executeQuery 返回的 ResultSet
 * Goods 对象和 Goods 表的记录对应
 */
public class Goods {
    private Integer mId;
    private String mGoodsName;
    private Double mPrice;

    public Goods() { // 一定要给一个无参构造器，反射需要
    }

    public Goods(Integer id, String goodsName, Double price) {
        this.mId = id;
        this.mGoodsName = goodsName;
        this.mPrice = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "mId=" + mId +
                ", mGoodsName='" + mGoodsName + '\'' +
                ", mPrice=" + mPrice +
                '}';
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        this.mId = id;
    }

    public String getGoodsName() {
        return mGoodsName;
    }

    public void setGoodsName(String goodsName) {
        this.mGoodsName = goodsName;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
        this.mPrice = price;
    }
}
