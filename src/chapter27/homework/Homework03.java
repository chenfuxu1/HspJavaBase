package chapter27.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/8/13 0:15
 * <p>
 * 对 url 进行解析
 * http://www.sohu.com:8080/abc/index.html
 **/
public class Homework03 {
    public static void main(String[] args) {
        String content = "http://www.sohu.com:8080/abc/index.html";
        // 1.要求得到的协议是 http
        String regStr1 = "^([a-zA-Z]+)://";

        // 2.域名是 www.sohu.com
        String regStr2 = "^([a-zA-Z]+)://([\\w-.]+)";

        // 3.端口是 8080
        String regStr3 = "^([a-zA-Z]+)://([\\w-.]+):([\\d]+)";

        // 4.其他中间部分
        String regStr4 = "^([a-zA-Z]+)://([\\w-.]+):([\\d]+)([a-zA-Z/]*)";

        // 5.最后文件名部分
        String regStr5 = "^([a-zA-Z]+)://([\\w-.]+):(\\d+)([a-zA-Z/]*)/([a-zA-Z]+\\.[a-zA-Z]+)$";

        // Pattern pattern = Pattern.compile(regStr1);
        // Pattern pattern = Pattern.compile(regStr2);
        // Pattern pattern = Pattern.compile(regStr3);
        // Pattern pattern = Pattern.compile(regStr4);
        Pattern pattern = Pattern.compile(regStr5);

        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配 1：" + matcher.group(1));
            System.out.println("匹配 2：" + matcher.group(2));
            System.out.println("匹配 3：" + matcher.group(3));
            System.out.println("匹配 4：" + matcher.group(4));
            System.out.println("匹配 5：" + matcher.group(5));
        }
    }
}
