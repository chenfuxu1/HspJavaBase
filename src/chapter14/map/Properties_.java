package chapter14.map;

import java.util.Properties;


/**
 * 1.Properties 继承了 Hashtable
 * 2.可以通过键值对存放数据，key，value 不能为 null，会抛出异常 NullPointException
 */
@SuppressWarnings("all")
public class Properties_ {
	public static void main(String[] args) {
		Properties properties = new Properties();

		// properties.put(null, 100); // 异常 NullPointException
		// properties.put("hh", null); // 异常 NullPointException

		properties.put("john", 100);
		properties.put("lucy", 100);
		properties.put("lie", 100);
		properties.put("lie", 88);
		System.out.println(properties);

		// 通过 key 获取对应的值
		System.out.println(properties.get("lie"));
		System.out.println(properties.getProperty("lie"));

		// 删除元素
		properties.remove("lie");
		System.out.println(properties);

		// 修改元素
		properties.put("john", "Lufei");
		System.out.println(properties);
	}
}
