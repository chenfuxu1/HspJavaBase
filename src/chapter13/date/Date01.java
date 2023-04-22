package chapter13.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date01 {
	public static void main(String[] args) throws ParseException {
		// 1.获取当前系统时间
		// 2.Date 在 java.util 包下
		// 3.默认格式是国外的，需要格式转换
		Date date = new Date(); // 获取当前系统时间
		System.out.println("当前系统时间为：" + date);

		// 通过指定毫秒获得时间
		Date date2 = new Date(932432423);
		System.out.println("d2 = " + date2); // d2 = Mon Jan 12 03:00:32 CST 1970

		// 创建 SimpleDateFormat 对象，格式化时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		String format = sdf.format(date);
		System.out.println(format);

		// String -> Date
		String s = "1996年03月30日 10:20:30";
		Date parse = sdf.parse(s); // 输出还是国外的日期格式，需要格式化
		System.out.println(parse);
		System.out.println(sdf.format(parse));
	}
}
