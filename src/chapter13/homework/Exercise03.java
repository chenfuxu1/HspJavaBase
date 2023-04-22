package chapter13.homework;


/**
 * 1.输入 Han shun Ping 的人名，以 Ping，Han .S 的形式打印出来
 * 其中 .S 是中间单词的首字母
 * 2.例如：输入 "Willian jefferson Clinton"
 * 输出：Clinton，Willian .J
 */
public class Exercise03 {
	public static void main(String[] args) {
		String str = "Willian jefferson Clinton";
		String string = String_(str);
		System.out.println(string);
	}

	public static String String_(String str){
		if(str == null){
			System.out.println("不能为空");
			return null;
		}

		String ss = "";
		String[] s = str.split(" ");
		//获取中间单词的首字母
		char c = s[1].charAt(0);
		char c1 = Character.toUpperCase(c);  //转成大写
		ss += s[2] + ", " + s[0] + " ." + c1;
		return ss;
	}
}
