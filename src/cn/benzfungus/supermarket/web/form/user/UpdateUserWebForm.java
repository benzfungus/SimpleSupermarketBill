package cn.benzfungus.supermarket.web.form.user;

/**
 * 封装更新用户表单数据
 * @author benzfungus
 *
 */
public class UpdateUserWebForm extends UserWebForm {
	
	/**
	 * 更新用户信息 
	 * @return 影响的条目数量
	 */
	public int updateUser() {
		return this.getUdao().updateUser(this);
	}
}
