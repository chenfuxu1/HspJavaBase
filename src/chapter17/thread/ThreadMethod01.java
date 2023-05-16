package chapter17.thread;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        threadDemo1.setName("路飞"); // 设置线程名称
        threadDemo1.setPriority(Thread.MIN_PRIORITY); // 设置优先级
        System.out.println(threadDemo1.getPriority()); // 获取优先级
        threadDemo1.start(); // 开启线程
        System.out.println(threadDemo1.getName()); // 获取线程名称

        // 主线程打印 5 次 hello，然后中断子线程的休眠
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hello " + i);
        }
        threadDemo1.interrupt();
    }
}

class ThreadDemo1 extends Thread { // 自定义线程类
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " 吃包子 " + i);
            }

            try {
                System.out.println(Thread.currentThread().getName() + " 休息中.......");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                // 当线程执行到 interrupt 方法时，会 catch 一个异常，可以加入自己的业务代码
                // InterruptedException 是捕获中断异常，不是终止
                System.out.println(Thread.currentThread().getName() + " 被interrupt了");
            }
        }
    }
}
