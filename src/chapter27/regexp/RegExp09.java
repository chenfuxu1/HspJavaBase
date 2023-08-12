package chapter27.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 非贪婪匹配
 * 当 ？紧跟着其他限定符 * + ？{n} {n,} {n,m} 表示非贪婪匹配
 * o+ 表示匹配所有的 o
 * o+？表示只匹配一个 o
 */
public class RegExp09 {
    public static void main(String[] args) {
        String content = "dasdooodas";
        // 1.贪婪匹配
        String regStr1 = "o+"; // 贪婪匹配，会匹配三个 o (所有)
        // 2.非贪婪匹配
        String regStr2 = "o+?"; // 只匹配一个 o

        // Pattern pattern = Pattern.compile(regStr1);
        Pattern pattern = Pattern.compile(regStr2);

        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到: " + matcher.group(0));
        }
    }
}
