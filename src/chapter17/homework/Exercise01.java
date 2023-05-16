package chapter17.homework;

import java.util.Scanner;


/**
 * 1.在 main 方法中启动两个线程
 * 2.A 线程循环随机打印 100 以内的整数
 * 3.B 线程从键盘读取 "Q" 命令后，A，B 都退出
 */
public class Exercise01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a); // B 线程一定要有能控制 A 线程的对象
        a.start();
        b.start();
    }
}


// A 线程循环随机打印 100 以内的整数
class A extends Thread {
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println((int) (Math.random() * 100) + 1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程 A 退出");
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}


// B 线程从键盘读取 "Q" 命令后，A，B 都退出
class B extends Thread {
    private A a; // B 线程一定要有能控制 A 线程的对象
    private Scanner sc = new Scanner(System.in);

    public B(A a) {
        this.a = a; // 构造器传入 a 对象
    }

    @Override
    public void run() {
        while (true) {
            String s = sc.next();
            if (s.length() == 1) {
                char c = s.toUpperCase().charAt(0);
                if (c == 'Q') {
                    a.setFlag(false); // 设置 a 对象的属性
                    System.out.println("线程B退出");
                    break;
                }
            }

        }
    }
}