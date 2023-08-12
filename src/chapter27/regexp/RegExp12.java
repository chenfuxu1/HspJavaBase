package chapter27.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分组，匹配，反向引用
 * 1.匹配两个连续相同的数字
 * 2.匹配五个连续相同的数字
 * 3.匹配个位与千位相同，十位与百位相同的数
 */
public class RegExp12 {
    public static void main(String[] args) {
        // 1.匹配两个连续相同的数字
        String content1 = "12 22 3445 33 45 56 77";
        String regStr1 = "(\\d)\\1";

        // 2.匹配五个连续相同的数字
        String content2 = "123123 322222 3231 55555";
        String regStr2 = "(\\d)\\1{4}";

        // 3.匹配个位与千位相同，十位与百位相同的数
        String content3 = "1122 1221 1331 5665";
        String regStr3 = "(\\d)(\\d)\\2\\1";
        Pattern pattern = Pattern.compile(regStr3);
        Matcher matcher = pattern.matcher(content3);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }

        /**
         * 4.检索前面是一个五位数，后面是一个九位数，九位数三个三个相同
         * 例如 12321-333999111
         */
        String content4 = "12321-333999111";
        String regStr4 = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";
        System.out.println(Pattern.matches(regStr4, content4));
    }
}
