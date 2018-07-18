package cn.benzfungus.supermarket.web.form.provider;

/**
 * 封装更新供应商表单数据
 * @author benzfungus
 *
 */
public class UpdateProviderWebForm extends ProviderWebForm {
	
	/**
	 * 更新供应商信息
	 * @return
	 */
	public int updateProvider() {
		return this.getPdao().updateProvider(this);
	}
	
}
