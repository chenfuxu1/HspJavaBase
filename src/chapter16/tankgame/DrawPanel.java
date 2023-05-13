package chapter16.tankgame;

import javax.swing.*;
import java.awt.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:52
 * <p>
 * 定义游戏绘制的区域
 **/
public class DrawPanel extends JPanel {
    // 坦克炮筒的方向
    private static final int TOP_DIRECTION = 1;
    private static final int BOTTOM_DIRECTION = 2;
    private static final int LEFT_DIRECTION = 3;
    private static final int RIGHT_DIRECTION = 4;
    // 坦克的类型
    private static final int HERO_TANK = 1; // 我方坦克
    private static final int ENEMY_TANK = 2; // 敌方坦克
    // 定义我方的坦克
    private HeroTank mHeroTank;


    public DrawPanel() {
        mHeroTank = new HeroTank(100, 100);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        // 1.设置整个区域背景为黑色
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, 1100, 750);

        drawTank(100, 100, graphics, RIGHT_DIRECTION, HERO_TANK);
        drawTank(200, 200, graphics, TOP_DIRECTION, ENEMY_TANK);
    }

    /**
     * 绘制坦克的方法
     * @param x         坦克的 x 坐标
     * @param y         坦克的 y 坐标
     * @param graphics  画笔
     * @param direction 坦克炮筒的方向
     * @param type      坦克的类型：敌方坦克 / 我方坦克
     */
    public void drawTank(int x, int y, Graphics graphics, int direction, int type) {
        // 设置不同坦克的颜色
        switch (type) {
            case HERO_TANK:
                graphics.setColor(Color.ORANGE);
                break;
            case ENEMY_TANK:
                graphics.setColor(Color.cyan);
                break;
        }
        // 绘制不同方向的坦克
        switch (direction) {
            case TOP_DIRECTION:
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
            case BOTTOM_DIRECTION:
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
            case LEFT_DIRECTION:
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
            case RIGHT_DIRECTION:
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
}
