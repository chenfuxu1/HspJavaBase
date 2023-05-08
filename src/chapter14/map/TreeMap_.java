package chapter14.map;

import java.util.Comparator;
import java.util.TreeMap;


@SuppressWarnings({"all"})
public class TreeMap_ {
    public static void main(String[] args) {
        // 1.使用默认的构造器，创建 TreeMap, 是无序的(也没有排序)
        TreeMap treeMap = new TreeMap();
        treeMap.put("jack", "杰克");
        treeMap.put("tom", "汤姆");
        treeMap.put("kristina", "克瑞斯提诺");
        treeMap.put("smith", "斯密斯");
        treeMap.put("hsp", "韩顺平");
        System.out.println("treeMap = " + treeMap);

        // 2.按照传入的 key(String) 的大小进行排序
        TreeMap treeMap2 = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // return ((String) o2).compareTo((String) o1);

                return ((String) o2).length() - ((String) o1).length();
            }
        });
        treeMap2.put("jack", "杰克");
        treeMap2.put("tom", "汤姆");
        treeMap2.put("kristina", "克瑞斯提诺");
        treeMap2.put("smith", "斯密斯");
        treeMap2.put("hsp", "韩顺平"); // 加入不了
        System.out.println("treeMap2 = " + treeMap2);

        /**
         * 源码
         * 1.传入比较器到 Treemap 的属性
         * public TreeMap(Comparator<? super K> comparator) {
         *     this.comparator = comparator;
         * }
         *
         * 2.执行 TreeMap 的 put 方法
         * 2.1 第一次 put，root 为空
         * Entry<K,V> t = root;
         *  	if (t == null) { // 第一次进入 if
         *  	    compare(key, key); // type (and possibly null) check
         *
         *  	    root = new Entry<>(key, value, null);
         *  	    size = 1;
         *  	    modCount++;
         *  	    return null; // 直接返回
         *      }
         *
         * 2.2 第二次调用put，root 不为空，comparator 不为空，开始比较
         * Comparator<? super K> cpr = comparator;
         * if (cpr != null) {
         *     do {
         *         parent = t;
         *         cmp = cpr.compare(key, t.key); // 动态绑定到匿名内部类，传入比较器的比较规则
         *         if (cmp < 0)
         *             t = t.left;
         *         else if (cmp > 0)
         *             t = t.right;
         *         else
         *             // 如果遍历过程中，发现准备添加 Key 和当前已有的 Key 相等，就不添加
         *             return t.setValue(value);
         *     } while (t != null);
         * }
         *
         * public V put(K key, V value) {
         *     Entry<K,V> t = root;
         *     if (t == null) {
         *         compare(key, key); // type (and possibly null) check
         *
         *         root = new Entry<>(key, value, null);
         *         size = 1;
         *         modCount++;
         *         return null;
         *     }
         *     int cmp;
         *     Entry<K,V> parent;
         *     // split comparator and comparable paths
         *     Comparator<? super K> cpr = comparator;
         *     if (cpr != null) {
         *         do {
         *             parent = t;
         *             cmp = cpr.compare(key, t.key);
         *             if (cmp < 0)
         *                 t = t.left;
         *             else if (cmp > 0)
         *                 t = t.right;
         *             else
         *                 return t.setValue(value);
         *         } while (t != null);
         *     }
         *     else {
         *         if (key == null)
         *             throw new NullPointerException();
         *         @SuppressWarnings("unchecked")
         *             Comparable<? super K> k = (Comparable<? super K>) key;
         *         do {
         *             parent = t;
         *             cmp = k.compareTo(t.key);
         *             if (cmp < 0)
         *                 t = t.left;
         *             else if (cmp > 0)
         *                 t = t.right;
         *             else
         *                 return t.setValue(value);
         *         } while (t != null);
         *     }
         *     Entry<K,V> e = new Entry<>(key, value, parent);
         *     if (cmp < 0)
         *         parent.left = e;
         *     else
         *         parent.right = e;
         *     fixAfterInsertion(e);
         *     size++;
         *     modCount++;
         *     return null;
         * }
         */
    }
}
