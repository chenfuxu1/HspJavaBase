package chapter14.set.linkedhashset;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/7 10:52
 * <p>
 * LinkedHashSet 源码解析
 **/
public class LinkedHashSetSource {
    public static void main(String[] args) {
        /**
         * 1.LinkedHashSet 加入顺序和取出的顺序保持一致
         * 2.LinkedHashSet 底层维护的是一个 LinkedHashMap，是 HashMap 的子类
         * 3.LinkedHashMap 底层结构是 数组 table + 双向链表
         * 4.第一次添加时，直接将数组 table 扩容到 16，存放的节点类型是 LinkedHashMap$Entry
         * 5.数组是 HashMap$Node[] 类型，存放的数据是 LinkedHashMap$Entry，这里是多态数组，
         * LinkedHashMap$Entry 一定继承或实现了 HashMap$Node[]，不然放不进去数组
         * static class Entry<K,V> extends HashMap.Node<K,V> {
         *      Entry<K,V> before, after;
         *      Entry(int hash, K key, V value, Node<K,V> next) {
         *          super(hash, key, value, next);
         *      }
         * }
         */
        Set linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new String("AA"));
        linkedHashSet.add(456);
        linkedHashSet.add(456);
        linkedHashSet.add(new Customer("刘", 55));
        linkedHashSet.add(123);
        linkedHashSet.add("HSP");
        System.out.println("linkedHashSet = " + linkedHashSet);
    }
}

class Customer {
    private String mName;
    private int mAge;

    public Customer(String name, int age) {
        mName = name;
        mAge = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "mName='" + mName + '\'' +
                ", mAge=" + mAge +
                '}';
    }
}