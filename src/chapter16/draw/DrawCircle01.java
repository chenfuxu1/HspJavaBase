package chapter16.draw;

import javax.swing.*;
import java.awt.*;


/**
 * 画圆形
 */
public class DrawCircle01 extends JFrame { // JFrame是整个窗口，可以理解为画框
    // 定义一个画板
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle01();
        System.out.println("退出程序");
    }

    // 构造器
    public DrawCircle01() {
        // 1.初始化面板
        mp = new MyPanel();
        // 2.把面板加入画框中
        this.add(mp);
        // 3.设置窗口的大小
        this.setSize(400, 300);
        // 4.设置可以显示
        this.setVisible(true);
        // 5.当点击窗口的小 ×，程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// 1.先定义一个 MyPanel 类继承 JPanel 类，画图形，就在 MyPanel 类的画板上进行
class MyPanel extends JPanel {
    // 1.MyPanel 对象就是一个画板
    // 2.Graphics g 中把 g 理解为一个画笔
    // 3.Graphics 提供了很多绘图的方法
    @Override
    public void paint(Graphics g) {
        super.paint(g); // 调用父类方法完成初始化
        g.drawOval(100, 100, 100, 100); // 画出一个圆形
        System.out.println("该方法被调用了");
    }
}