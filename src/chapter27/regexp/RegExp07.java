package chapter27.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 分组，可捕获
 */
public class RegExp07 {
    public static void main(String[] args) {
        String content = "hanshunping s7789 nn1189han";
        /**
         * 非命名分组
         * 1.matcher.group(0) 得到匹配到的字符串
         * 2.matcher.group(1) 得到匹配到的字符串的第 1 个分组内容
         * 3.matcher.group(2) 得到匹配到的字符串的第 2 个分组内容
         */
        String regStr1 = "(\\d\\d)(\\d\\d)"; // 匹配 4 个数字的字符串

        // 命名分组，即可以给分组取名
        String regStr2 = "(?<g1>\\d\\d)(?<g2>\\d\\d)";

        // Pattern pattern = Pattern.compile(regStr1);
        Pattern pattern = Pattern.compile(regStr2);

        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到: " + matcher.group(0));
            System.out.println("第 1 个分组内容: " + matcher.group(1));
            System.out.println("第 1 个分组内容(通过组名): " + matcher.group("g1"));
            System.out.println("第 2 个分组内容: " + matcher.group(2));
            System.out.println("第 2 个分组内容(通过组名): " + matcher.group("g2"));
        }
    }
}
