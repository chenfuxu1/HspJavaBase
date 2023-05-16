package chapter17.thread;


/**
 * 实现 Runnable 接口实现多线程
 */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        // dog.start(); // 无 start 方法，不能调用

        // 创建了 Thread 对象，把 dog 对象(实现 Runnable), 放入 Thread
        Thread thread = new Thread(dog);
        thread.start();

        /**
         * 模拟 Thread 方法实现
         */
        // Tiger tiger = new Tiger(); //实现了 Runnable
        // ThreadProxy threadProxy = new ThreadProxy(tiger);
        // threadProxy.start();
    }
}

class Animal {
}

class Tiger extends Animal implements Runnable {
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫");
    }
}


/**
 * 线程代理类，模拟 Thread 类的方法
 */
class ThreadProxy implements Runnable {
    private Runnable target = null; // 定义 Runnable 属性

    // 在构造器中初始化该属性
    // Thread 类也是通过构造器传入实现 Runnable 接口的对象
    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    // 3.调用本类 run 方法
    @Override
    public void run() {
        if (target != null) {
            target.run(); // 动态绑定（运行类型 Tiger）
        }
    }

    // 1.多线程会调用 start 方法，Thread 内部调用 start0 方法
    public void start() {
        start0(); // 这个方法时真正实现多线程方法
    }

    // 2.该方法由 JVM 调用，是本地方法 native
    public void start0() {
        run(); //3.调用 run
    }
}

class Dog implements Runnable { // 通过实现 Runnable 接口，开发线程
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("小狗汪汪叫。。hi " + (++count) + " " + Thread.currentThread().getName());
            // 休眠 1 秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}
