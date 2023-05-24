package chapter18.tankgame2_7;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/13 10:34
 **/
public class Constants {
    // 整个游戏界面宽高
    public static final int WHOLE_GAME_WIDTH = 1000;
    public static final int WHOLE_GAME_HEIGHT = 750;
    // 坦克炮筒的方向
    public static final int TOP_DIRECTION = 1;
    public static final int BOTTOM_DIRECTION = 2;
    public static final int LEFT_DIRECTION = 3;
    public static final int RIGHT_DIRECTION = 4;
    // 坦克的类型
    public static final int TYPE_HERO_TANK = 1; // 我方坦克
    public static final int TYPE_ENEMY_TANK = 2; // 敌方坦克
    // 坦克移动的速度
    public static final int SPEED_DEFAULT_TANK = 2; // 默认速度
    public static final int SPEED_HERO_TANK = 5; // 我方速度
    // 敌方坦克初始化的数量
    public static final int ENEMY_TANK_SIZE = 8;
    // 子弹移动的速度
    public static final int SPEED_DEFAULT_SHOT = 4; // 默认子弹速度
    public static final int SPEED_HERO_SHOT = 7; // 我方子弹速度
    // 子弹的类型
    public static final int TYPE_HERO_BULLET = 1; // 我方子弹
    public static final int TYPE_ENEMY_BULLET = 2; // 敌方子弹
    // 敌人默认子弹数量
    public static final int ENEMY_TANK_BULLET_NUM = 1;
    // 我方坦克最大发射子弹数量
    public static final int HERO_TANK_BULLET_MAX_NUM = 5;
}
