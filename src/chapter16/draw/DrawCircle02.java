package chapter16.draw;


import javax.swing.*;
import java.awt.*;


/**
 * 画其他图形
 * 1.画直线 drawLine(int x1,int y1,int x2,int y2)
 * g.drawLine(10, 10, 100, 100);
 *
 * 2.画矩形边框 drawRect(int x, int y, int width, int height)
 * g.drawRect(10, 10, 100, 100);
 *
 * 3.填充矩形颜色 fillRect(int x, int y, int width, int height)
 * g.setColor(Color.cyan);
 * g.fillRect(10, 10, 100, 100);
 *
 * 4.设置画笔的颜色
 * g.setColor(Color.blue);
 *
 * 5.填充椭圆 fillOval(int x, int y, int width, int height)
 * g.setColor(Color.red);
 * g.fillOval(10, 10, 100, 100);
 *
 * 6.画图片 drawImage(Image img, int x, int y, ..)
 * 1.获取图片资源, /bg.png 表示在该项目的根目录去获取 bg.png 图片资源
 * 2.Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
 * 3.g.drawImage(image, 10, 10, 175, 221, this);
 *
 * 7.画字符串 drawString(String str, int x, int y) // 写字
 *
 * 8.给画笔设置颜色和字体
 * g.setColor(Color.red);
 * g.setFont(new Font("隶书", Font.BOLD, 50));
 * 这里设置的 100，100，是 "北京你好" 左下角
 * g.drawString("北京你好", 100, 100);
 * 设置画笔的字体 setFont(Font font)
 * 设置画笔的颜色 setColor(Color c)
 */
public class DrawCircle02 extends JFrame { // JFrame是整个窗口，可以理解为画框
    // 定义一个画板
    private MyPanel_ mp = null;

    public static void main(String[] args) {
        new DrawCircle02();
        System.out.println("退出程序");
    }

    // 构造器
    public DrawCircle02() {
        // 初始化面板
        mp = new MyPanel_();
        // 把面板加入画框中
        this.add(mp);
        // 设置窗口的大小
        this.setSize(400, 300);
        // 设置可以显示
        this.setVisible(true);
        // 当点击窗口的小 ×，程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// 1.先定义一个 MyPanel 类继承 JPanel 类，画图形，就在 MyPanel 类的画板上进行
class MyPanel_ extends JPanel {
    // 1.MyPanel 对象就是一个画板
    // 2.Graphics g 中把 g 理解为一个画笔
    // 3.Graphics 提供了很多绘图的方法
    @Override
    public void paint(Graphics g) {
        super.paint(g); // 调用父类方法完成初始化
        // 1.画直线 drawLine(int x1,int y1,int x2,int y2)
        // g.drawLine(10, 10, 100, 100);

        // 2.画矩形边框 drawRect(int x, int y, int width, int height)
        // g.drawRect(10, 10, 100, 100);

        // 3.填充矩形颜色 fillRect(int x, int y, int width, int height)
        // g.setColor(Color.cyan);
        // g.fillRect(10, 10, 100, 100);

        // 4.填充椭圆 fillOval(int x, int y, int width, int height)
        // g.setColor(Color.RED);
        // g.fillOval(10, 10, 100, 200);
        System.out.println("该方法被调用了");

        // 5.画图片 drawImage(Image img, int x, int y, ..)
        // 获取图片资源, /bg.png 表示在该项目的根目录去获取 bg.png 图片资源,
        // 放在输出的 out 同级目录下，此处放在 out 目录下与 chapter16 包同级目录下
        // Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
        // g.drawImage(image, 10, 10, 175, 221, this);

        // 6.画字符串 drawString(String str, int x, int y) // 写字
        g.setColor(Color.red);
        g.setFont(new Font("隶书", Font.BOLD, 50));
        g.drawString("陈小荣", 100, 100); // 100, 100 这个像素点在第一个字字体的左下角
    }
}