package chapter18.tankgame2_1.tank;

import chapter18.tankgame2_1.Constants;
import chapter18.tankgame2_1.shot.EnemyShot;

import java.util.Vector;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/13 11:55
 * <p>
 * 敌方坦克类
 **/
public class EnemyTank extends TankParent {
    private Vector<EnemyShot> mEnemyShots = new Vector<>(); // 坦克子弹集合

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
            EnemyShot enemyShot = new EnemyShot(getX(), getY(), getDirection());
            mEnemyShots.add(enemyShot);
            new Thread(enemyShot).start();
        }
    }

    public Vector<EnemyShot> getEnemyShots() {
        return mEnemyShots;
    }

    public void setEnemyShots(Vector<EnemyShot> enemyShots) {
        mEnemyShots = enemyShots;
    }
}
