package chapter27.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 非捕获分组, 语法比较奇怪
 */
public class RegExp08 {
    public static void main(String[] args) {
        String content = "hello 韩顺平教育 jack 韩顺平老师 韩顺平同学 hello 韩顺平学生";
        /**
         * 1.找到 韩顺平教育、韩顺平老师、韩顺平同学 子字符串
         * 1.1 传统方法
         */
        String regStr1 = "韩顺平教育|韩顺平老师|韩顺平同学";
        // 1.2 非捕获分组，语法：(?:Pattern)，与上面等价，但不鞥通过 matcher.group(1) 获得
        String regStr2 = "韩顺平(?:教育|老师|同学)";

        /**
         * 2.找到 "韩顺平" 这个关键字, 但是要求只是查找 "韩顺平教育" 和 "韩顺平老师" 中包含有的 "韩顺平"
         * 语法：(?=Pattern)，匹配满足 Pattern 的条件，不能获取，返回 () 前面的内容
         */
        String regStr3 = "韩顺平(?=教育|老师)";

        /**
         * 3.找到 "韩顺平" 这个关键字, 但是要求只是查找 不是 (韩顺平教育 和 韩顺平老师) 中包含有的 "韩顺平"
         * 下面也是非捕获分组，不能使用 matcher.group(1)
         * 语法：(?!Pattern)，匹配和 Pattern 相反的条件，即和 (?=Pattern) 相反
         */
        String regStr4 = "韩顺平(?!教育|老师)";

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
