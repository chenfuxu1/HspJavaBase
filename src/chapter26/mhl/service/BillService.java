package chapter26.mhl.service;

import chapter26.mhl.dao.BillDao;
import chapter26.mhl.domain.Bill;
import chapter26.mhl.domain.Menu;

import java.util.List;
import java.util.UUID;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/8/7 23:53
 * <p>
 * 处理账单相关的业务
 * 该类完成对 bill 表的各种操作(通过调用 BillDao 来完成)
 **/
public class BillService {
    private BillDao mBillDao = new BillDao();
    private MenuService mMenuService = new MenuService();
    private DiningTableService mDiningTableService = new DiningTableService();

    /**
     * 点餐的方法
     * 1.生成账单
     * 2.需要更新对应餐桌的状态
     */
    public boolean orderMenu(int menuId, int nums, int diningTableId) {
        // 生成一个账单号，UUID
        String billId = UUID.randomUUID().toString();
        String sql = "insert into bill values(null, ?, ?, ?, ?, ?, now(), '未结账')";
        Menu menu = mMenuService.getMenuById(menuId);
        if (menu == null) {
            System.out.println("菜品不存在");
            return false;
        }
        double money = menu.getPrice() * nums;
        int row = mBillDao.update(sql, billId, menuId, nums, money, diningTableId);
        if (row <= 0) {
            System.out.println("点餐失败");
            return false;
        }
        // 更新餐桌的状态为 "就餐中"
        mDiningTableService.updateTableState(diningTableId, "就餐中");
        System.out.println("点餐成功");
        return true;
    }

    /**
     * 根据餐桌号，返回对应的账单
     */
    public List<Bill> getBillsByTableId(int tableId) {
        if (tableId <= 0) {
            return null;
        }
        String sql = "select * from bill where diningTableId = ?";
        return mBillDao.queryMulti(sql, Bill.class, tableId);
    }

    /**
     * 查看某个餐桌是否有未结账的账单
     */
    public boolean IsHasNoPayBill(int tableId) {
        String sql = "select * from bill where diningTableId = ? and state = '未结账' limit 0, 1";
        Bill bill = mBillDao.querySingle(sql, Bill.class, tableId);
        return bill != null;
    }

    /**
     * 结账
     * 1.餐桌存在
     * 2.餐桌有未结账的账单
     */
    public boolean payBill(int tableId, String payMode) {
        /**
         * 这里有两个数据库操作，应该使用事务
         * 后续可以用 ThreadLocal 来接解决，框架中比如 MyBatis 提供了事务支持
         */
        String sql = "update bill set state = ? where diningTableId = ? and state = '未结账'";
        // 1.修改 bill 表
        int row = mBillDao.update(sql, payMode, tableId);
        if (row <= 0) {
            System.out.println("结账失败");
            return false;
        }
        // 2.修改 diningTable 表
        boolean update = mDiningTableService.updateTableStateForFree(tableId);
        if (!update) {
            System.out.println("结账失败");
            return false;
        }
        System.out.println("结账成功");
        return true;
    }
}
