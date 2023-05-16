package chapter17.thread;


/**
 * 使用多线程，模拟三个窗口同时售票 100 张
 * 使用 Synchronized 锁，线程安全
 */
public class SellTicket02 {
    public static void main(String[] args) {
        ShellTicket_ shellTicket_ = new ShellTicket_();
        new Thread(shellTicket_).start();
        new Thread(shellTicket_).start();
        new Thread(shellTicket_).start();
    }
}


/**
 * 使用 Runnable 方式，也是一样，会抢多资源
 * 加线程安全锁
 */
class ShellTicket_ implements Runnable {
    private int mTicketNum = 100; // 让多个线程共享 ticketNum
    private boolean mFlag = true;

    public synchronized void sell() { // 同步方法，在同一个时刻，只能有一个线程来执行 sell 方法
		if (mTicketNum <= 0) {
			System.out.println("售票结束...");
			mFlag = false;
			return;
		}
		// 休眠 50 毫秒, 模拟
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
				+ " 剩余票数 = " + (--mTicketNum));
    }

    @Override
    public void run() {
        while (mFlag) {
            sell();
        }
    }
}