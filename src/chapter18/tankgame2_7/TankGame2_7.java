package chapter18.tankgame2_7;

import javax.swing.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:57
 * <p>
 * 整个游戏的窗口
 *
 * 新增功能点：
 * 1.敌方坦克发射的子弹消亡后，间隔一段时间，可以再发射子弹
 *
 * 思路：
 * 1.在敌方坦克线程中，不断判断子弹集合是否为空
 * 2.如果为空了，再创建一颗子弹并启动，添加到集合中
 **/
public class TankGame2_7 extends JFrame {
    // 定义绘制的画板
    private DrawPanel mDrawPanel;

    public static void main(String[] args) {
        new TankGame2_7();
    }

    public TankGame2_7() {
        mDrawPanel = new DrawPanel();
        this.add(mDrawPanel);
        // 设置窗口的大小
        this.setSize(Constants.WHOLE_GAME_WIDTH, Constants.WHOLE_GAME_HEIGHT);
        // 设置可以显示
        this.setVisible(true);
        // 当点击窗口的小 ×，程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(mDrawPanel); // 窗口 JFrame 对象可以监听键盘事件, 即可以监听到面板发生的键盘事件
        // 启动画板绘制的线程
        new Thread(mDrawPanel).start();
    }
}
