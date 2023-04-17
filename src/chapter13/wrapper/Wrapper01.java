package chapter13.wrapper;

public class Wrapper01 {
	public static void main(String[] args) {
		// jdk5 前手动装箱拆箱
		// 手动装箱 int -> Integer
		int n1 = 99;
		Integer i = new Integer(n1); // 方式 1
		Integer i2 = Integer.valueOf(n1); // 方式 2

		// 手动拆箱 Integer -> int
		int ii = i.intValue();

		// jdk5之后，自动装拆箱
		int n2 = 100;
		Integer a = n2; // 自动装箱，底层使用 Integer.valueOf(n2);
		int n3 = a; // 自动拆箱,底层使用 intValue();
	}
}
