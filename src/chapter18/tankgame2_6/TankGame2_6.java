package chapter18.tankgame2_6;

import javax.swing.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:57
 * <p>
 * 整个游戏的窗口
 *
 * 新增功能点：
 * 1.我方坦克可以发射多颗子弹(最多发射五颗)
 *
 * 思路：
 * 1.我方坦克维护子弹集合
 * 2.每按 J 键一次，就创建一个子弹线程并启动
 * 3.限制集合的个数，最多添加五颗子弹
 * 4.绘制时，遍历我方坦克子弹集合，循环进行绘制
 * 5.检测碰撞时，循环遍历我方子弹集合与循环遍历敌方坦克，一一检测碰撞
 * 如果发生碰撞，将我方子弹从集合移除，敌方坦克从坦克集合中移除
 **/
public class TankGame2_6 extends JFrame {
    // 定义绘制的画板
    private DrawPanel mDrawPanel;

    public static void main(String[] args) {
        new TankGame2_6();
    }

    public TankGame2_6() {
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
