package chapter14.set.treeset;

import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings({"all"})
public class TreeSet_ {
    public static void main(String[] args) {
        // 1.使用无参构造器，默认排序时无序的
        TreeSet treeSet = new TreeSet();
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("bp");
        treeSet.add("a");
        System.out.println("treeSet = " + treeSet);

        // 2.希望添加的元素按照字符串大小进行排序
        // 3.使用TreeSet的有参构造器，传入一个比较器（匿名内部类）
        // 并制定排序规则
        TreeSet treeSet2 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // 调用 String 的 compareTo 方法进行比较
                // return ((String) o2).compareTo((String) o1);

                // 按照字符串长度比较
                return ((String) o2).length() - ((String) o1).length();
            }
        });

        treeSet2.add("jack");
        treeSet2.add("tom"); // 3
        treeSet2.add("bp");
        treeSet2.add("a");
        treeSet2.add("abc"); // 长度为 3，加不进去，比较时为 3 直接返回
        System.out.println("treeSet2 = " + treeSet2);

        /**
         * 源码解读
         * 1.把比较器 comparator 传给了底层 Treemap
         * public TreeSet(Comparator<? super E> comparator) {
         *     this(new TreeMap<>(comparator));
         * }
         *
         * 2.把比较器 comparator 传给了 TreeMap 的属性
         * public TreeMap(Comparator<? super K> comparator) {
         *     this.comparator = comparator;
         * }
         *
         * 3.调用 add 方法时，底层会执行到
         * 3.1
         * public boolean add(E e) {
         *     return m.put(e, PRESENT)==null;
         * }
         *
         * 3.2调用 TreeMap 的 put 方法
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
         *             cmp = cpr.compare(key, t.key); // cpr 是传入的比较器，此时会跳转到匿名内部类的比较规则，动态绑定
         *             if (cmp < 0)
         *                 t = t.left;
         *             else if (cmp > 0)
         *                 t = t.right;
         *             else
         *                 return t.setValue(value); // 如果相等，数据添加不了，返回
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
