package chapter13.wrapper;

public class Wrapper02 {
	public static void main(String[] args) {
		// 下列代码是否正确
		Double d = 100d; // 自动装箱 Double.valueOf(100d);
		Float f = 1.5f; // 自动装箱 Float.valueOf(1.5f);

		// 下面输出结果相同吗
		Object obj1 = true ? new Integer(1) : new Double(2.0);
		System.out.println(obj1); // 注意：三元运算符是一个整体，因为 Double 精度更高，所以输出 1.0

		Object obj2;
		if(true){
			obj2 = new Integer(1);
		}else {
			obj2 = new Double(2.0);
		}
		System.out.println(obj2); // 输出 1
	}
}
