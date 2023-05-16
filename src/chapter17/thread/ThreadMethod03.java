package chapter17.thread;


/**
 * 设置守护线程
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread dt = new MyDaemonThread();
        // 将 dt 设为守护线程
        dt.setDaemon(true); // 当用户线程(工作线程)结束时，守护线程也结束
        dt.start();
        for (int i = 0; i <= 100; i++) {
            Thread.sleep(50);
            System.out.println("宝强在辛苦工作 " + i);
        }
    }
}

class MyDaemonThread extends Thread {
    @Override
    public void run() {
        for (; ; ) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("马蓉和宋哲在聊天");
        }
    }
}