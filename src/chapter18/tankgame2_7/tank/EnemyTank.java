package chapter18.tankgame2_7.tank;

import chapter18.tankgame2_7.Constants;
import chapter18.tankgame2_7.shot.EnemyShot;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Vector;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/13 11:55
 * <p>
 * 敌方坦克类
 **/
public class EnemyTank extends TankParent implements Runnable {
    private Vector<EnemyShot> mEnemyShots = new Vector<>(); // 坦克子弹集合
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (mEnemyShot != null) {
                new Thread(mEnemyShot).start();
            }
        }
    };
    private EnemyShot mEnemyShot = null;

    public EnemyTank(int x, int y, int direction) {
        super(x, y, direction);
        initShotBullet();
    }

    @Override
    public void initType() {
        mType = Constants.TYPE_ENEMY_TANK;
    }

    @Override
    public void initSpeed() {
        mSpeed = Constants.SPEED_DEFAULT_TANK;
    }

    /**
     * 初始化子弹集合
     */
    private void initShotBullet() {
        for (int i = 0; i < Constants.ENEMY_TANK_BULLET_NUM; i++) {
            EnemyShot enemyShot = buildEnemyShotBullet(getX(), getY(), getDirection());
            mEnemyShots.add(enemyShot);
            new Thread(enemyShot).start();
        }
    }

    /**
     * 构建射击方法
     * @param
     */
    private EnemyShot buildEnemyShotBullet(int x, int y, int direction) {
        switch (direction) {
            case Constants.TOP_DIRECTION:
                mEnemyShot = new EnemyShot(x + 18, y, Constants.TOP_DIRECTION);
                break;
            case Constants.BOTTOM_DIRECTION:
                mEnemyShot = new EnemyShot(x + 18, y + 60, Constants.BOTTOM_DIRECTION);
                break;
            case Constants.LEFT_DIRECTION:
                mEnemyShot = new EnemyShot(x, y + 18, Constants.LEFT_DIRECTION);
                break;
            case Constants.RIGHT_DIRECTION:
                mEnemyShot = new EnemyShot(x + 60, y + 18, Constants.RIGHT_DIRECTION);
                break;
        }
        return mEnemyShot;
    }

    public Vector<EnemyShot> getEnemyShots() {
        return mEnemyShots;
    }

    public void setEnemyShots(Vector<EnemyShot> enemyShots) {
        mEnemyShots = enemyShots;
    }

    @Override
    public void run() {
        while (isLived()) {
            /**
             * 判断当前子弹集合是否为空
             * 如果为空，间隔 1s 后，再重新创建一颗子弹启动并添加到集合中
             */
            if (mEnemyShots.isEmpty()) {
                mEnemyShot = buildEnemyShotBullet(getX(), getY(), getDirection());
                mEnemyShots.add(mEnemyShot);
                new Thread(mRunnable).start();
            }
            // 每隔 50 ms 让沿着当前的方向移动一次，一共移动 80 次，改变一次方向
            for (int i = 0; i <80; i++) {
                switch (getDirection()) {
                    case Constants.TOP_DIRECTION:
                        moveUp();
                        break;
                    case Constants.BOTTOM_DIRECTION:
                        moveDown();
                        break;
                    case Constants.LEFT_DIRECTION:
                        moveLeft();
                        break;
                    case Constants.RIGHT_DIRECTION:
                        moveRight();
                        break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            /**
             * 随机改变一次坦克的方向
             * 方向的范围在：1-4
             * Math.random() 的范围：[0, 1)
             */
            setDirection((int) (Math.random() * 4 + 1));
        }
    }
}
