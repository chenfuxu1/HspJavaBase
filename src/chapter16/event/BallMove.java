package chapter16.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * 演示小球通过键盘控制上下左右的移动
 */
public class BallMove extends JFrame {
    private MyPanel mp = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp); // 窗口 JFrame 对象可以监听键盘事件, 即可以监听到面板发生的键盘事件
    }
}

/**
 * 面板, 可以画出小球
 * KeyListener 是监听器, 可以监听键盘事件
 */
class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);  //默认黑色
    }

    // 有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 按键按下触发监听
    @Override
    public void keyPressed(KeyEvent e) {
        /**
         * System.out.println((char)e.getKeyCode());
         * 根据用户按下的不同键，来处理小球的移动 (上下左右的键)
         * 在 java 中，会给每一个键，分配一个值(int)
         */
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) { // KeyEvent.VK_DOWN 就是向下的箭头对应的 code
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }

        // 让面板重绘
        this.repaint();
    }

    // 按键释放触发监听
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
