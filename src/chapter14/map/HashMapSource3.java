package chapter14.map;

import java.util.HashMap;

public class HashMapSource3 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        // 因为 i 不同，所以会均分在不同的 table 索引位置
        // 添加 12 个元素
        for (int i = 1; i <= 12; i++) {
            hashMap.put(i, "hello");
        }

        // 添加第 13 个元素时，到达临界值，扩容到 32，临界值为 24
        hashMap.put("aaa", "bbb");

        // 添加到 24 个元素
        for (int i = 14; i <= 24; i++) {
            hashMap.put(i, "hello");
        }

        // 添加第 25 个元素，到达临界值，开始扩容到 64，临界值为 48
        hashMap.put("aa", "bb");
        System.out.println("hashMap = " + hashMap); // 12 个 k-v
    }
}
