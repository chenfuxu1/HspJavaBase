package chapter26.mhl.service;

import chapter26.mhl.dao.DiningTableDao;
import chapter26.mhl.domain.DiningTable;

import java.util.List;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/8/6 23:25
 * <p>
 * 该类完成对 diningTable 表的各种操作(通过调用 DiningTableDao 来完成)
 **/
public class DiningTableService {
    private DiningTableDao mDiningTableDao = new DiningTableDao();


    /**
     * 获取所有的餐桌信息
     *
     * @return
     */
    public List<DiningTable> getAllTableInfo() {
        String sql = "select * from diningTable";
        List<DiningTable> tables = mDiningTableDao.queryMulti(sql, DiningTable.class);
        return tables;
    }

    /**
     * 根据餐桌的 id，查询对应的餐桌对象
     * 如果返回 null，表明 id 对应的餐桌不存在
     */
    public DiningTable getTableById(int id) {
        if (id < 0) {
            return null;
        }
        String sql = "select * from diningTable where id = ?";
        return mDiningTableDao.querySingle(sql, DiningTable.class, id);
    }

    /**
     * 如果餐桌可以预定，调用方法，对餐桌状态进行更新
     */
    public boolean orderDiningTable(int id, String orderName, String orderTel) {
        String sql = "update diningTable set state = '已预订', orderName = ?, orderTel = ? where id = ?";
        int row = mDiningTableDao.update(sql, orderName, orderTel, id);
        return row > 0;
    }

    /**
     * 更新餐桌的状态
     */
    public boolean updateTableState(int id, String state) {
        if (id <= 0 || state == null) {
            return false;
        }
        String sql = "update diningTable set state = ? where id = ?";
        int row = mDiningTableDao.update(sql, state, id);
        if (row <= 0) {
            System.out.println("更新餐桌状态失败");
            return false;
        }
        System.out.println("更新餐桌状态成功");
        return true;
    }

    /**
     * 将餐桌状态复位
     */
    public boolean updateTableStateForFree(int id) {
        if (id <= 0) {
            return false;
        }
        String sql = "update diningTable set state = '空', orderName = '', orderTel = '' where id = ?";
        int update = mDiningTableDao.update(sql, id);
        if (update <= 0) {
            System.out.println("复位餐桌状态失败");
            return false;
        }
        System.out.println("成功复位餐桌状态");
        return true;
    }

}
