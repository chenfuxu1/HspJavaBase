package chapter17.thread;


/**
 * 使用多线程，模拟三个窗口同时售票 100 张
 */
public class SellTicket {
    public static void main(String[] args) {
		/**
		 * 不合理，多线程会抢夺资源
		 * 这里我们会出现超卖
		 */
        // 方法 1
        ShellTicket01 shellTicket01 = new ShellTicket01();
        ShellTicket01 shellTicket02 = new ShellTicket01();
        ShellTicket01 shellTicket03 = new ShellTicket01();
        shellTicket01.start();
        shellTicket02.start();
        shellTicket03.start();

        // 方法 2
        // ShellTicket02 shellTicket02 = new ShellTicket02();
        // new Thread(shellTicket02).start(); // 第 1 个线程-窗口
        // new Thread(shellTicket02).start(); // 第 2 个线程-窗口
        // new Thread(shellTicket02).start(); // 第 3 个线程-窗口
    }
}

// 使用 Thread 方式
class ShellTicket01 extends Thread {
    private static int ticketNum = 100; // 让多个线程共享 ticketNum

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                break;
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数 = " + (--ticketNum));

            // 休眠 50 毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/**
 * 使用 Runnable 方式，也是一样，会抢多资源
 * 线程不安全
 */
class ShellTicket02 implements Runnable {
    private int ticketNum = 100; // 让多个线程共享 ticketNum

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }
            // 休眠 50 毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数 = " + (--ticketNum)); // 1 - 0 - -1 - -2
        }
    }
}