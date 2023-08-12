package chapter27.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 演示定位符的使用
 */
public class RegExp06 {
    public static void main(String[] args) {
        String content = "hanshunping sphan nnhan";
        // String content = "123-abc";

        // 1.以至少 1 个数字开头，后接任意个小写字母的字符串
        String regStr1 = "^[0-9]+[a-z]*";

        // 2.以至少 1 个数字开头, 必须以至少一个小写字母结束
        String regStr2 = "^[0-9]+\\-[a-z]+$";

        /**
         * 3.边界匹配 \\b
         * 表示匹配边界的 han 这里的边界是指：被匹配的字符串最后
         * 也可以是空格的子字符串的后面
         */
        String regStr3 = "han\\b";

        // 4.和 \\b 的含义刚刚相反，非边界的 han
        String regStr4 = "han\\B";
        // Pattern pattern = Pattern.compile(regStr1);
        // Pattern pattern = Pattern.compile(regStr2);
        // Pattern pattern = Pattern.compile(regStr3);
        Pattern pattern = Pattern.compile(regStr4);

        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到: " + matcher.group(0));
        }
    }
}
