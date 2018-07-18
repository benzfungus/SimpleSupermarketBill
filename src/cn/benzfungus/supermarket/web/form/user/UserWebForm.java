package cn.benzfungus.supermarket.web.form.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.benzfungus.supermarket.user.dao.UserDAO;
import cn.benzfungus.supermarket.user.dao.impl.UserDAOImpl;
import cn.benzfungus.supermarket.web.form.WebForm;

public class UserWebForm extends WebForm {
	private UserDAO udao = new UserDAOImpl();
	private String id;
	private String username;  
	private String password; 
	private String rePassword;
	private int sex;
	private int age;
	private String email;
	private String mobilePhoneNumber;  
	private String address;
	private String birthOfDate; 
	private int userType; 
	
	@Override
	public boolean validate() {
		boolean isValidate = true;
		if (!validateName()) {
			System.out.println("用户名不合法");
			this.getErrorAlertMessageMap().put("username", "用户名不合法");
			isValidate = false;
		}
		if (!validatePassword()) {
			System.out.println("密码不合法");
			this.getErrorAlertMessageMap().put("password", "密码不合法");
			isValidate = false;
		}
		if(!validateEmail()) {
			System.out.println("邮箱不合法");
			this.getErrorAlertMessageMap().put("email", "邮箱不合法");
			isValidate = false;
		}
		if (!validateBirthOfDate()) {
			System.out.println("生日不合法");
			this.getErrorAlertMessageMap().put("birthOfDate", "生日不合法");
			isValidate = false;
		}
		if (!validateAge()) {
			System.out.println("年龄不合法");
			this.getErrorAlertMessageMap().put("age", "年龄不合法");
			isValidate = false;
		}
		if (!validateMobilePhoneNumber()) {
			System.out.println("电话号码不合法");
			this.getErrorAlertMessageMap().put("mobilePhoneNumber", "电话号码不合法");
			isValidate = false;
		}
		if (!validateAddress()) {
			System.out.println("地址不合法");
			this.getErrorAlertMessageMap().put("address", "地址不合法");
			isValidate = false;
		}
		return isValidate;
	}
	
	/**
	 * 验证用户年龄是否合法
	 * @return
	 */
	private boolean validateAge() {
		if (getAge() <= 0 || getAge() > 200) {
			return false;
		}
		return true;
	}

	/**
	 * 验证用户姓名是否合法
	 * @return
	 */
	private boolean validateName() {
		// 匹配列表中的字符，a-z,0–9,下划线，连字符, 长度至少3个字符，最大长度为15
		String regex = "^[a-z0-9_-]{3,12}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(username);
		return matcher.matches();
	}

	/**
	 * 验证用户密码是否合法
	 * @return
	 */
	private boolean validatePassword() {
		if(!password.equals(rePassword) && password.trim().length() < 6 || password.trim().length() > 20) {
			return false;
		}
		return true;
	}
	
	/**
	 * 验证邮箱是否合法
	 * @return
	 */
	private boolean validateEmail() {
		String regex = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	/**
	 * 验证电话号码是否合法
	 * @return
	 */
	private boolean validateMobilePhoneNumber() {
		String regex = "^1[3|4|5|8][0-9]\\d{8}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mobilePhoneNumber);
		return matcher.matches();
	}

	/**
	 * 验证地址是否合法
	 * @return
	 */
	private boolean validateAddress() {
		if (address.length() > 0 && address != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * 验证出生日期是否合法
	 * @return
	 */
	private boolean validateBirthOfDate() {
		Date date = transBirthOfDate();
		if(date != null) {
			if(date.before(new Date())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 转换出生日期为DATE对象
	 * @return
	 */
	private Date transBirthOfDate(){
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
		try {
			 date =  sdf.parse(birthOfDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	public int getAge() {
		setAge();
		return age;
	}
	
	/**
	 * 生成年龄
	 */
	public void setAge() {
		if(getTransBirthOfDate() != null) {
		Date d = new Date(System.currentTimeMillis());
		Calendar from = Calendar.getInstance();
		from.setTime(d);
		Calendar to = Calendar.getInstance();
		to.setTime(getTransBirthOfDate());
		int year = from.get(Calendar.YEAR) - to.get(Calendar.YEAR);
		this.age = year;
		}
	}
	
	public UserDAO getUdao() {
		return udao;
	}

	public String getId() {
		return id;
	}

	public void setUdao(UserDAO udao) {
		this.udao = udao;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
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

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
	public Date getTransBirthOfDate() {
		return transBirthOfDate();
	}
}
