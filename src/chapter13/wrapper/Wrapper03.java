package chapter13.wrapper;


// 以 Integer 和 String 为例
public class Wrapper03 {
	public static void main(String[] args) {
		// 包装类 Integer -> String
		Integer i = 100; // 自动装箱

		// 方式 1
		String s1 = i + "";

		// 方式 2
		String s2 = i.toString();

		// 方式 3
		String s3 = String.valueOf(i);

		// String - > Integer
		String s4 = "12345";
		// 方式一
		Integer i2 = Integer.parseInt(s4); // 自动装箱
		// 方式二
		Integer i3 = new Integer(s4); // 构造器
		System.out.println(s4);
	}
}
