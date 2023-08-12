package chapter27.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演示限定符的使用
 */
public class RegExp05 {
    public static void main(String[] args) {
        String content = "a211111aaaaaahello";
        // 1.a{3}, 1{4}, \\d{2}
        String regStr1 = "a{3}"; // 表示 3 个 a
        String regStr2 = "1{4}"; // 表示 4 个 1
        String regStr3 = "\\d{2}"; // 表示任意两个数字

        /**
         * 2.a{3,4}, 1{4,5}, \\d{2,5}
         * java 匹配，默认是贪婪匹配，即尽可能匹配多的内容
         * 例如 content = "aaaaa", a{3,4} 会优先匹配 4 个 a
         */
        String regStr4 = "a{3,4}"; // 表示 3 到 4 个 a
        String regStr5 = "1{4,5}"; // 表示 4 到 5 个 1
        String regStr6 = "\\d{2,5}"; // 表示任意 2 个到 5 个之间数字

        // 3.1+
        String regStr7 = "1+"; // 匹配一个 1 或者多个 1
        String regStr8 = "\\d+"; // 匹配一个数字或者多个数字

        // 4.1*
        String regStr9 = "1*"; // 匹配 0 个 1 或者多个 1

        // 5.演示 ? 的使用, 遵守贪婪匹配
        String regStr10 = "a1?"; // 匹配 a 或者 a1

        // Pattern pattern = Pattern.compile(regStr1);
        // Pattern pattern = Pattern.compile(regStr2);
        // Pattern pattern = Pattern.compile(regStr3);
        // Pattern pattern = Pattern.compile(regStr4);
        // Pattern pattern = Pattern.compile(regStr5);
        // Pattern pattern = Pattern.compile(regStr6);
        // Pattern pattern = Pattern.compile(regStr7);
        // Pattern pattern = Pattern.compile(regStr8);
        // Pattern pattern = Pattern.compile(regStr9);
        Pattern pattern = Pattern.compile(regStr10);

        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
