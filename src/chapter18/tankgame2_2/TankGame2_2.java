package chapter18.tankgame2_2;

import javax.swing.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:57
 * <p>
 * 整个游戏的窗口
 *
 * 新增功能点：
 * 1.我方击中敌方坦克，敌方坦克消失
 *
 * 思路：
 * 1.判断我方子弹的坐标是否进入到敌方坦克坐标范围内(需要遍历所有敌方坦克)
 * 如果进入敌方坦克范围内，那么该坦克存活状态置为 false
 * 2.坦克已销毁那么不去绘制，同时从坦克集合中移除
 *
 **/
public class TankGame2_2 extends JFrame {
    // 定义绘制的画板
    private DrawPanel mDrawPanel;

    public static void main(String[] args) {
        new TankGame2_2();
    }

    public TankGame2_2() {
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
