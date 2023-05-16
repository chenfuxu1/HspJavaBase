package chapter17.thread;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/14 21:29
 * <p>
 * 线程终止
 **/
public class ThreadExit {
    public static void main(String[] args) {
        T_ t1 = new T_();
        t1.start();
        // 主线程控制 t1 线程的终止，可以设置变量
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 10 s 后，终止 t1 线程
        t1.setLoop(false);
    }
}

class T_ extends Thread {
    private int mCount = 0;
    private boolean mLoop = true;

    @Override
    public void run() {
        while (mLoop) {
            try {
                Thread.sleep(50); // 让当前线程休眠 50 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T 运行中... mCount = " + mCount++);
        }
    }

    public void setLoop(boolean loop) {
        mLoop = loop;
    }
}


