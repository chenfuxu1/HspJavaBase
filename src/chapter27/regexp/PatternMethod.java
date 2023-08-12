package chapter27.regexp;


import java.util.regex.Pattern;

/**
 * 演示 matches 方法，用于整体匹配, 在验证输入的字符串是否满足条件使用
 */
public class PatternMethod {
    public static void main(String[] args) {
        // 整体匹配, 匹配整个字符串
        String content = "hello abc hell, 韩顺平教育";
        // String regStr1 = "hello" 会匹配失败，因为匹配的是整体
        String regStr = "hello.*"; // 匹配成功
        boolean matches = Pattern.matches(regStr, content);
        System.out.println("匹配整体：" + matches);
    }
}
