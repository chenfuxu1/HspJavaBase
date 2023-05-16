package chapter17.thread;


/**
 * 1.主线程每隔 1s，输出 hello，一共输出 10 次
 * 2.当输出到 hello 5 时，启动一个子线程(要求实现 Runnable 接口)
 * 每隔一秒输出 hi，输出 10 次后，退出
 * 3.主线程继续输出 hello，直到主线程退出
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        TM tm = new TM();
        Thread thread = new Thread(tm);
        thread.setName("我是子线程");
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + i + " hello");
            Thread.sleep(1000);
            if (i == 5) {
                thread.start(); // 启动子线程
                thread.join(); // 立即将子线程插入到主线程队列，让其先执行
            }
        }
        System.out.println("主线程执行结束");
    }
}

class TM implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + (++count) + " hi ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                System.out.println("子线程执行结束");
                break;
            }
        }
    }
}
