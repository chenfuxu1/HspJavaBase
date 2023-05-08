package chapter14.map;

import java.util.HashMap;
import java.util.Map;

public class MapMethod {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超", new Book("", 100)); // OK
        map.put("邓超", "孙俪"); // 替换 -> 一会分析源码
        map.put("王宝强", "马蓉"); // OK
        map.put("宋喆", "马蓉"); // OK
        map.put("刘令博", null); // OK
        map.put(null, "刘亦菲"); // OK
        map.put("鹿晗", "关晓彤"); // OK
        map.put("hsp", "hsp 的老婆");
        System.out.println("map = " + map);

        // 1.remove: 根据键删除映射关系
        map.remove(null);
        System.out.println("map = " + map);

        // 2.get：根据键获取值
        Object val = map.get("鹿晗");
        System.out.println("val = " + val);

        // 3.size: 获取元素个数
        System.out.println("map.size = " + map.size());

        // 4.isEmpty: 判断个数是否为 0
        System.out.println(map.isEmpty()); // F

        // 5.clear: 清除 k-v
        map.clear();
        System.out.println("map = " + map);
        map.put("hsp", "dsa");

        // 6.containsKey: 查找键是否存在
        System.out.println("结果 = " + map.containsKey("hsp")); // T
    }
}

class Book {
    private String name;
    private int num;

    public Book(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
