package chapter14.map;

import java.util.*;

public class MapFor {
    public static void main(String[] args) {
        // 6 种遍历方式
        Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋喆", "马蓉");
        map.put("刘令博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");

        // 第一组: 先取出所有的 Key, 通过 Key 取出对应的 Value
        Set set = map.keySet();
        for (Object obj : set) { // 增强 for
            System.out.println(obj + " - " + map.get(obj));
        }
        System.out.println("======================");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) { // 迭代器
            Object obj = iterator.next();
            System.out.println(obj + " - " + map.get(obj));

        }
        System.out.println("======================");

        // 第二组：取出所有 values
        Collection values = map.values();
        for (Object obj : values) { // 增强 for
            System.out.println(obj);
        }
        System.out.println("======================");

        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) { // 迭代器
            Object obj = iterator2.next();
            System.out.println(obj);

        }
        System.out.println("======================");

        // 第三组：通过 EntrySet 来获取 k-v
        Set set2 = map.entrySet();
        for (Object obj : set2) { // 增强 for
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("======================");

        Iterator i = set2.iterator();
        while (i.hasNext()) {
            Object next = i.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
