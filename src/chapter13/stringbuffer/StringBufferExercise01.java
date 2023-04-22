package chapter13.stringbuffer;

public class StringBufferExercise01 {
	public static void main(String[] args) {
		String str = null; // ok
		StringBuffer sb = new StringBuffer(); // ok
		/**
		 * private AbstractStringBuilder appendNull() {
		 *         int c = count;
		 *         ensureCapacityInternal(c + 4);
		 *         final char[] value = this.value;
		 *         value[c++] = 'n';
		 *         value[c++] = 'u';
		 *         value[c++] = 'l';
		 *         value[c++] = 'l';
		 *         count = c;
		 *         return this;
		 *     }
		 */
		sb.append(str); // 需要看源码 , 底层调用的是 AbstractStringBuilder 的 appendNull
		System.out.println(sb.length()); // 4
		System.out.println(sb); // null

		// 下面的构造器，会抛出 NullPointerException
		StringBuffer sb1 = new StringBuffer(str); // 看底层源码 super(str.length() + 16);
		System.out.println(sb1);
	}
}
