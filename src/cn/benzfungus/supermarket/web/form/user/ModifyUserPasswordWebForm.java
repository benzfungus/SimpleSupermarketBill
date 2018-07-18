package cn.benzfungus.supermarket.web.form.user;

/**
 * 封装修改密码表单数据
 * @author benzfungus
 *
 */
public class ModifyUserPasswordWebForm extends UserWebForm{
	/**
	 * 旧密码
	 */
	private String oldPassword;
	
	/**
	 * 新密码
	 */
	private String newPassword;
	
	/**
	 * 重复新密码
	 */
	private String reNewPassword;
	
	/**
	 * 当前用户ID
	 */
	private String currentUserId;
	
	/**
	 * 当前用户密码
	 */
	private String currentUserPassword;
	
	
	public String getCurrentUserId() {
		return currentUserId;
	}
	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}
	public String getCurrentUserPassword() {
		return currentUserPassword;
	}
	public void setCurrentUserPassword(String currentUserPassword) {
		this.currentUserPassword = currentUserPassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getReNewPassword() {
		return reNewPassword;
	}
	public void setReNewPassword(String reNewPassword) {
		this.reNewPassword = reNewPassword;
	}
	
	@Override
	public boolean validate() {
		System.out.println(oldPassword);
		if(newPassword.length() >= 6) {
			if (oldPassword.equals(currentUserPassword)) {
				this.getErrorAlertMessageMap().put("modifyPassword", "新旧密码不能相同");
			}
			if (!oldPassword.equals(currentUserPassword) || oldPassword == null || newPassword == null || reNewPassword == null || !newPassword.equals(reNewPassword)) {
				this.getErrorAlertMessageMap().put("modifyPassword", "修改错误, 请检查输入");
				return false;
			}
		}else {
			this.getErrorAlertMessageMap().put("modifyPassword", "新密码长度太短应至少6位");
			return false;
		}
		
		return true;
	}
	
	/**
	 * 修改密码	
	 * @param id 要修改的用户ID
	 * @return
	 */
	public boolean modifyPassword(String id) {
		if(this.getUdao().modifyUserPassword(id, newPassword) > 0) {
			return true;
		}
		return false;
	}
	
}
