package chapter13.string;


public class StringExercise03 {
    /**
     * intern(), 尝试把字符串放入常量池
     * 如果常量池没有，便创建，返回常量池字符串地址
     * 如果常量池有，直接返回常量池字符串地址
     *
     * @param args
     */
    public static void main(String[] args) {
        String a = "hsp"; // 返回常量池地址
        String b = new String("hsp"); // 返回堆区地址
        System.out.println(a.equals(b)); // 内容相同，T
        System.out.println(a == b); // 地址不同，F
        System.out.println(a == b.intern()); // b.intern 尝试把 hsp 放入常量池，发现有，故返回常量池 hsp 的地址，故为 T
        System.out.println(b == b.intern()); // b 在堆区，b.intern 是常量池地址，故 F
    }
}
