package chapter14.list;

import java.util.ArrayList;
import java.util.List;

public class List01 {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
		// 1.List 集合类中元素有序(即添加顺序和取出顺序一致)、且可重复, 可以重复为 null，重复为 ""
		List list = new ArrayList();
		list.add("jack");
		list.add("tom");
		list.add("mary");
		list.add("hsp");
		list.add("tom");
		list.add(null);
		list.add(null);
		list.add("");
		list.add("");
		System.out.println("list = " + list);
		// 2.List 集合中的每个元素都有其对应的顺序索引，即支持索引
		// 索引是从 0 开始的
		System.out.println(list.get(3)); // hsp
	}
}
