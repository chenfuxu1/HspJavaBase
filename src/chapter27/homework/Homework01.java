package chapter27.homework;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/8/12 21:23
 *
 * 验证电子邮箱格式是否合法
 * 1.只能有一个 @
 * 2.@ 前面是用户名，可以是 a-z A-Z 0-9 _ - 字符
 * 3.@ 后面是域名，并且域名只能是英文字母，比如 sohu.com 或者 tsinghua.org.cn
 **/
public class Homework01 {
    public static void main(String[] args) {
        String content = "cfx@sohu.com";
        String regStr = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        boolean matches = content.matches(regStr);
        /**
         * 1.String 的 matches 是整体匹配
         * 2.底层源码
         * String 类
         * public boolean matches(String regex) {
         *     return Pattern.matches(regex, this);
         * }
         *
         * Pattern 类
         * public static boolean matches(String regex, CharSequence input) {
         *     Pattern p = Pattern.compile(regex);
         *     Matcher m = p.matcher(input);
         *     return m.matches();
         * }
         *
         * Matcher 类，整个结果匹配
         * boolean match(int from, int anchor) {
         *     this.hitEnd = false;
         *     this.requireEnd = false;
         *     from        = from < 0 ? 0 : from;
         *     this.first  = from;
         *     this.oldLast = oldLast < 0 ? from : oldLast;
         *     for (int i = 0; i < groups.length; i++)
         *         groups[i] = -1;
         *     acceptMode = anchor;
         *     boolean result = parentPattern.matchRoot.match(this, from, text);
         *     if (!result)
         *         this.first = -1;
         *     this.oldLast = this.last;
         *     return result;
         * }
         */
        System.out.println("匹配结果：" + matches);
    }
}
