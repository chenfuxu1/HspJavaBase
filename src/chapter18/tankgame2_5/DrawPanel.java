package chapter18.tankgame2_5;

import chapter18.tankgame2_5.shot.EnemyShot;
import chapter18.tankgame2_5.shot.HeroShot;
import chapter18.tankgame2_5.shot.ShotParent;
import chapter18.tankgame2_5.tank.EnemyTank;
import chapter18.tankgame2_5.tank.HeroTank;
import chapter18.tankgame2_5.tank.TankParent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:52
 * <p>
 * 定义游戏绘制的区域
 * 为了监听键盘事件，需要实现 KeyListener
 * <p>
 * 因为需要不断重绘，所以需要将 DrawPanel 做成一个线程，实现 Runnable 接口
 * 每隔一段时间一直重新绘制
 **/
public class DrawPanel extends JPanel implements KeyListener, Runnable {
    // 定义我方的坦克
    private HeroTank mHeroTank;
    /**
     * 定义敌方坦克，因为有多个，用集合管理
     * 因为多线程，所以用 Vector 集合
     */
    private Vector<EnemyTank> mEnemyTanks = new Vector<>();
    // 存储炸弹的集合，每当检测到碰撞，添加炸弹
    private Vector<Bomb> mBombs = new Vector<>();
    // 爆炸效果需要的三张图片
    private Image mBombImage1 = null;
    private Image mBombImage2 = null;
    private Image mBombImage3 = null;

    public DrawPanel() {
        // 初始化我方坦克
        mHeroTank = new HeroTank(150, 300, Constants.TOP_DIRECTION);
        // 初始化敌方坦克集合
        for (int i = 0; i < Constants.ENEMY_TANK_SIZE; i++) {
            /**
             * 随机改变一次坦克的方向
             * 方向的范围在：1-4
             * Math.random() 的范围：[0, 1)
             */
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 20, (int) (Math.random() * 4 + 1));
            // 启动敌方坦克线程
            new Thread(enemyTank).start();
            mEnemyTanks.add(enemyTank);
        }
        initBombImages();
    }

    // 初始化爆破的图片
    private void initBombImages() {
        mBombImage1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        mBombImage2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        mBombImage3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        // 1.设置整个区域背景为黑色
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, Constants.WHOLE_GAME_WIDTH, Constants.WHOLE_GAME_HEIGHT);

        // 2.绘制我方坦克
        drawTank(graphics, mHeroTank);

        /**
         * 3.绘制我方坦克发射的子弹
         * 子弹存在，并且是存活的状态，才进行绘制
         */
        if (mHeroTank.getShot() != null && mHeroTank.getShot().isLive()) {
            drawBullet(graphics, mHeroTank.getShot());
        }

        // 绘制爆炸效果
        drawBomb(graphics);

        // 4.绘制敌方坦克
        for (int i = 0; i < mEnemyTanks.size(); i++) {
            EnemyTank enemyTank = mEnemyTanks.get(i);
            if (enemyTank != null && enemyTank.isLived()) {
                drawTank(graphics, enemyTank);
                // 5.遍历绘制坦克的子弹
                Vector<EnemyShot> enemyShots = enemyTank.getEnemyShots();
                if (enemyShots != null && enemyShots.size() > 0) {
                    for (int j = 0; j < enemyShots.size(); j++) {
                        EnemyShot enemyShot = enemyShots.get(j);
                        if (enemyShot != null && enemyShot.isLive()) {
                            drawBullet(graphics, enemyShot);
                        } else {
                            enemyShots.remove(enemyShot);
                        }
                    }
                }
            }
        }

    }

    /**
     * 检测坦克是否被子弹击中
     *
     * @param shot 子弹
     * @param tank 坦克
     *             true：被击中 false: 未被击中
     */
    private boolean checkTankIsShoted(ShotParent shot, TankParent tank) {
        if (shot == null || tank == null) {
            return false;
        }
        int tankDirection = tank.getDirection();
        switch (tankDirection) {
            case Constants.TOP_DIRECTION:
            case Constants.BOTTOM_DIRECTION:
                if (shot.getX() > tank.getX() && shot.getX() < (tank.getX() + 40) && shot.getY() > tank.getY() && shot.getY() < (tank.getY() + 60)) {
                    // 检测到碰撞了，往炸弹集合里面添加炸弹
                    mBombs.add(new Bomb(tank.getX(), tank.getY()));
                    return true;
                }
                break;
            case Constants.LEFT_DIRECTION:
            case Constants.RIGHT_DIRECTION:
                if (shot.getX() > tank.getX() && shot.getX() < (tank.getX() + 60) && shot.getY() > tank.getY() && shot.getY() < (tank.getY() + 40)) {
                    // 检测到碰撞了，往炸弹集合里面添加炸弹
                    mBombs.add(new Bomb(tank.getX(), tank.getY()));
                    return true;
                }
                break;
        }
        return false;
    }

    /**
     * 绘制坦克的方法
     *
     * @param graphics 画笔
     * @param tank     坦克对象
     */
    private void drawTank(Graphics graphics, TankParent tank) {
        if (!tank.isLived()) {
            return;
        }
        int x = tank.getX(); // 坦克 x 坐标
        int y = tank.getY(); // 坦克 y 坐标
        int type = tank.getType(); // 坦克类型
        int direction = tank.getDirection(); // 坦克炮筒的方向
        // 设置不同坦克的颜色
        switch (type) {
            case Constants.TYPE_HERO_TANK:
                graphics.setColor(Color.ORANGE);
                break;
            case Constants.TYPE_ENEMY_TANK:
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

    /**
     * 绘制子弹的方法
     *
     * @param graphics 画笔
     * @param shot     子弹对象
     */
    private void drawBullet(Graphics graphics, ShotParent shot) {
        int x = shot.getX(); // 子弹 x 坐标
        int y = shot.getY(); // 子弹 y 坐标
        int type = shot.getType(); // 子弹类型
        // 设置不同子弹的颜色
        switch (type) {
            case Constants.TYPE_HERO_BULLET:
                graphics.setColor(Color.ORANGE);
                break;
            case Constants.TYPE_ENEMY_BULLET:
                graphics.setColor(Color.cyan);
                break;
        }
        // 绘制子弹
        graphics.drawOval(x, y, 4, 4);
    }

    /**
     * 绘制爆破效果
     * @param graphics
     */
    private void drawBomb(Graphics graphics) {
        for (int i = 0; i < mBombs.size(); i++) {
            Bomb bomb = mBombs.get(i);
            if (bomb != null && bomb.isLive()) {
                int life = bomb.getLife();
                if (life > 12) {
                    graphics.drawImage(mBombImage1, bomb.getX(), bomb.getY(), 60, 60, this);
                } else if (life > 6) {
                    graphics.drawImage(mBombImage2, bomb.getX(), bomb.getY(), 60, 60, this);
                } else {
                    graphics.drawImage(mBombImage3, bomb.getX(), bomb.getY(), 60, 60, this);
                }
                bomb.bombLifeDown();
                if (!bomb.isLive()) {
                    mBombs.remove(bomb);
                }
            }
        }
    }

    /**
     * 构造我方坦克射击方法
     *
     * @param tank
     */
    private void buildHeroShotBullet(TankParent tank) {
        if (tank == null) {
            return;
        }
        HeroShot heroShot = null;
        switch (tank.getDirection()) {
            case Constants.TOP_DIRECTION:
                heroShot = new HeroShot(tank.getX() + 18, tank.getY(), Constants.TOP_DIRECTION);
                break;
            case Constants.BOTTOM_DIRECTION:
                heroShot = new HeroShot(tank.getX() + 18, tank.getY() + 60, Constants.BOTTOM_DIRECTION);
                break;
            case Constants.LEFT_DIRECTION:
                heroShot = new HeroShot(tank.getX(), tank.getY() + 18, Constants.LEFT_DIRECTION);
                break;
            case Constants.RIGHT_DIRECTION:
                heroShot = new HeroShot(tank.getX() + 60, tank.getY() + 18, Constants.RIGHT_DIRECTION);
                break;
        }
        tank.setShot(heroShot);
        tank.shotBullet();
    }

    // 有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 按键按下触发监听
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // System.out.println(keyCode);
        switch (keyCode) {
            case KeyEvent.VK_W: // 向上
                mHeroTank.setDirection(Constants.TOP_DIRECTION); // 设置方向
                mHeroTank.moveUp(); // 向上移动
                break;
            case KeyEvent.VK_S: // 向下
                mHeroTank.setDirection(Constants.BOTTOM_DIRECTION); // 设置方向
                mHeroTank.moveDown(); // 向下移动
                break;
            case KeyEvent.VK_A: // 向左
                mHeroTank.setDirection(Constants.LEFT_DIRECTION); // 设置方向
                mHeroTank.moveLeft(); // 向左移动
                break;
            case KeyEvent.VK_D: // 向右
                mHeroTank.setDirection(Constants.RIGHT_DIRECTION); // 设置方向
                mHeroTank.moveRight(); // 向右移动
                break;
            case KeyEvent.VK_J: // 我方坦克射击
                buildHeroShotBullet(mHeroTank);
                break;
        }
        System.out.println("mHeroTank.getX() = " + mHeroTank.getX() + " mHeroTank.getY() = " + mHeroTank.getY());
        // 让面板重绘
        this.repaint();
    }

    // 按键释放触发监听
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 判断我方子弹是否击中敌方坦克
            if (mHeroTank != null && mHeroTank.getShot() != null && mHeroTank.getShot().isLive()) {
                // 遍历敌方所有的坦克
                for (int i = 0; i < mEnemyTanks.size(); i++) {
                    EnemyTank enemyTank = mEnemyTanks.get(i);
                    // 检测坦克是否被击中
                    boolean tankIsShoted = checkTankIsShoted(mHeroTank.getShot(), enemyTank);
                    if (tankIsShoted) {
                        enemyTank.setLived(false);
                        mHeroTank.getShot().setLive(false);
                        mEnemyTanks.remove(enemyTank);
                        break;
                    }
                }
            }
            // 每隔 30 ms，重新绘制刷新一次
            this.repaint();
        }

    }
}
