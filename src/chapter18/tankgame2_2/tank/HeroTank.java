package chapter18.tankgame2_2.tank;

import chapter18.tankgame2_2.Constants;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:50
 * <p>
 * 我方坦克，继承坦克父类
 **/
public class HeroTank extends TankParent {
    public HeroTank(int x, int y) {
        super(x, y);
    }

    public HeroTank(int x, int y, int direction) {
        super(x, y, direction);
    }

    @Override
    public void initType() {
        mType = Constants.TYPE_HERO_TANK;
    }

    @Override
    public void initSpeed() {
        mSpeed = Constants.SPEED_HERO_TANK;
    }
}
