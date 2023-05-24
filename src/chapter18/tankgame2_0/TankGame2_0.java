package chapter18.tankgame2_0;

import javax.swing.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:57
 * <p>
 * 整个游戏的窗口
 *
 * 新增功能点：
 * 1.用户按下 J 键，我方坦克发射子弹，形成射击效果
 *
 * 思路：
 * 1.当我方发射一个子弹后，相当于启动一个子弹线程
 * 2.让坦克对象持有子弹的对象，子弹对象是一个 runnable，当按下 J 键，启动这个子弹线程
 * 同时不断改变子弹的坐标进行移动，形成一个射击的效果
 * 3.需要将绘制画板也做成一个线程，这样才能做到不断的进行重绘
 * 4.边界限定，当子弹的坐标超出边界就应该销毁，不去展示，同时销毁线程
 **/
public class TankGame2_0 extends JFrame {
    // 定义绘制的画板
    private DrawPanel mDrawPanel;

    public static void main(String[] args) {
        new TankGame2_0();
    }

    public TankGame2_0() {
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
