package chapter27.regexp;


/**
 * 1.替换功能
 * String 类 public String replaceAll(String regex,String replacement)
 * 2,判断功能
 * String 类 public boolean matches(String regex){} // 使用 Pattern 和 Matcher 类
 * 3.分割功能
 * String 类 public String[] split(String regex)
 */
public class StringReg {
    public static void main(String[] args) {
        String content = "2000 年 5 月， JDK1.3、 JDK1.4 和 J2SE1.3 相继发布， 几周后其" +
                "获得了 Apple 公司 Mac OS X 的工业标准的支持。 2001 年 9 月 24 日， J2EE1.3 发" +
                "布。 " +
                "2002 年 2 月 26 日， J2SE1.4 发布。 自此 Java 的计算能力有了大幅提升";
        // 1.使用正则表达式方式，将 JDK1.3 和 JDK1.4 替换成 JDK
        String regStr1 = "JDK1\\.[34]";
        content = content.replaceAll(regStr1, "JDK");
        System.out.println(content);
        System.out.println("=======================");

        // 2.要求验证一个手机号，要求必须是以 138、139 开头的
        content = "13888889999";
        String regStr2 = "^13[89]\\d{8}$"; // 或者 1(38|39)\\d{8}
        if (content.matches(regStr2)) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }

        // 3.要求按照 # 或者 - 或者 ~ 或者数字来分割
        System.out.println("===================");
        content = "hello#abc-jack12smith~北京";
        String regStr3 = "(#|-|~|\\d+)";
        String[] split = content.split(regStr3);
        for (String s : split) {
            System.out.println(s);
        }
    }
}
