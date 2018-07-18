package cn.benzfungus.supermarket.web.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	
	/**
	 * 获取到所有的请求参数，并将参数名 参数值对复制到WebForm实例成员变量中
	 */
	public static <E> E toWebForm(HttpServletRequest request, Class<E> clz) {
		// 创建变量
		E webFormInstance = null;
		try {
			// 创建类实例
			webFormInstance = clz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		// 获取用户提交的表单数据名
		Enumeration<String> names = request.getParameterNames();
		
		// 获取数据键值对
		while(names.hasMoreElements()) {
			String key = names.nextElement();
			String value = request.getParameter(key);
			try {
				// 为封装表单内容循环赋值转换
				BeanUtils.copyProperty(webFormInstance, key, value);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			
			/* 反射实现方式
			Field[] fields = webFormInstance.getClass().getDeclaredFields();
			for (Field field : fields) {
				if(field.getName().equals(key)) {
					field.setAccessible(true);
					try {
						field.set(webFormInstance, value);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}*/
		}
		return webFormInstance;
	} 
	
}
