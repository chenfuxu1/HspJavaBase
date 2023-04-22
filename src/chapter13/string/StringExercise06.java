package chapter13.string;

public class StringExercise06 {
	public static void main(String[] args) {
		String s1 = "hspedu";
		String s2 = "java";
		String s5 =  "hspedujava";
		String s6 = (s1 + s2).intern(); // s1+s2 反生过程在堆区，返回常量池 hspedujava 的地址
		System.out.println(s5 == s6); // 故T
		System.out.println(s5.equals(s6)); // 内容相同，T
	}
}
