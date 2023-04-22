package chapter13.stringbuffer;

public class StringAndStringBuffer {
	public static void main(String[] args) {
		// String -> StringBuffer
		// 方式1 构造器
		String str = "hello";
		StringBuffer sb = new StringBuffer(str);
		
		// 方式2，append方法
		StringBuffer sb1 = new StringBuffer();
		sb1 = sb1.append(str);
		
		// StringBuffer -> String
		// 方法1，toString
		StringBuffer sb3 = new StringBuffer("hhhhh");
		String string = sb3.toString();

		// 方法2，构造器
		String str2 = new String(sb3);
	}
}
