package chapter26.mhl.service;

import chapter26.mhl.dao.MenuDao;
import chapter26.mhl.domain.Menu;

import java.util.List;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/8/7 23:53
 *
 * 该类完成对 menu 表的各种操作(通过调用 MenuDao 来完成)
 **/
public class MenuService {
    private MenuDao mMenuDao = new MenuDao();

    /**
     * 返回所有的菜谱
     * 如果返回 null，表明没有菜谱
     * @return
     */
    public List<Menu> getAllMenus() {
        String sql = "select * from menu";
        return mMenuDao.queryMulti(sql, Menu.class);
    }

    /**
     * 根据 id 返回单个菜品对象
     */
    public Menu getMenuById(int id) {
        if (id <= 0) {
            return null;
        }
        String sql = "select * from menu where id = ?";
        return mMenuDao.querySingle(sql, Menu.class, id);
    }


}
