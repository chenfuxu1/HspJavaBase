package chapter17.thread;


/**
 * 继承 Thread 类创建线程
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Cat_ cat = new Cat_();
        cat.start(); // 会启动 main 主线程下的子线程，最终调用 run 方法
        // cat.run(); // 直接调用 run 方法，走的还是主线程 main，没有开启子线程 就会把 run 方法执行完毕，才向下执行

        // 这时主线程和子线程是交替执行
        System.out.println("主线程继续执行: " + Thread.currentThread().getName()); // 名字 main
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程 i= " + i);
            // 让主线程休眠
            Thread.sleep(1000);
        }

        /**
         * 解读源码 cat.start()
         * 1.调用 start0() 方法
         * public synchronized void start() {
         *      start0();
         * }
         *
         * 2.该方法由 JVN 调用，是本地方法，底层是 c/c++ 实现
         * 真正实现多线程是 start0()，而不是 run() 方法
         * private native void start0();
         *
         */
    }
}

class Cat_ extends Thread {
    int times = 0;

    @Override
    public void run() {
        while (true) {
            // 该线程每隔 1 秒，在控制台输出 "喵喵, 我是小猫咪"
            System.out.println("喵喵, 我是小猫咪 " + (++times) + " 线程名：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 80) { // 当 times 到 80, 退出 while, 这时线程也就退出
                break;
            }
        }

    }
}
