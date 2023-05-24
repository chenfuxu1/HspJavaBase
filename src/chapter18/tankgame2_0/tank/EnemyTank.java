package chapter18.tankgame2_0.tank;

import chapter18.tankgame2_0.Constants;
import chapter18.tankgame2_0.tank.TankParent;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/13 11:55
 * <p>
 * 敌方坦克类
 **/
public class EnemyTank extends TankParent {

    public EnemyTank(int x, int y, int direction) {
        super(x, y, direction);
    }

    @Override
    public void initType() {
        mType = Constants.TYPE_ENEMY_TANK;
    }

    @Override
    public void initSpeed() {
        mSpeed = Constants.SPEED_DEFAULT_TANK;
    }
}
