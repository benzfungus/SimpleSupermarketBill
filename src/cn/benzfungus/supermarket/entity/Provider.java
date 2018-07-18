package cn.benzfungus.supermarket.entity;

/**
 * 供应商对象
 * @author benzfungus
 *
 */
public class Provider {
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
	 * 创建日期
	 */
	private String createDate;
	
	/**
	 * 描述
	 */
	private String description;
	
	// 构造器
	public Provider(String providerCode, String providerName, String contact, String contactNumber, String address,
			String fax, String email, String createDate, String description) {
		this.providerCode = providerCode;
		this.providerName = providerName;
		this.contact = contact;
		this.contactNumber = contactNumber;
		this.address = address;
		this.fax = fax;
		this.email = email;
		this.createDate = createDate;
		this.description = description;
	}
	public Provider(String id, String providerCode, String providerName, String contact, String contactNumber,
			String address, String fax, String email, String createDate, String description) {
		this.id = id;
		this.providerCode = providerCode;
		this.providerName = providerName;
		this.contact = contact;
		this.contactNumber = contactNumber;
		this.address = address;
		this.fax = fax;
		this.email = email;
		this.createDate = createDate;
		this.description = description;
	}
	
	// getter/setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
