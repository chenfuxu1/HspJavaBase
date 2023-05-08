package chapter14.exercise;

import java.util.TreeSet;


/**
 * 分析 HashSet 和 TreeSet 如何实现去重
 * 1.HashSet
 * hashCode() + equals() 底层通过存入对象，进而运算出一个 hash 值，通过 hash 值
 * 得到对应的索引，如果发现 table 索引所在的位置，没有数据，就直接存放
 * 如果有数据，就进行 equals 遍历比较，比较相同就不加入，不相同就加入在链表后面
 *
 * 2.TreeSet
 * 如果传入了一个 Comparator 比较器，就使用实现的 compare 去重，如果方法返回为 0
 * 就默认为相同的元素，就不添加
 * 如果没有传入一个 Comparator 匿名对象，就以你添加的对象实现了的 Compareable 接口的
 * compareTo 去重，
 * 例如此处没有添加匿名内部类，便用 String 类的 compareTo 方法去重
 */
public class Exercise04 {
	public static void main(String[] args) {
		TreeSet treeSet = new TreeSet();
		treeSet.add("1");
		treeSet.add("2");
		treeSet.add("3");
		treeSet.add("1"); // 加不进去
		System.out.println(treeSet);
	}
}
