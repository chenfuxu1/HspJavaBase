package chapter13.homework;

public class Exercise04 {
    public static void main(String[] args) {
        String str = "342131241hhsdasAAJJJbdasA";
        test(str);
    }

    public static void test(String str) {
        if (str == null) {
            System.out.println("字符串不能为空");
            return;
        }

        int a = 0; // 大写字母
        int b = 0; // 小写字母
        int c = 0; // 数字
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                a++;
            } else if (Character.isLowerCase(chars[i])) {
                b++;
            } else if (Character.isDigit(chars[i])) {
                c++;
            }
        }

        System.out.println("大写字母：" + a);
        System.out.println("小写字母：" + b);
        System.out.println("数字：" + c);
    }
}
