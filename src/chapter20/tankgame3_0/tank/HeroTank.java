package chapter20.tankgame3_0.tank;

import chapter20.tankgame3_0.Constants;
import chapter20.tankgame3_0.shot.HeroShot;

import java.util.Vector;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:50
 * <p>
 * 我方坦克，继承坦克父类
 **/
public class HeroTank extends TankParent {
    private Vector<HeroShot> mHeroShots = new Vector<>(); // 坦克子弹集合

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

    /**
     * 构建射击方法
     * @param
     */
    public void buildHeroShotBullet() {
        if (mHeroShots.size() >= Constants.HERO_TANK_BULLET_MAX_NUM) {
            return;
        }
        HeroShot heroShot = null;
        switch (getDirection()) {
            case Constants.TOP_DIRECTION:
                heroShot = new HeroShot(getX() + 18, getY(), Constants.TOP_DIRECTION);
                break;
            case Constants.BOTTOM_DIRECTION:
                heroShot = new HeroShot(getX() + 18, getY() + 60, Constants.BOTTOM_DIRECTION);
                break;
            case Constants.LEFT_DIRECTION:
                heroShot = new HeroShot(getX(), getY() + 18, Constants.LEFT_DIRECTION);
                break;
            case Constants.RIGHT_DIRECTION:
                heroShot = new HeroShot(getX() + 60, getY() + 18, Constants.RIGHT_DIRECTION);
                break;
        }
        // 启动子弹射击线程
        new Thread(heroShot).start();
        mHeroShots.add(heroShot);
    }

    public Vector<HeroShot> getHeroShots() {
        return mHeroShots;
    }

    public void setHeroShots(Vector<HeroShot> heroShots) {
        mHeroShots.clear();
        mHeroShots.addAll(heroShots);
    }
}
