package cn.benzfungus.supermarket.web.form.bill;


/**
 * 封装添加账单网页表单数据对象
 * @author benzfungus
 *
 */
public class InsertBillWebForm extends BillWebForm {
	
	/**
	 * 添加账单
	 * @return 影响的条目数量
	 */
	public int insertBill() {
		return this.getBdao().insertBill(this);
	}

	
	
	
	
}
