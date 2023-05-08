package chapter14.map;

import java.util.Hashtable;

/**
 * 1.Hashtable 存放的元素时键值对：k - v
 * 2.Hashtable 的键和值都不能为 null，否则会抛出 NullPointException
 * 3.Hashtable 的使用方法基本和 HashMap 一样
 * 4.Hashtable 是线程安全的，HashMap 是线程不安全的
 */
@SuppressWarnings({"all"})
public class Hashtable_ {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();
        table.put("john", 100); // ok

        // table.put(null, 100); // 异常 NullPointException
        // table.put("john", null); // 异常 NullPointException

        table.put("", "aa"); // 键可以为空串
        table.put("tt", ""); // 值可以为空串

        table.put("lucy", 100); // ok
        table.put("lie", 100); // ok
        table.put("lie", 88); // 替换
        table.put("1", 1);
        table.put("2", 1);
        table.put("3", 1);
        table.put("4", 1);
        table.put("5", 1);
        table.put("6", 1);
        table.put("7", 1);
        table.put("8", 1);
        System.out.println("table = " + table);

        /**
         * 1.执行构造器
         * public Hashtable() {
         *      this(11, 0.75f);
         * }
         *
         * public Hashtable(int initialCapacity, float loadFactor) {
         *      if (initialCapacity < 0)
         *          throw new IllegalArgumentException("Illegal Capacity: "+
         *                                             initialCapacity);
         *      if (loadFactor <= 0 || Float.isNaN(loadFactor))
         *          throw new IllegalArgumentException("Illegal Load: "+loadFactor);
         *
         *      if (initialCapacity==0)
         *          initialCapacity = 1;
         *      this.loadFactor = loadFactor;
         *      table = new Entry<?,?>[initialCapacity];
         *      threshold = (int)Math.min(initialCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
         * }
         * 底层有数组 Hashtable$Entry[] 初始化大小为 11
         *
         * 2.临界值 threshold 8 = 11 * 0.75
         * threshold = (int)Math.min(initialCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
         * initialCapacity = 11 loadFactor = 0.75
         *
         * 3.扩容
         * 3.1 执行 addEntry(hash, key, value, index);
         * 3.2
         * private void addEntry(int hash, K key, V value, int index) {
         *     modCount++;
         *
         *     Entry<?,?> tab[] = table;
         *     if (count >= threshold) {
         *         // 超过临界值时，进行扩容
         *         rehash();
         *
         *         tab = table;
         *         hash = key.hashCode();
         *         index = (hash & 0x7FFFFFFF) % tab.length;
         *     }
         *
         *     // Creates the new entry.
         *     @SuppressWarnings("unchecked")
         *     Entry<K, V> e = (Entry<K,V>) tab[index];
         *     tab[index] = new Entry<>(hash, key, value, e);
         *     count++;
         * }
         *
         * 3.3 执行 rehash 进行扩容
         * protected void rehash() {
         *     int oldCapacity = table.length;
         *     Entry<?,?>[] oldMap = table;
         *
         *     // 扩容两倍 + 1
         *     int newCapacity = (oldCapacity << 1) + 1;
         *     if (newCapacity - MAX_ARRAY_SIZE > 0) {
         *         if (oldCapacity == MAX_ARRAY_SIZE)
         *             // Keep running with MAX_ARRAY_SIZE buckets
         *             return;
         *         newCapacity = MAX_ARRAY_SIZE;
         *     }
         *     // 创建了新的 Entry，容量为 newCapacity
         *     Entry<?,?>[] newMap = new Entry<?,?>[newCapacity];
         *
         *     modCount++;
         *     // 计算新的临界值，newCapacity * loadFactor = 23 * 0.75 = 17
         *     threshold = (int)Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
         *     // 将新的 Entry 赋给 table 表
         *     table = newMap;
         *
         *     for (int i = oldCapacity ; i-- > 0 ;) {
         *         for (Entry<K,V> old = (Entry<K,V>)oldMap[i] ; old != null ; ) {
         *             Entry<K,V> e = old;
         *             old = old.next;
         *
         *             int index = (e.hash & 0x7FFFFFFF) % newCapacity;
         *             e.next = (Entry<K,V>)newMap[index];
         *             newMap[index] = e;
         *         }
         *     }
         * }
         */
    }
}
