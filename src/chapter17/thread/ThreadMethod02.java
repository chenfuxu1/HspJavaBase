package chapter17.thread;


/**
 * join 方法，插队线程，一旦插入成功，先执行插入的线程，再回到原处
 * yield，线程的礼让，不一定礼让成功（资源够用的情况下）
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        for (int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程(小弟)吃了 " + i + " 包子");
            // 主线程吃了 5 个后让子线程先吃完再执行
            if (i == 5) {
                System.out.println("小弟让大哥先吃");
                t.join(); // 线程插队

                // Thread.yield(); // 线程礼让，不一定成功
                System.out.println("大哥已经吃完了");
            }
        }
    }
}

class T extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000); // 休眠 1 秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程(大哥)吃了 " + i + " 个包子");
        }
    }
}
