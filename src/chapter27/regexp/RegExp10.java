package chapter27.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式的应用实例
 */
public class RegExp10 {
    public static void main(String[] args) {
        String content1 = "海1贼王";
        String content2 = "123890";
        String content3 = "175885";
        String content4 = "13588889999";

        // 1.匹配汉字
        String regStr1 = "^[\u0391-\uffe5]+$"; // \u0391-\uffe5 表示汉字的编码，且有 ^ 和 $ 定位符，表示对整个字符串匹配，中间有不满足的都为匹配失败

        /**
         * 2.匹配邮政编码
         * 要求：是 1-9 开头的一个六位数. 比如：123890
         */
        String regStr2 = "^[1-9]\\d{5}$";

        /**
         * 3.匹配 QQ 号码
         * 要求: 是 1-9 开头的一个 5 位数到 10 位数，比如: 12389, 1345687, 187698765
         */
        String regStr3 = "^[1-9]\\d{4,9}$";

        /**
         * 4.匹配手机号码
         * 要求: 必须以 13, 14, 15, 18 开头的 11 位数, 比如 13588889999
         */
        String regStr4 = "^1[3|4|5|8]\\d{9}$";

        // Pattern pattern = Pattern.compile(regStr1);
        // Pattern pattern = Pattern.compile(regStr2);
        // Pattern pattern = Pattern.compile(regStr3);
        Pattern pattern = Pattern.compile(regStr4);

        // Matcher matcher = pattern.matcher(content1);
        // Matcher matcher = pattern.matcher(content2);
        // Matcher matcher = pattern.matcher(content3);
        Matcher matcher = pattern.matcher(content4);
        if(matcher.find()) {
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }
    }
}
