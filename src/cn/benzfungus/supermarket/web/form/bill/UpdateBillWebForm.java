package cn.benzfungus.supermarket.web.form.bill;

/**
 * 封装更新账单表单数据
 * @author benzfungus
 *
 */
public class UpdateBillWebForm extends BillWebForm{
	
	/**
	 * 更新账单
	 * @return 影响的条目数量
	 */
	public int updateBill() {
		return this.getBdao().updateBill(this);
	}
	
}
