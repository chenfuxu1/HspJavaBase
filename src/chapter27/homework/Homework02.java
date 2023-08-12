package chapter27.homework;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/8/12 21:42
 * <p>
 * 验证是不是整数或者小数
 * 要考虑正数和负数
 * 比如：123、-345、34.89、-87.9、-0.01、0.45 等
 **/
public class Homework02 {
    public static void main(String[] args) {
        // 1.验证正整数
        String content1 = "123";
        String regStr1 = "^\\d+$";
        boolean matches1 = content1.matches(regStr1);
        System.out.println("匹配结果：" + matches1);
        System.out.println("===========");

        // 2.验证正负整数
        String content2 = "-123";
        String regStr2 = "^[-+]?\\d+$";
        boolean matches2 = content2.matches(regStr2);
        System.out.println("匹配结果：" + matches2);
        System.out.println("===========");

        // 3.验证小数
        String content3 = "34.89";
        String regStr3 = "^[-+]?\\d+(\\.\\d+)?$";
        boolean matches3 = content3.matches(regStr3);
        System.out.println("匹配结果：" + matches3);
        System.out.println("===========");

        // 4.验证整数部分开头的 0
        String content4 = "0.89";
        String regStr4 = "^[-+]?([1-9]\\d*)+(\\.\\d+)?$";
        boolean matches4 = content4.matches(regStr4);
        System.out.println("匹配结果：" + matches4);
        System.out.println("===========");

        // 5.验证整数部分开头的 0，可以有一个 0
        String content5 = "-01.89";
        String regStr5 = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
        boolean matches5 = content5.matches(regStr5);
        System.out.println("匹配结果：" + matches5);
        System.out.println("===========");
    }
}
