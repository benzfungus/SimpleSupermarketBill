package cn.benzfungus.supermarket.web.form;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户网页表单提交数据的封装抽象类
 * @author benzfungus
 *
 */
public abstract class WebForm {
	/**
	 * 错误信息提示
	 */
	private Map<String, String> errorAlertMessageMap = new HashMap<>();
	
	/**
	 * 获取错误提示
	 * @return 错误提示信息
	 */
	public Map<String, String> getErrorAlertMessageMap() {
		return errorAlertMessageMap;
	}
	
	/**
	 * 验证用户数据
	 * @return true 验证通过, false 验证失败
	 */
	public abstract boolean validate();
}
