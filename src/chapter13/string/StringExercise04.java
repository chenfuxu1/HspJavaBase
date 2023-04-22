package chapter13.string;

public class StringExercise04{
	public static void main(String[] args) {
		String s1 = "hspedu";
		String s2 = "java";
		String s4 = "java";
		String s3 = new String("java");
		System.out.println(s2 == s3); // 地址不同，F
		System.out.println(s2 == s4); // 都是常量池地址，T
		System.out.println(s2.equals(s3)); // 内容相同，T
		System.out.println(s1 == s2); // 地址不同，F
	}
}
