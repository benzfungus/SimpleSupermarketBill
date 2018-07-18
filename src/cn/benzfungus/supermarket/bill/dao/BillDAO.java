package cn.benzfungus.supermarket.bill.dao;

import java.util.List;

import cn.benzfungus.supermarket.entity.Bill;
import cn.benzfungus.supermarket.web.form.bill.InsertBillWebForm;
import cn.benzfungus.supermarket.web.form.bill.UpdateBillWebForm;

/**
 * 账单数据访问对象接口
 * @author benzfungus
 *
 */
public interface BillDAO {
	
	/**
	 * 删除账单
	 * @param id 账单ID
	 * @return 影响的条目数量
	 */
	int deleteBill(String id);

	/**
	 * 查询账单(模糊查询)
	 * @param goodsName 商品名称
	 * @return 账单列表
	 */
	List<Bill> searchBill(String goodsName, String providerId, int paid);
	
	/**
	 * 获取所有账单对象的集合
	 * @return 存放账单对象的List集合
	 */
	List<Bill> getAllBill();
	
	/**
	 * 根据账单ID获取账单对象
	 * @param providerId 供应商ID
	 * @return 账单对象
	 */
	Bill getBillByBillId(String billId);

	/**
	 * 更新账单对象
	 * @param updateBillWebForm 更新账单表单对象
	 * @return 影响的条目数量
	 */
	int updateBill(UpdateBillWebForm updateBillWebForm);

	/**
	 * 添加账单对象
	 * @param insertBillWebForm 添加账单表单对象
	 * @return
	 */
	int insertBill(InsertBillWebForm insertBillWebForm);

}
