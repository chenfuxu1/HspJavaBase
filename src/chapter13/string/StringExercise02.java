package chapter13.string;


public class StringExercise02 {
	public static void main(String[] args) {
		String a = new String("abc");
		String b = new String("abc"); // 只要是 new 的便是不同对象
		System.out.println(a.equals(b)); // String 重写 equals，比较内容是否相同，故 True
		System.out.println(a == b); // 只要是 new 的便是不同对象，故为 false
	}
}
