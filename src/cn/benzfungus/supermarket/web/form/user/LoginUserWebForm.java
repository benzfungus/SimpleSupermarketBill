package cn.benzfungus.supermarket.web.form.user;

import cn.benzfungus.supermarket.entity.User;

/**
 * 封装登录表单数据
 * @author benzfungus
 *
 */
public class LoginUserWebForm extends UserWebForm{
	private User user;
	@Override
	public boolean validate() {
		if((user = this.getUdao().validateUser(this.getUsername(), this.getPassword()))!= null) {
			return true;
		}else {
			this.getErrorAlertMessageMap().put("login", "登录失败请检查输入的账号和密码");
			return false;
		}
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
