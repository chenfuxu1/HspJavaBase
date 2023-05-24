package chapter18.tankgame2_8;

import javax.swing.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:57
 * <p>
 * 整个游戏的窗口
 *
 * 新增功能点：
 * 1.敌方坦克击中我方，我方坦克发生爆炸
 *
 * 思路：
 * 1.遍历所有的敌方坦克，取出所有存活的子弹
 * 2.一一与我方坦克进行遍历，检测是否发生了碰撞
 * 3.发生了碰撞就创建一个爆炸类进行爆炸显示
 * 4.将我方坦克存活状态置为 false，碰撞的子弹置为 false，从集合中移除
 **/
public class TankGame2_8 extends JFrame {
    // 定义绘制的画板
    private DrawPanel mDrawPanel;

    public static void main(String[] args) {
        new TankGame2_8();
    }

    public TankGame2_8() {
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
