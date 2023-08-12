package chapter27.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 把类似: "我....我要....学学学学....编程 java!";
 * 通过正则表达式修改成 "我要学编程 java"
 */
public class RegExp13 {
    public static void main(String[] args) {
        String content = "我....我要....学学学学....编程 java!";

        // 1.去除所有的...
        String regStr1 = "\\.";
        Pattern pattern = Pattern.compile(regStr1);
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll("");
        System.out.println("去除所有 . 后：" + content);
        System.out.println("========================");

        /**
         * 2.去掉重复的字：我我要学学学学编程 java!
         * 思路：
         * 2.1 使用 (.)\\1+
         * 2.2 使用反向引用 $1 来替换匹配到的内容
         * 注意：因为正则表达式变化，所以需要重置 matcher
         */
        String regStr2 = "(.)\\1+";
        pattern = Pattern.compile(regStr2);
        matcher = pattern.matcher(content);
        content = matcher.replaceAll("$1");
        System.out.println("替换后：" + content);

        // 上述 2 可以简化为一行代码
        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
        System.out.println("替换后：" + content);
    }
}
