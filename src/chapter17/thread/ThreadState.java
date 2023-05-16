package chapter17.thread;


/**
 * 写程序查看线程状态
 * 线程状态。线程可以处于下列状态之一：
 *
 * NEW
 * 至今尚未启动的线程处于这种状态
 *
 * RUNNABLE
 * 正在 Java 虚拟机中执行的线程处于这种状态
 *
 * BLOCKED
 * 受阻塞并等待某个监视器锁的线程处于这种状态
 *
 * WAITING
 * 无限期地等待另一个线程来执行某一特定操作的线程处于这种状态
 *
 * TIMED_WAITING
 * 等待另一个线程来执行取决于指定等待时间的操作的线程处于这种状态
 *
 * TERMINATED
 * 已退出的线程处于这种状态。
 * 在给定时间点上，一个线程只能处于一种状态。这些状态是虚拟机状态，它们并没有反映所有操作系统线程状态。
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        TT tt = new TT();
        System.out.println("线程状态: " + tt.getState());
        tt.start();
        while (Thread.State.TERMINATED != tt.getState()) {
            System.out.println("线程状态: " + tt.getState());
            Thread.sleep(500);
        }
        System.out.println("线程状态: " + tt.getState());
    }
}

class TT extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}
