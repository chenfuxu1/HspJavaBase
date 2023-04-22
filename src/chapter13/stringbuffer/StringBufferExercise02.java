package chapter13.stringbuffer;

import java.util.Scanner;

public class StringBufferExercise02 {
	public static void main(String[] args) {
		/**
		 * 输入商品名称和商品价格，要求打印效果示例, 使用前面学习的方法完成：
		 * 商品名 商品价格
		 *
		 * 手机 123,564.59 比如 价格 3,456,789.88
		 * 要求：价格的小数点前面每三位用逗号隔开, 再输出。
		 * 思路分析
		 * 1.定义一个 Scanner 对象，接收用户输入的价格(String)
		 * 2.希望使用到 StringBuffer 的 insert ，需要将 String 转成 StringBuffer
		 * 3. 然后使用相关方法进行字符串的处理
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入价格：");
		String price = sc.next();
		StringBuffer sb = new StringBuffer(price);
		// 先完成一个最简单的实现 123,564.59
		// 找到小数点的索引，然后在该位置的前 3 位，插入 , 即可
		// int i = sb.lastIndexOf(".");
		// sb = sb.insert(i - 3, ",");
		// 上面的两步需要做一个循环处理,才是正确的
		int i = sb.lastIndexOf(".");
		for(int j = i-3; j > 0; j -= 3){
			sb = sb.insert(j, ',');
		}
		System.out.println(sb);
	}
}
