package chapter27.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演示字符匹配符 的使用
 */
public class RegExp03 {
    public static void main(String[] args) {
        String content = "a1.1c?\t8abc _ABCy @";
        // 1.匹配 a-z 之间任意一个字符
        String regStr1 = "[a-z]";
        // 2.匹配 A-Z 之间任意一个字符
        String regStr2 = "[A-Z]";
        // 3.匹配 abc 字符串，默认区分大小写
        String regStr3 = "abc";
        // 4.匹配 abc 字符串，不区分大小写
        String regStr4 = "(?i)abc";
        // 5.匹配 0-9 之间任意一个字符
        String regStr5 = "[0-9]";
        // 6.匹配不在 a-z 之间任意一个字符
        String regStr6 = "[^a-z]";
        // 7.匹配不在 0-9 之间任意一个字符
        String regStr7 = "[^0-9]";
        // 8.匹配不在 0-9 的任意一个字符
        String regStr8 = "\\D";
        // 9.匹配在 abcd 中任意一个字符
        String regStr9 = "[abcd]";
        // 10.匹配大小写英文字母, 数字，下划线
        String regStr10 = "\\w";
        // 11.匹配等价于 [^a-zA-Z0-9_]
        String regStr11 = "\\W";
        // 12.匹配任何空白字符(空格, 制表符等) -> \\s
        String regStr12 = "\\s";
        // 13.匹配任何非空白字符, 和 \\s 刚好相反 -> \\S
        String regStr13 = "\\S";
        // 14.匹配出 \n 之外的所有字符, 如果要匹配 . 本身则需要使用 -> \\.
        String regStr14 = ".";

        // 当创建 Pattern 对象时，指定 Pattern.CASE_INSENSITIVE, 表示匹配是不区分字母大小写.
        // Pattern pattern = Pattern.compile(regStr, Pattern.CASE_INSENSITIVE);

        // Pattern pattern = Pattern.compile(regStr1);
        // Pattern pattern = Pattern.compile(regStr2);
        // Pattern pattern = Pattern.compile(regStr3);
        // Pattern pattern = Pattern.compile(regStr4);
        // Pattern pattern = Pattern.compile(regStr5);
        // Pattern pattern = Pattern.compile(regStr6);
        // Pattern pattern = Pattern.compile(regStr7);
        // Pattern pattern = Pattern.compile(regStr8);
        // Pattern pattern = Pattern.compile(regStr9);
        // Pattern pattern = Pattern.compile(regStr10);
        // Pattern pattern = Pattern.compile(regStr11);
        // Pattern pattern = Pattern.compile(regStr12);
        // Pattern pattern = Pattern.compile(regStr13);
        Pattern pattern = Pattern.compile(regStr14);

        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
