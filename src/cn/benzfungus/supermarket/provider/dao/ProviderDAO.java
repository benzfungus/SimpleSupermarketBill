package cn.benzfungus.supermarket.provider.dao;

import java.util.List;

import cn.benzfungus.supermarket.entity.Provider;
import cn.benzfungus.supermarket.web.form.provider.InsertProviderWebForm;
import cn.benzfungus.supermarket.web.form.provider.UpdateProviderWebForm;

/**
 * 供应商数据访问对象接口
 * @author benzfungus
 *
 */
public interface ProviderDAO {
	/**
	 * 获取所有供应商对象的集合
	 * @return 存放供应商对象的List集合
	 */
	List<Provider> getAllProvider();
	
	/**
	 * 根据供应商ID获取供应商对象
	 * @param providerId 供应商ID
	 * @return 供应商对象
	 */
	Provider getProviderByProviderId(String providerId);

	/**
	 * 添加供应商
	 * @param insertProviderWebForm 添加供应商的表单信息
	 * @return 影响的条目数量
	 */
	int insertProvider(InsertProviderWebForm insertProviderWebForm);
	
	
	/**
	 * 修改供应商信息
	 * @param updateProviderWebForm 更新供应商的表单信息
	 * @return 影响的条目数量
	 */
	int updateProvider(UpdateProviderWebForm updateProviderWebForm);
	
	/**
	 * 根据供应商ID删除供应商
	 * @param id 供应商ID
	 * @return 影响的条目数量
	 */
	int deleteProvider(String id);

	/**
	 * 查找供应商
	 * @param providerName 根据供应商名称查找供应商
	 * @return 供应商的集合
	 */
	List<Provider> searchProvider(String providerName);
	
}
