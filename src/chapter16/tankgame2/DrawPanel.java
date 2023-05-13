package chapter16.tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:52
 * <p>
 * 定义游戏绘制的区域
 * 为了监听键盘事件，需要实现 KeyListener
 **/
public class DrawPanel extends JPanel implements KeyListener {

    // 定义我方的坦克
    private HeroTank mHeroTank;

    public DrawPanel() {
        mHeroTank = new HeroTank(100, 100, Constants.RIGHT_DIRECTION);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        // 1.设置整个区域背景为黑色
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, 1100, 750);

        drawTank(graphics, mHeroTank);
    }

    /**
     * 绘制坦克的方法
     *
     * @param graphics 画笔
     * @param tank     坦克对象
     */
    private void drawTank(Graphics graphics, TankParent tank) {
        int x = tank.getX(); // 坦克 x 坐标
        int y = tank.getY(); // 坦克 y 坐标
        int type = tank.getType(); // 坦克类型
        int direction = tank.getDirection(); // 坦克炮筒的方向
        // 设置不同坦克的颜色
        switch (type) {
            case Constants.HERO_TANK:
                graphics.setColor(Color.ORANGE);
                break;
            case Constants.ENEMY_TANK:
                graphics.setColor(Color.cyan);
                break;
        }
        // 绘制不同方向的坦克
        switch (direction) {
            case Constants.TOP_DIRECTION:
                // 绘制左轮
                graphics.fill3DRect(x, y, 10, 60, false);
                // 绘制中间连接部分
                graphics.fill3DRect(x + 10, y + 10, 20, 40, false);
                // 绘制圆盘
                graphics.fillOval(x + 10, y + 20, 20, 20);
                // 绘制炮筒
                graphics.fill3DRect(x + 19, y, 2, 30, false);
                // 绘制右轮
                graphics.fill3DRect(x + 30, y, 10, 60, false);
                break;
            case Constants.BOTTOM_DIRECTION:
                // 绘制左轮
                graphics.fill3DRect(x, y, 10, 60, false);
                // 绘制中间连接部分
                graphics.fill3DRect(x + 10, y + 10, 20, 40, false);
                // 绘制圆盘
                graphics.fillOval(x + 10, y + 20, 20, 20);
                // 绘制炮筒
                graphics.fill3DRect(x + 19, y + 30, 2, 30, false);
                // 绘制右轮
                graphics.fill3DRect(x + 30, y, 10, 60, false);
                break;
            case Constants.LEFT_DIRECTION:
                // 绘制上轮
                graphics.fill3DRect(x, y, 60, 10, false);
                // 绘制中间连接部分
                graphics.fill3DRect(x + 10, y + 10, 40, 20, false);
                // 绘制圆盘
                graphics.fillOval(x + 20, y + 10, 20, 20);
                // 绘制炮筒
                graphics.fill3DRect(x, y + 19, 30, 2, false);
                // 绘制下轮
                graphics.fill3DRect(x, y + 30, 60, 10, false);
                break;
            case Constants.RIGHT_DIRECTION:
                // 绘制上轮
                graphics.fill3DRect(x, y, 60, 10, false);
                // 绘制中间连接部分
                graphics.fill3DRect(x + 10, y + 10, 40, 20, false);
                // 绘制圆盘
                graphics.fillOval(x + 20, y + 10, 20, 20);
                // 绘制炮筒
                graphics.fill3DRect(x + 30, y + 19, 30, 2, false);
                // 绘制下轮
                graphics.fill3DRect(x, y + 30, 60, 10, false);
                break;
        }
    }

    // 有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 按键按下触发监听
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);
        switch (keyCode) {
            case KeyEvent.VK_W: // 向上
                System.out.println("VK_W");
                mHeroTank.setDirection(Constants.TOP_DIRECTION); // 设置方向
                mHeroTank.moveUp(); // 向上移动
                break;
            case KeyEvent.VK_S: // 向下
                System.out.println("VK_S");
                mHeroTank.setDirection(Constants.BOTTOM_DIRECTION); // 设置方向
                mHeroTank.moveDown(); // 向下移动
                break;
            case KeyEvent.VK_A: // 向左
                System.out.println("VK_A");
                mHeroTank.setDirection(Constants.LEFT_DIRECTION); // 设置方向
                mHeroTank.moveLeft(); // 向左移动
                break;
            case KeyEvent.VK_D: // 向右
                System.out.println("VK_D");
                mHeroTank.setDirection(Constants.RIGHT_DIRECTION); // 设置方向
                mHeroTank.moveRight(); // 向右移动
                break;
        }
        // 让面板重绘
        this.repaint();
    }

    // 按键释放触发监听
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
