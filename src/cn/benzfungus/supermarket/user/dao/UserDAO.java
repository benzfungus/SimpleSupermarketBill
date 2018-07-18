package cn.benzfungus.supermarket.user.dao;

import java.util.List;

import cn.benzfungus.supermarket.entity.User;
import cn.benzfungus.supermarket.web.form.user.InsertUserWebForm;
import cn.benzfungus.supermarket.web.form.user.UpdateUserWebForm;

/**
 * 商品数据访问接口
 * @author benzfungus
 *
 */
public interface UserDAO {
	/**
	 * 获取所有用户对象的集合
	 * @return 存放用户对象的List集合
	 */
	public List<User> getAllUsers();
	
	/**
	 * 根据用户ID获取用户对象
	 * @param userId 用户ID
	 * @return 用户对象
	 */
	public User getUserByUserId(String userId);

	/**
	 * 验证用户
	 * @return 存在返回用户对象, 不存在返回null
	 */
	public User validateUser(String username, String password);

	/**
	 * 添加用户
	 * @param insertUserWebForm 提交的用户信息表单
	 * @return 影响的数据条目数量
	 */
	public int insertUser(InsertUserWebForm insertUserWebForm);
	
	/**
	 * 修改用户密码
	 * @param id 修改的用户ID
	 * @param newPassword 新密码
	 * @return 影响的数据条目数量
	 */
	public int modifyUserPassword(String id, String newPassword);

	/**
	 * 修改用户信息
	 * @param updateUserWebForm 封装的修改表单数据
	 * @return
	 */
	public int updateUser(UpdateUserWebForm updateUserWebForm);
	
	/**
	 * 删除用户
	 * @param id 要删除的用户ID
	 * @return 影响的数据条目数量
	 */
	public int deleteUser(String id);

	/**
	 * 查找用户
	 * @param username 查找的用户名
	 * @return 用户集合
	 */
	public List<User> searchUser(String username);
	
}
