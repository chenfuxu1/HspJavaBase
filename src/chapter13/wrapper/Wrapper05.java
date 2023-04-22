package chapter13.wrapper;


/**
 * 面试题
 */
public class Wrapper05 {
	public static void main(String[] args) {
		Integer i = new Integer(1);
		Integer j = new Integer(1);
		System.out.println(i == j); // false ,凡是 new 出的都是不同对象
		// 所以，这里主要是看范围 -128 ~ 127 就是直接返回
		/**
		 * 1. 如果 i 在 IntegerCache.low(-128) ~ IntegerCache.high(127), 就直接从数组返回
		 * 2. 如果不在 -128~127,就直接 new Integer(i)
		 * public static Integer valueOf(int i) {
		 * 		if (i >= IntegerCache.low && i <= IntegerCache.high)
		 * 			return IntegerCache.cache[i + (-IntegerCache.low)];
		 * 		return new Integer(i);
		 */

		Integer m = 1; // 底层 Integer.valueOf(1); -> 阅读源码
		Integer n = 1; // 底层 Integer.valueOf(1);
		System.out.println(m == n); // T
		// 所以，这里主要是看范围 -128 ~ 127 就是直接返回
		// 否则，就 new Integer(xx);
		Integer x = 128; // 底层 new Integer(128);
		Integer y = 128; // 底层 new Integer(128);
		System.out.println(x == y); // False
	}
}
