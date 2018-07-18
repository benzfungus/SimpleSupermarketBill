package cn.benzfungus.supermarket.web.form.provider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.benzfungus.supermarket.provider.dao.ProviderDAO;
import cn.benzfungus.supermarket.provider.dao.impl.ProviderDAOImpl;
import cn.benzfungus.supermarket.web.form.WebForm;

public abstract class ProviderWebForm extends WebForm {
	/**
	 * 获取ProviderDAO
	 */
	private ProviderDAO pdao = new ProviderDAOImpl();
	
	/**
	 * 供应商Id
	 */
	private String id;
	
	/**
	 * 供应商编码
	 */
	private String providerCode;
	
	/**
	 * 供应商名称
	 */
	private String providerName; 
	
	/**
	 * 联系人
	 */
	private String contact;
	
	/**
	 * 联系电话
	 */
	private String contactNumber;
	
	/**
	 * 联系地址
	 */
	private String address;
	
	/**
	 * 传真
	 */
	private String fax;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 描述
	 */
	private String description;
	
	@Override
	public boolean validate() {
		boolean isValidate = true;
		if (!validateProviderCode()) {
			this.getErrorAlertMessageMap().put("providerCode", "供应商编码不合法");
			isValidate = false;
		}
	
		if (!validateProviderName()) {
			System.out.println("用户名不合法");
			this.getErrorAlertMessageMap().put("providerName", "供应商名称不合法");
			isValidate = false;
		}
		
		if(!validateEmail()) {
			this.getErrorAlertMessageMap().put("email", "邮箱不合法");
			isValidate = false;
		}
		
		if (!validateContactNumber()) {
			this.getErrorAlertMessageMap().put("contactNumber", "联系电话不合法");
			isValidate = false;
		}
		
		if (!validateContact()) {
			this.getErrorAlertMessageMap().put("contact", "联系人不合法");
			isValidate = false;
		}
		return isValidate;
	}

	/**
	 * 验证供应商编码是否合法
	 * @return
	 */
	private boolean validateProviderCode() {
		if (providerCode.length() > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 验证供应商名称是否合法
	 * @return
	 */
	private boolean validateProviderName() {
		if (providerName.length() > 0 && providerName != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * 验证联系人是否合法
	 * @return
	 */
	private boolean validateContact() {
		if (contact.length() > 0 && contact != null) {
			return true;
		}
		return false;
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
	 * 验证联系电话是否合法
	 * @return
	 */
	private boolean validateContactNumber() {
		if (contactNumber.length() > 0 && contactNumber != null) {
			return true;
		}
		return false;
	}
 
	/**
	 * 生成创建时间
	 * @return 日期对象
	 */
	public Date generateCreateDate() {
		Date createTime = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
		String formatDate = sdf.format(new Date());
		try {
			createTime = sdf.parse(formatDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return createTime;
	}
	
	
	// getter/setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProviderCode() {
		return providerCode;
	}
	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ProviderDAO getPdao() {
		return pdao;
	}
	public void setPdao(ProviderDAO pdao) {
		this.pdao = pdao;
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}


}
