package chapter14.map;

import java.util.HashMap;
import java.util.Hashtable;


@SuppressWarnings({"all"})
public class HashMapSource1 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("java", 10); // ok
        map.put("php", 10); // ok
        map.put("java", 20); // 替换 value
        System.out.println("map = " + map);

		/**
		 * 源码解读
		 * 1.执行构造器 new HashMap()
		 * 初始化加载因子 loadFactor = 0.75
		 * HashMap$Node[] table = null
		 *
		 * 2.执行 put 方法
		 * public V put(K key, V value) {
		 *     return putVal(hash(key), key, value, false, true);
		 * }
		 *
		 * 3.执行 hash(key) 方法
		 * static final int hash(Object key) {
		 * 		int h;
		 * 		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
		 * }
		 *
		 * 4.执行 putVal
		 * final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
		 *     // 定义了辅助变量
		 *     Node<K,V>[] tab; Node<K,V> p; int n, i;
		 *     // table 是 HashMap 的一个数组，类型是 Node<K,V>[]
		 *     // 如果底层的 table 为空或 length 为空，就扩容到 16 个长度
		 *     if ((tab = table) == null || (n = tab.length) == 0)
		 *         n = (tab = resize()).length; // n = 16
		 *	   // 取出 hash 值对应的 table 表索引位置的 Node，如果为空，说明该位置没有东西，
		 *	   // 加入数据挂载在此处（第一个元素）
		 *     if ((p = tab[i = (n - 1) & hash]) == null)
		 *         tab[i] = newNode(hash, key, value, null);
		 *     else {
		 *         Node<K,V> e; K k;
		 *         // 如果 table 索引位置 key 的 hash 和新插入 key 的 hash 相同或者
		 * 		   // key 不为空时，table 索引位置 key 与新插入 key 的 equals 方法为真时
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
		 *             // 2.依次和该链表每一个元素比较的过程中，如果有相同情况，就直接 break
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
		 *                 e.value = value; // 改变原有变量值，替换
		 *             afterNodeAccess(e);
		 *             return oldValue;
		 *         }
		 *     }
		 *     ++modCount; // 每增加一个 Node，就 size++
		 *     if (++size > threshold)
		 *         resize(); // size 大于临界值，就扩容
		 *     afterNodeInsertion(evict);
		 *     return null;
		 * }
		 *
		 * 5.如果链表长度没有超过 8，或 table 长度小于 64，不会进行树化，会先进行扩容到 64 之后，才会真正树化
		 * final void treeifyBin(Node<K,V>[] tab, int hash) {
		 * 		int n, index; Node<K,V> e;
		 * 		if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
		 * 			resize();
		 */
    }
}
