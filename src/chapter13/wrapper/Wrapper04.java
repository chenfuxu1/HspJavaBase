package chapter13.wrapper;

/**
 * Integer 类和 Character 类的常用方法
 */
public class Wrapper04 {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE); // 最大值
		System.out.println(Integer.MIN_VALUE); // 最小值

		System.out.println(Character.isDigit('a')); // 判断是不是数字
		System.out.println(Character.isLetter('a')); // 判断是不是字母
		System.out.println(Character.isUpperCase('A')); // 判断是不是大写
		System.out.println(Character.isLowerCase('b')); // 判断是不是小写

		System.out.println(Character.isWhitespace(' ')); // 判断是不是空格
		System.out.println(Character.toUpperCase('a')); // 转成大写
		System.out.println(Character.toLowerCase('C')); // 转成小写
	}
}
