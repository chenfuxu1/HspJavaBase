package chapter13.string;


public class StringExercise01 {
	public static void main(String[] args) {
		String a = "abc";
		String b = "abc";
		System.out.println(a.equals(b)); // 都是一个常量池对象地址
		System.out.println(a == b); // 都是一个常量池对象地址
	}
}
