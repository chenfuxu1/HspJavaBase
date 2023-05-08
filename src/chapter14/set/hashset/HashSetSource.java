package chapter14.set.hashset;


import java.util.HashSet;

@SuppressWarnings("all")
public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("java"); // 到此位置，第 1 次 add 分析完毕.
        hashSet.add("php"); // 到此位置，第 2 次 add 分析完毕
        hashSet.add("java");
        System.out.println("set = " + hashSet);

        /**
         * 源码解读
         * 1.执行构造器
         * public HashSet() {
         *     map = new HashMap<>();
         * }
         *
         * 2.执行 add 方法
         * public boolean add(E e) {
         *      return map.put(e, PRESENT)==null; // private static final Object PRESENT = new Object();
         * }
         *
         * 3.执行 put 方法，通过 hash(key) 得到对应 key 的 hash 值
         * public V put(K key, V value) {
         *      return putVal(hash(key), key, value, false, true);
         * }
         *
         * static final int hash(Object key) {
         *      int h;
         *      return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
         * }
         *
         * 4.执行 putVal
         * final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
         *     // 定义了辅助变量
         *     Node<K,V>[] tab; Node<K,V> p; int n, i;
         *     // table 是 HashMap 的一个数组，类型是 Node<K,V>[], 第一次已经扩容，容量为 16
         *     if ((tab = table) == null || (n = tab.length) == 0)
         *         n = (tab = resize()).length; // n = 16
         *     // 根据 key = java，得到的 hash，去计算该 key 应该存放在 table 表的那个索引位置
         *     // 因为已经添加过一次 java，所以 hash 是一样的，所以 p 不为空
         *     if ((p = tab[i = (n - 1) & hash]) == null)
         *         tab[i] = newNode(hash, key, value, null);
         *     else {
         *         // p 指向 table 中索引为 java 的节点
         *         Node<K,V> e; K k;
         *         // 1.准备加入的 key 和 p 指向 Node 节点的 key 是同一个对象
         *         // 2.p 指向的 Node 节点的 key 的 equals() 和准备加入的 key 比较后内容相同
         *         // 就不能加入
         *         if (p.hash == hash &&
         *             ((k = p.key) == key || (key != null && key.equals(k))))
         *             e = p;
         *         // 判断 p 是不是一颗红黑树，如果是一颗红黑树，就调用 putTreeVal 来进行添加
         *         else if (p instanceof TreeNode)
         *             e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
         *         else {
         *             // 如果 table 对应索引位置，已经是一个链表，就使用 for 循环比较
         *             // 1.依次和该链表的每一个元素比较后，都不相同，则加到该链表的最后
         *             // 注意在把元素添加到链表后，立即判断该链表是否已经达到 8 个结点
         *             // 就调用 treeifyBin() 对当前这个链表进行树化(转成红黑树)
         *             // 注意，在转成红黑树时，要进行判断, 判断条件
         *             // if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY(64))
         *             //	   resize();
         *             // 如果上面条件成立，先 table 扩容. 只有上面条件不成立时，才进行转成红黑树
         *             // 2.依次和该链表每一个元素比较的过程中，如果有相同情况，就直接break
         *             for (int binCount = 0; ; ++binCount) {
         *                 if ((e = p.next) == null) {
         *                     p.next = newNode(hash, key, value, null);
         *                     if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
         *                         treeifyBin(tab, hash);
         *                     break;
         *                 }
         *                 if (e.hash == hash &&
         *                     ((k = e.key) == key || (key != null && key.equals(k))))
         *                     break;
         *                 p = e;
         *             }
         *         }
         *         if (e != null) { // existing mapping for key
         *             V oldValue = e.value;
         *             if (!onlyIfAbsent || oldValue == null)
         *                 e.value = value;
         *             afterNodeAccess(e);
         *             return oldValue;
         *         }
         *     }
         *     ++modCount;
         *     // 未超过临界值，不扩容
         *     if (++size > threshold)
         *         resize();
         *     afterNodeInsertion(evict);
         *     return null;
         * }
         */
    }
}
