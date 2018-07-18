package cn.benzfungus.supermarket.web.form.user;

/**
 * 封装添加用户表单数据
 * @author benzfungus
 *
 */
public class InsertUserWebForm extends UserWebForm {
	
	/**
	 * 添加用户
	 * @return 影响的条目数量
	 */
	public int insertUser() {
		return this.getUdao().insertUser(this);
	}


}
