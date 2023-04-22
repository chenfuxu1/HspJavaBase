package chapter13.homework;


/**
 * 将指定字符串反转
 * 例 "a bcde f" -> "a edcb f"
 */
public class Exercise01 {
    public static void main(String[] args) {
        String str = "abcdef";
        String reverse = reverse(str, 1, 4);

        String reverse2 = null;
        try {
            reverse2 = reverse2(str, 1, 34);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String reverse3 = reverse3(str, 1, 4);
        System.out.println(reverse);
        System.out.println(reverse2);
        System.out.println(reverse3);
    }

    /**
     * 反转字符串
     *
     * @param str
     * @param start
     * @param end
     * @return
     */
    public static String reverse(String str, int start, int end) {
        char[] chars = str.toCharArray();
        String s = "";
        for (int i = 0; i < start; i++) {
            s += chars[i];
        }

        for (int i = start; i <= end; i++) {
            s += chars[end - i + start];
        }

        for (int i = end + 1; i < chars.length; i++) {
            s += chars[i];
        }
        return s;
    }

    // 老韩
    public static String reverse2(String str, int start, int end) {
        // 验证数据
        // 编程思维
        // 列举所有正确的情况，进行取反即可
        if (!(str != null && start >= 0 && end > start && end < str.length())) {
            throw new RuntimeException("参数不正确");
        }
        char[] chars = str.toCharArray();
        char temp = ' ';
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    public static String reverse3(String str, int start, int end) {
        char[] chars = str.toCharArray();
        char temp = ' ';
        for (int i = start; i < ((end - start) / 2 + start); i++) {
            temp = chars[i];
            chars[i] = chars[end - i + start];
            chars[end - i + start] = temp;
        }
        return new String(chars);
    }
}
