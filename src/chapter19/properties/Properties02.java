package chapter19.properties;


import java.io.FileOutputStream;
import java.util.Properties;

/**
 * 使用 Properties 类来创建配置文件, 修改配置文件内容
 */
public class Properties02 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        /**
         * 创建
         * 1.如果该文件没有 key 就是创建
         * 2.如果该文件有 key 就是修改
         */
        properties.setProperty("charset", "utf8");
        properties.setProperty("user", "笑容"); // 保存的是 "笑容" 的 unicode 编码
        properties.setProperty("pwd", "12324124");
        // 将 k-v 存储文件中即可
        properties.store(new FileOutputStream("src\\mysql02.properties"), null); // 注释为空
        System.out.println("保存配置文件成功");

        /**
         * Properties 父类是 Hashtable
         * 修改属性源码, 就是 hashtable 的 put 方法
         * 没有就创建, 有就覆盖修改
         *
         * public synchronized V put(K key, V value) {
         *      // Make sure the value is not null
         *      if (value == null) {
         *      	throw new NullPointerException();
         *      }
         *      // Makes sure the key is not already in the hashtable.
         *      Hashtable.Entry<?,?> tab[] = table;
         *      int hash = key.hashCode();
         *      int index = (hash & 0x7FFFFFFF) % tab.length;
         *           @SuppressWarnings("unchecked")
         *           Hashtable.Entr y<K,V> entry = (Hashtable.Entry<K,V>)tab[index];
         *      for(; entry != null ; entry = entry.next) {
         *      	if ((entry.hash == hash) && entry.key.equals(key)) {
         *      		V old = entry.value;
         *      		entry.value = value;
         *      		return old;
         *          }
         *      }
         *      addEntry(hash, key, value, index);
         *      return null;
         * }
         */
    }
}
