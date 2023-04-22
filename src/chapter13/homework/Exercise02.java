package chapter13.homework;


/**
 * 输入用户名，密码，邮箱，如果正确，提示注册成功，否则生成异常对象
 * 要求
 * 1.用户名长度 2 ~ 4
 * 2.密码长度为 6，要求全是数字
 * 3.邮箱包含@，并且@在 . 之前
 */
public class Exercise02 {
    public static void main(String[] args) {
        String name = "cfx";
        String pwd = "123456";
        String email = "cfx@321312.com";
        try {
            userRegister(name, pwd, email);
            System.out.println("注册成功！");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userRegister(String name, String pwd, String email) {
        if (!(name != null && pwd != null && email != null)) {
            throw new RuntimeException("有参数为空！");
        }

        // 1.判断用户名长度
        int length = name.length();
        if (!(length >= 2 && length <= 4)) {
            throw new RuntimeException("用户名长度应在2~4之间！");
        }

        // 2.判断密码
        int plength = pwd.length();
        if (!(plength == 6 && isDigit(pwd))) {
            throw new RuntimeException("密码长度为6，要求全是数字!");
        }

        // 3.判断邮箱
        int index1 = email.indexOf('@');
        int index2 = email.indexOf('.');
        if (!(index1 > 0 && index1 < index2)) {
            throw new RuntimeException("邮箱包含@，并且@在 . 之前");
        }
    }

    // 判断密码都是数字
    public static boolean isDigit(String pwd) {
        char[] chars = pwd.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!(Character.isDigit(chars[i]))) {
                return false;
            }
        }
        return true;
    }
}
