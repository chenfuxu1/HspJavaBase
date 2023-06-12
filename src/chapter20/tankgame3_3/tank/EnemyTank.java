package chapter20.tankgame3_3.tank;

import chapter20.tankgame3_3.Constants;
import chapter20.tankgame3_3.shot.EnemyShot;

import java.io.Serializable;
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
    private Vector<EnemyTank> mEnemyTanks = new Vector<>(); // 每个敌方坦克都持有敌方坦克的集合，便于比较是否发生重叠

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

    public Vector<EnemyTank> getEnemyTanks() {
        return mEnemyTanks;
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        mEnemyTanks.clear();
        mEnemyTanks.addAll(enemyTanks);
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
     *
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

    /**
     * 检测当前的敌方坦克与其他敌方坦克是否发生了重叠
     * false: 未重叠 true：发生了重叠
     */
    private boolean checkEnemyTanksOverlap() {
        switch (this.getDirection()) {
            case Constants.TOP_DIRECTION: // 当前敌方坦克方向向上
                /**
                 * 1.坦克向上，其余坦在上下方向时，分别检测自己坦克的 (x, y)、(x+40, y) 坐标是否落入
                 * [x, x+40]、[y, y+60] 即可检测碰撞
                 *
                 * 2.坦克向上，其余坦在左右方向时，分别检测自己坦克的 (x, y)、(x+40, y) 坐标是否落入
                 * [x, x+60]、[y, y+40] 即可检测碰撞
                 */
                for (int i = 0; i < mEnemyTanks.size(); i++) {
                    EnemyTank otherEnemyTank = mEnemyTanks.get(i);
                    if (otherEnemyTank == this) {
                        // 不和自己进行比较
                        continue;
                    }
                    if (otherEnemyTank != null) {
                        switch (otherEnemyTank.getDirection()) {
                            case Constants.TOP_DIRECTION:
                            case Constants.BOTTOM_DIRECTION:
                                // 检测自己的 (x, y) 坐标是否在 [x, x+40]、[y, y+60] 范围内
                                if ((this.getX() >= otherEnemyTank.getX()) && (this.getX() <= (otherEnemyTank.getX() + 40)) &&
                                        (this.getY() >= otherEnemyTank.getY()) && (this.getY() <= (otherEnemyTank.getY() + 60))) {
                                    return true;
                                }
                                // 检测自己的 (x+40, y) 坐标是否在 [x, x+40]、[y, y+60] 范围内
                                if (((this.getX() + 40) >= otherEnemyTank.getX()) && ((this.getX() + 40) <= (otherEnemyTank.getX() + 40)) &&
                                        (this.getY() >= otherEnemyTank.getY()) && (this.getY() <= (otherEnemyTank.getY() + 60))) {
                                    return true;
                                }
                                break;
                            case Constants.LEFT_DIRECTION:
                            case Constants.RIGHT_DIRECTION:
                                // 检测自己的 (x, y) 坐标是否在 [x, x+60]、[y, y+40] 范围内
                                if ((this.getX() >= otherEnemyTank.getX()) && (this.getX() <= (otherEnemyTank.getX() + 60)) &&
                                        (this.getY() >= otherEnemyTank.getY()) && (this.getY() <= (otherEnemyTank.getY() + 40))) {
                                    return true;
                                }
                                // 检测自己的 (x+40, y) 坐标是否在 [x, x+60]、[y, y+40] 范围内
                                if (((this.getX() + 40) >= otherEnemyTank.getX()) && ((this.getX() + 40) <= (otherEnemyTank.getX() + 60)) &&
                                        (this.getY() >= otherEnemyTank.getY()) && (this.getY() <= (otherEnemyTank.getY() + 40))) {
                                    return true;
                                }
                                break;
                        }
                    }
                }
                break;
            case Constants.BOTTOM_DIRECTION: // 当前敌方坦克方向向下
                /**
                 * 3.坦克向下，其余坦在上下方向时，分别检测自己坦克的 (x, y+60)、(x+40, y+60) 坐标是否落入
                 * [x, x+40]、[y, y+60] 即可检测碰撞
                 *
                 * 4.坦克向下，其余坦在左右方向时，分别检测自己坦克的 (x, y+60)、(x+40, y+60) 坐标是否落入
                 * [x, x+60]、[y, y+40] 即可检测碰撞
                 */
                for (int i = 0; i < mEnemyTanks.size(); i++) {
                    EnemyTank otherEnemyTank = mEnemyTanks.get(i);
                    if (otherEnemyTank == this) {
                        // 不和自己进行比较
                        continue;
                    }
                    if (otherEnemyTank != null) {
                        switch (otherEnemyTank.getDirection()) {
                            case Constants.TOP_DIRECTION:
                            case Constants.BOTTOM_DIRECTION:
                                // 检测自己的 (x, y+60) 坐标是否在 [x, x+40]、[y, y+60] 范围内
                                if ((this.getX() >= otherEnemyTank.getX()) && (this.getX() <= (otherEnemyTank.getX() + 40)) &&
                                        ((this.getY() + 60) >= otherEnemyTank.getY()) && ((this.getY() + 60) <= (otherEnemyTank.getY() + 60))) {
                                    return true;
                                }
                                // 检测自己的 (x+40, y+60) 坐标是否在 [x, x+40]、[y, y+60] 范围内
                                if (((this.getX() + 40) >= otherEnemyTank.getX()) && ((this.getX() + 40) <= (otherEnemyTank.getX() + 40)) &&
                                        ((this.getY() + 60) >= otherEnemyTank.getY()) && ((this.getY() + 60) <= (otherEnemyTank.getY() + 60))) {
                                    return true;
                                }
                                break;
                            case Constants.LEFT_DIRECTION:
                            case Constants.RIGHT_DIRECTION:
                                // 检测自己的 (x, y+60) 坐标是否在 [x, x+60]、[y, y+40] 范围内
                                if ((this.getX() >= otherEnemyTank.getX()) && (this.getX() <= (otherEnemyTank.getX() + 60)) &&
                                        ((this.getY() + 60) >= otherEnemyTank.getY()) && ((this.getY() + 60) <= (otherEnemyTank.getY() + 40))) {
                                    return true;
                                }
                                // 检测自己的 (x+40, y+60) 坐标是否在 [x, x+60]、[y, y+40] 范围内
                                if (((this.getX() + 40) >= otherEnemyTank.getX()) && ((this.getX() + 40) <= (otherEnemyTank.getX() + 60)) &&
                                        ((this.getY() + 60) >= otherEnemyTank.getY()) && ((this.getY() + 60) <= (otherEnemyTank.getY() + 40))) {
                                    return true;
                                }
                                break;
                        }
                    }
                }
                break;
            case Constants.LEFT_DIRECTION: // 当前敌方坦克方向向左
                /**
                 * 5.坦克向左，其余坦在上下方向时，分别检测自己坦克的 (x, y)、(x, y+40) 坐标是否落入
                 * [x, x+40]、[y, y+60] 即可检测碰撞
                 *
                 * 6.坦克向左，其余坦在左右方向时，分别检测自己坦克的 (x, y)、(x, y+40) 坐标是否落入
                 * [x, x+60]、[y, y+40] 即可检测碰撞
                 */
                for (int i = 0; i < mEnemyTanks.size(); i++) {
                    EnemyTank otherEnemyTank = mEnemyTanks.get(i);
                    if (otherEnemyTank == this) {
                        // 不和自己进行比较
                        continue;
                    }
                    if (otherEnemyTank != null) {
                        switch (otherEnemyTank.getDirection()) {
                            case Constants.TOP_DIRECTION:
                            case Constants.BOTTOM_DIRECTION:
                                // 检测自己的 (x, y) 坐标是否在 [x, x+40]、[y, y+60] 范围内
                                if ((this.getX() >= otherEnemyTank.getX()) && (this.getX() <= (otherEnemyTank.getX() + 40)) &&
                                        (this.getY() >= otherEnemyTank.getY()) && (this.getY() <= (otherEnemyTank.getY() + 60))) {
                                    return true;
                                }
                                // 检测自己的 (x, y+40) 坐标是否在 [x, x+40]、[y, y+60] 范围内
                                if ((this.getX() >= otherEnemyTank.getX()) && (this.getX() <= (otherEnemyTank.getX() + 40)) &&
                                        ((this.getY() + 40) >= otherEnemyTank.getY()) && ((this.getY() + 40) <= (otherEnemyTank.getY() + 60))) {
                                    return true;
                                }
                                break;
                            case Constants.LEFT_DIRECTION:
                            case Constants.RIGHT_DIRECTION:
                                // 检测自己的 (x, y) 坐标是否在 [x, x+60]、[y, y+40] 范围内
                                if ((this.getX() >= otherEnemyTank.getX()) && (this.getX() <= (otherEnemyTank.getX() + 60)) &&
                                        (this.getY() >= otherEnemyTank.getY()) && (this.getY() <= (otherEnemyTank.getY() + 40))) {
                                    return true;
                                }
                                // 检测自己的 (x, y+40) 坐标是否在 [x, x+60]、[y, y+40] 范围内
                                if ((this.getX() >= otherEnemyTank.getX()) && (this.getX() <= (otherEnemyTank.getX() + 60)) &&
                                        ((this.getY() + 40) >= otherEnemyTank.getY()) && ((this.getY() + 40) <= (otherEnemyTank.getY() + 40))) {
                                    return true;
                                }
                                break;
                        }
                    }
                }
                break;
            case Constants.RIGHT_DIRECTION: // 当前敌方坦克方向向右
                /**
                 * 7.坦克向右，其余坦在上下方向时，分别检测自己坦克的 (x+60, y)、(x+60, y+40) 坐标是否落入
                 * [x, x+40]、[y, y+60] 即可检测碰撞
                 *
                 * 8.坦克向右，其余坦在左右方向时，分别检测自己坦克的 (x+60, y)、(x+60, y+40) 坐标是否落入
                 * [x, x+60]、[y, y+40] 即可检测碰撞
                 */
                for (int i = 0; i < mEnemyTanks.size(); i++) {
                    EnemyTank otherEnemyTank = mEnemyTanks.get(i);
                    if (otherEnemyTank == this) {
                        // 不和自己进行比较
                        continue;
                    }
                    if (otherEnemyTank != null) {
                        switch (otherEnemyTank.getDirection()) {
                            case Constants.TOP_DIRECTION:
                            case Constants.BOTTOM_DIRECTION:
                                // 检测自己的 (x+60, y) 坐标是否在 [x, x+40]、[y, y+60] 范围内
                                if (((this.getX() + 60) >= otherEnemyTank.getX()) && ((this.getX() + 60) <= (otherEnemyTank.getX() + 40)) &&
                                        (this.getY() >= otherEnemyTank.getY()) && (this.getY() <= (otherEnemyTank.getY() + 60))) {
                                    return true;
                                }
                                // 检测自己的 (x+60, y+40) 坐标是否在 [x, x+40]、[y, y+60] 范围内
                                if (((this.getX() + 60) >= otherEnemyTank.getX()) && ((this.getX() + 60) <= (otherEnemyTank.getX() + 40)) &&
                                        ((this.getY() + 40) >= otherEnemyTank.getY()) && ((this.getY() + 40) <= (otherEnemyTank.getY() + 60))) {
                                    return true;
                                }
                                break;
                            case Constants.LEFT_DIRECTION:
                            case Constants.RIGHT_DIRECTION:
                                // 检测自己的 (x+60, y) 坐标是否在 [x, x+60]、[y, y+40] 范围内
                                if (((this.getX() + 60) >= otherEnemyTank.getX()) && ((this.getX() + 60) <= (otherEnemyTank.getX() + 60)) &&
                                        (this.getY() >= otherEnemyTank.getY()) && (this.getY() <= (otherEnemyTank.getY() + 40))) {
                                    return true;
                                }
                                // 检测自己的 (x+60, y+40) 坐标是否在 [x, x+60]、[y, y+40] 范围内
                                if (((this.getX() + 60) >= otherEnemyTank.getX()) && ((this.getX() + 60) <= (otherEnemyTank.getX() + 60)) &&
                                        ((this.getY() + 40) >= otherEnemyTank.getY()) && ((this.getY() + 40) <= (otherEnemyTank.getY() + 40))) {
                                    return true;
                                }
                                break;
                        }
                    }
                }
                break;
        }
        return false;
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
            for (int i = 0; i < 80; i++) {
                try {
                    if (!checkEnemyTanksOverlap()) {
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
                        Thread.sleep(40);
                    } else {
                        Thread.sleep(1500);
                        break;
                    }

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
