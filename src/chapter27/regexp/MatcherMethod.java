package chapter27.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matcher 类的常用方法
 */
public class MatcherMethod {
    public static void main(String[] args) {
        String content = "hello edu jack hspedutom hello smith hello hspedu hspedu";
        String regStr = "hello";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("=================");
            System.out.println(matcher.start()); // 返回分组 0 的开始下标索引
            System.out.println(matcher.end()); // 返回分组 0 的结束下标索引
            // 通过 end 和 start 索引也可得到检索到的字符
            System.out.println("找到：" + content.substring(matcher.start(), matcher.end()));
        }

        // 2.matcher.matches() 整体匹配方法，常用于，去校验某个字符串是否满足某个规则
        System.out.println("整体匹配：" + matcher.matches()); // 返回 false

        /**
         * 3.matcher.replaceAll()
         * 完成如果 content 有 hspedu 替换成 "韩顺平教育"
         * 注意：返回的字符串才是替换后的字符串，原来的 content 不变化
         */
        String regStr2 = "hspedu";
        pattern = Pattern.compile(regStr2);
        matcher = pattern.matcher(content);
        String str = matcher.replaceAll("韩顺平教育");
        System.out.println("content：" + content);
        System.out.println("str：" + str);
    }
}
