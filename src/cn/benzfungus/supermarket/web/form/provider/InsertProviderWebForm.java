package cn.benzfungus.supermarket.web.form.provider;

/**
 * 封装添加供应商表单数据
 * @author benzfungus
 *
 */
public class InsertProviderWebForm extends ProviderWebForm {
	
	/**
	 * 添加供应商
	 * @return
	 */
	public int insertProvider() {
		return this.getPdao().insertProvider(this);
	}
	
}
