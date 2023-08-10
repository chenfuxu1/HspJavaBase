package chapter26.mhl.view;

import chapter26.mhl.domain.*;
import chapter26.mhl.service.*;
import chapter26.mhl.utils.Utility;

import java.util.List;

import static chapter26.mhl.utils.Constants.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/8/5 13:52
 * <p>
 * 满汉楼主界面
 **/
public class MHLView {
    private boolean mLoop = true; // 控制是否退出菜单
    private String mUserChoose = ""; // 用户选择
    private EmployeeService mEmployeeService = new EmployeeService(); // 员工相关服务类
    private DiningTableService mDiningTableService = new DiningTableService(); // 餐桌相关服务类
    private MenuService mMenuService = new MenuService(); // 菜谱相关服务类
    private BillService mBillService = new BillService(); // 账单相关服务类
    private MultiTableService mMultiTableService = new MultiTableService(); // 多表查询服务类

    public static void main(String[] args) {
        new MHLView().mainMenu();
    }

    // 显示主菜单
    public void mainMenu() {
        while (mLoop) {
            System.out.println("=================满汉楼=================");
            System.out.println("\t\t1 登录满汉楼");
            System.out.println("\t\t2 退出满汉楼");
            System.out.print("请输入你的选择：");
            mUserChoose = Utility.readString(1);
            switch (mUserChoose) {
                case KEY_LOGIN_MHL: // 登录满汉楼
                    System.out.print("请输入员工号：");
                    String empId = Utility.readString(20);
                    System.out.print("请输入密码：");
                    String empPassword = Utility.readString(20);
                    Employee employee = mEmployeeService.getEmployeeByIdAndPwd(empId, empPassword);
                    // 在数据库判断是否匹配
                    if (employee != null) {
                        // 显示二级菜单界面
                        showSecondMenu(employee);
                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                case KEY_QUIT_MHL: // 退出满汉楼
                    mLoop = false;
                    break;
                default:
                    System.out.println("您输入有误，请重新输入...");
                    break;
            }
        }
        System.out.println("退出满汉楼系统...");
    }

    /**
     * 显示二级菜单界面
     */
    private void showSecondMenu(Employee employee) {
        System.out.println("=========登录满汉楼系统成功[" + employee.getName() + "]============");
        while (mLoop) {
            System.out.println("=================满汉楼二级菜单=================");
            System.out.println("\t\t1 显示餐桌状态");
            System.out.println("\t\t2 预定餐桌");
            System.out.println("\t\t3 显示所有菜品");
            System.out.println("\t\t4 点餐服务");
            System.out.println("\t\t5 查看账单");
            System.out.println("\t\t6 结账");
            System.out.println("\t\t7 查看多表账单");
            System.out.println("\t\t9 退出满汉楼");
            System.out.print("请输入你的选择：");
            mUserChoose = Utility.readString(1);
            switch (mUserChoose) {
                case KEY_SHOW_TABLE_STATUS: // 显示餐桌状态
                    showTableStatus();
                    break;
                case KEY_ORDER_TABLE: // 预定餐桌
                    orderDiningTable();
                    break;
                case KEY_SHOW_ALL_MENUS: // 显示所有菜品
                    showAllMenus();
                    break;
                case KEY_ORDER_SERVICE: // 点餐服务
                    orderMenu();
                    break;
                case KEY_CHECK_BILL: // 查看账单
                    showBillsByTable();
                    break;
                case KEY_CHECKOUT: // 结账
                    payBill();
                    break;
                case KEY_CHECK_MULTI_BILL:
                    showMultiBillsByTable();
                    break;
                case KEY_QUIT_MHL_SECOND: // 退出满汉楼
                    mLoop = false;
                    break;
                default:
                    System.out.println("您输入有误，请重新输入...");
                    break;
            }
        }
    }

    /**
     * 完成结账
     */
    private void payBill() {
        System.out.println("============结账服务==========");
        System.out.print("请选择要结账的桌号(-1 退出)：");
        int diningTableId = Utility.readInt();
        if (diningTableId == -1) {
            System.out.println("取消结账");
            return;
        }
        DiningTable table = mDiningTableService.getTableById(diningTableId);
        if (table == null) {
            System.out.println("输入的餐桌不存在，无法结账");
            return;
        }
        boolean isHasNoPayBill = mBillService.IsHasNoPayBill(diningTableId);
        if (!isHasNoPayBill) {
            System.out.println("无账单需要支付");
            return;
        }
        System.out.print("请选择要结账的方式(现金/支付宝/微信)：");
        String payMode = Utility.readString(10);
        System.out.print("确认是否结账(Y/N)：");
        char input = Utility.readConfirmSelection();
        if (input == 'N') {
            System.out.println("退出结账");
            return;
        }
        mBillService.payBill(diningTableId, payMode);
        System.out.println("============完成结账==========");
    }

    /**
     * 显示餐桌状态信息
     */
    private void showTableStatus() {
        List<DiningTable> tableInfos = mDiningTableService.getAllTableInfo();
        if (tableInfos != null && tableInfos.size() > 0) {
            for (DiningTable tableInfo : tableInfos) {
                System.out.println("id: " + tableInfo.getId() + "\tstate: " + tableInfo.getState()
                        + "\torderName: " + tableInfo.getOrderName() + "\torderTel: " + tableInfo.getOrderTel());
            }
        }
        System.out.println("============显示餐桌状态完毕============");
    }

    /**
     * 预定餐桌
     */
    private void orderDiningTable() {
        System.out.println("============预定餐桌============");
        System.out.print("请选择要预定的餐桌编号(-1 退出)：");
        int orderId = Utility.readInt();
        if (orderId == -1) {
            System.out.println("==========取消预定餐桌==========");
            return;
        }
        // 该方法返回的 Y 或者 N
        char key = Utility.readConfirmSelection();
        if (key == 'Y') { // 需要预定
            DiningTable table = mDiningTableService.getTableById(orderId);
            if (table == null) {
                System.out.println("==========预定餐桌不存在==========");
                return;
            }
            if (!"空".equals(table.getState())) {
                // 餐桌不为空，不能预定
                System.out.println("======餐桌已被他人预定=====");
                return;
            }
            System.out.print("请输入预订人姓名：");
            String orderName = Utility.readString(20);
            System.out.print("请输入预订人号码：");
            String orderTel = Utility.readString(20);
            // 开始预定
            boolean order = mDiningTableService.orderDiningTable(orderId, orderName, orderTel);
            if (order) {
                System.out.println("==========预定餐桌 " + orderId + " 成功==========");
            } else {
                System.out.println("==========预定餐桌失败==========");
            }
        } else {
            System.out.println("==========取消预定餐桌==========");
        }
    }

    /**
     * 显示所有的菜品
     */
    private void showAllMenus() {
        System.out.println("============所有菜品如下==========");
        List<Menu> menus = mMenuService.getAllMenus();
        if (menus == null || menus.size() == 0) {
            return;
        }
        for (Menu menu : menus) {
            System.out.println("id: " + menu.getId() + "\tname: " + menu.getName()
                    + "\t\ttype: " + menu.getType() + "\tprice: " + menu.getPrice());
        }
        System.out.println("============显示完毕==========");
    }

    /**
     * 点菜服务
     */
    private void orderMenu() {
        System.out.println("============开始点餐==========");
        System.out.print("请选择要点餐的桌号(-1 退出)：");
        int diningTableId = Utility.readInt();
        if (diningTableId == -1) {
            System.out.println("取消点餐");
            return;
        }
        DiningTable table = mDiningTableService.getTableById(diningTableId);
        if (table == null) {
            System.out.println("输入的餐桌不存在，无法点餐");
            return;
        }
        System.out.print("请选择要点餐的菜品号(-1 退出)：");
        int menuId = Utility.readInt();
        if (menuId == -1) {
            System.out.println("取消点餐");
            return;
        }
        Menu menu = mMenuService.getMenuById(menuId);
        if (menu == null) {
            System.out.println("输入的菜品不存在，无法点餐");
            return;
        }
        System.out.print("请选择要点餐的菜品数量(-1 退出)：");
        int nums = Utility.readInt();
        if (nums == -1 || nums == 0) {
            System.out.println("取消点餐");
            return;
        }
        boolean success = mBillService.orderMenu(menuId, nums, diningTableId);
        System.out.println("============结束点餐==========");
    }

    /**
     * 显示当前餐桌的账单
     */
    private void showBillsByTable() {
        System.out.println("============展示账单==========");
        System.out.print("请选择要当前的桌号(-1 退出)：");
        int diningTableId = Utility.readInt();
        if (diningTableId == -1) {
            System.out.println("取消查看账单");
            return;
        }
        DiningTable table = mDiningTableService.getTableById(diningTableId);
        if (table == null) {
            System.out.println("输入的餐桌不存在，无法查看");
            return;
        }
        List<Bill> bills = mBillService.getBillsByTableId(diningTableId);
        if (bills == null || bills.size() == 0) {
            System.out.println("当前无账单");
            return;
        }
        for (Bill bill : bills) {
            System.out.println("id: " + bill.getId() + "\tbillId: " + bill.getBillId() + "\tmenuId: " + bill.getMenuId()
                    + "\tnums: " + bill.getNums() + "\tmoney: " + bill.getMoney() + "\tdiningTableId: " + bill.getDiningTableId()
                    + "\tdate: " + bill.getBillDate() + "\tstate: " + bill.getState());
        }
        System.out.println("============展示账单完毕==========");
    }

    /**
     * 多表查询账单
     */
    private void showMultiBillsByTable() {
        System.out.println("============展示多表账单==========");
        System.out.print("请选择要当前的桌号(-1 退出)：");
        int diningTableId = Utility.readInt();
        if (diningTableId == -1) {
            System.out.println("取消查看账单");
            return;
        }
        DiningTable table = mDiningTableService.getTableById(diningTableId);
        if (table == null) {
            System.out.println("输入的餐桌不存在，无法查看");
            return;
        }
        List<MultiTableBean> multiTableBeanList = mMultiTableService.getBillsByTableId(diningTableId);
        if (multiTableBeanList == null || multiTableBeanList.size() == 0) {
            System.out.println("当前无账单");
            return;
        }
        for (MultiTableBean multiTableBean : multiTableBeanList) {
            System.out.println("id: " + multiTableBean.getId() + "\tmenuId: " + multiTableBean.getMenuId()
                    + "\tnums: " + multiTableBean.getNums() + "\tname: " + multiTableBean.getName() + "\ttype: "
                    + multiTableBean.getType() + "\tmoney: " + multiTableBean.getMoney() + "\tdiningTableId: "
                    + multiTableBean.getDiningTableId() + "\tstate: " + multiTableBean.getState());
        }
        System.out.println("============展示多表账单完毕==========");
    }
}
