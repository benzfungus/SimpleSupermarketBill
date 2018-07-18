package cn.benzfungus.supermarket.entity;

/**
 * 用户对象
 * @author benzfungus
 *
 */
public class User {
	
	/**
	 * 用户ID
	 */
	private String id;
	
	/**
	 * 用户名称
	 */
	private String username;
	
	/**
	 * 用户密码
	 */
	private String password;
	
	/**
	 * 性别
	 */
	private int sex;
	
	/**
	 * 年龄
	 */
	private int age;
	
	/**
	 * 出生日期
	 */
	private String birthOfDate;
	
	/**
	 * 电话号码
	 */
	private String mobilePhoneNumber;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 用户类型
	 */
	private int userType; 
	
	//构造器
	public User(String id, String username, int sex, int age, String birthOfDate, String mobilePhoneNumber,
			String address, String email, int userType) {
		super();
		this.id = id;
		this.username = username;
		this.sex = sex;
		this.age = age;
		this.birthOfDate = birthOfDate;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.address = address;
		this.email = email;
		this.userType = userType;
	}
	public User(String id, String username, int sex, int age, String mobilePhoneNumber, String email, int userType) {
		this.id = id;
		this.username = username;
		this.sex = sex;
		this.age = age;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.email = email;
		this.userType = userType;
	}
	public User(String id, String username, String password, int sex, int age, String mobilePhoneNumber, String email, int userType) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.email = email;
		this.userType = userType;
	}
	public User() {
	}

	// getter/setter
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthOfDate() {
		return birthOfDate;
	}
	public void setBirthOfDate(String birthOfDate) {
		this.birthOfDate = birthOfDate;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
