package chapter17.thread;


/**
 * 互斥锁
 * 使用多线程，模拟三个窗口同时售票 100 张
 * 使用 Synchronized 锁，线程安全
 */
public class SellTicket03 {
    public static void main(String[] args) {
        ShellTicket__ shellTicket__ = new ShellTicket__();
        new Thread(shellTicket__).start();
        new Thread(shellTicket__).start();
        new Thread(shellTicket__).start();
    }
}

// 加线程安全锁
class ShellTicket__ implements Runnable {
    private int ticketNum = 100; // 让多个线程共享 ticketNum
    private boolean flag = true;
    Object object = new Object();

    /**
     * 1.public synchronized void sell() {} 就是一个同步方法
     * 2.这时锁在 this 对象
     * 3.也可以在代码块上写 synchronize, 同步代码块, 互斥锁还是在 this 对象
     */
    public void sell() { // 同步方法，在同一个时刻，只能有一个线程来执行 sell 方法
        synchronized (object) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                flag = false;
                return;
            }
            // 休眠 50 毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数 = " + (--ticketNum));
        }
    }


    /**
     * 同步方法（静态的）的锁为当前类本身
     * 1.public synchronized static void m1() {} 锁是加在 ShellTicket__.class
     */
    public synchronized static void m1() {
    }

    /**
     * 2.如果在静态方法中，实现一个同步代码块
     * 锁类对象即可
     */
    public static void m2() {
        synchronized (ShellTicket__.class) {
            System.out.println("m2");
        }
    }

    @Override
    public void run() {
        while (flag) {
            sell();
        }
    }
}