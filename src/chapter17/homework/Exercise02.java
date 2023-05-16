package chapter17.homework;


/**
 * 1.有两个用户分别从同一个卡上取钱，总额 10000
 * 2.每次取 1000，当卡上余额不足时，不能取款
 * 3.不能存在超取现象 -> 线程同步问题
 */
public class Exercise02 {
    public static void main(String[] args) {
        T t = new T();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.setName("用户 1");
        t2.setName("用户 2");
        t1.start();
        t2.start();
    }
}

class T implements Runnable {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {
            /**
             * 1.这里使用 synchronized 实现了线程同步
             * 2.当多个线程执行到这里时，就会抢夺 this 对象锁
             * 3.哪个线程争夺到 this 对象锁，就会执行 synchronized 代码块，执行完后释放锁
             * 4.争夺不到 this 对象锁就会 blocked，准备继续争夺
             * 5.this 对象锁是非公平锁
             */
            synchronized (this) {
                // 判断余额是否够
                if (money < 1000) {
                    System.out.println("余额不足");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出 1000 元后， 当前余额 = " + money);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
