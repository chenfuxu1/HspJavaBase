package chapter14.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSource {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1", "韩顺平");
        map.put("no2", "张无忌");
        map.put(new Car(), new Person());

        /**
         * 1.k-v 最后是存放在 Node 中，Entry 只是指向了 Node， HashMap$Node = newNode(hash, key, value, null);
         * 2.k-v 为了方便程序员遍历，会创建 EntrySet 集合，该集合存放的类型为 Entry
         * 而一个 Entry 对象就有 k，v EntrySet<Entry<K, V>>, 即 transient Set<Map.Entry<K,V>> entrySet;
         * 3.entrySet 中定义的类型是 Map.Entry，但实际存放的是 HashMap$Node, 因为 Node
         * static class Node<K,V> implements Map.Entry<K,V> 实现了 Map.Entry 接口
         * 4.这样当把 HashMap$Node 对象存放到 entrySet，就方便遍历，因为 Entry 提供
         * K getKey(); 和 V getValue();
         */
        Set set = map.entrySet();
        System.out.println(set.getClass()); // class java.util.HashMap$EntrySet
        for (Object obj : set) {
            // 运行类型还是存放的 HashMap$Node
            System.out.println(obj.getClass()); // class java.util.HashMap$Node
        }

        // 为了方便遍历，从 Node 取出 K-V
        for (Object o : set) {
            // 先做一个向下转型
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        // 获取所有 key 的集合
        Set set1 = map.keySet();
        // 获取所有 Values 的集合
        Collection values = map.values();

        System.out.println("=========== 输出所有 key =========");
        for (Object o : set1) {
            System.out.println(o);
        }

        System.out.println("=========== 输出所有 value =========");
        for (Object o : values) {
            System.out.println(o);
        }
    }
}


class Car {
}

class Person {
}