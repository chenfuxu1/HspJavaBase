package chapter26.mhl.service;

import chapter26.mhl.dao.MultiTableDao;

import chapter26.mhl.domain.MultiTableBean;

import java.util.List;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/8/10 0:13
 *
 * 处理账单相关的业务
 * 该类完成对 bill、menu 表的各种操作(通过调用 MultiTableDao 来完成)
 **/
public class MultiTableService {
    private MultiTableDao mMultiTableDao = new MultiTableDao();

    /**
     * 根据餐桌号，返回对应的账单
     */
    public List<MultiTableBean> getBillsByTableId(int tableId) {
        if (tableId <= 0) {
            return null;
        }
        String sql = "select bill.id, bill.menuId, bill.nums, menu.name, menu.type, bill.money, bill.diningTableId, bill.state " +
                "from bill, menu " +
                "where bill.diningTableId = ? and bill.menuId = menu.id";
        return mMultiTableDao.queryMulti(sql, MultiTableBean.class, tableId);
    }
}
