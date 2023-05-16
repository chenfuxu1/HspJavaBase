package chapter17.concept;


// 获取当前电脑 cpu 的个数
public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int i = runtime.availableProcessors();
        System.out.println("当前电脑 CPU 个数：" + i);
    }
}
