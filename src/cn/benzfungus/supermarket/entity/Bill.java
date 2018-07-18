package cn.benzfungus.supermarket.entity;

/**
 * 账单对象
 * @author benzfungus
 *
 */
public class Bill {
	/**
	 * 账单Id
	 */
	private String id;
	
	/**
	 * 账单号码
	 */
	private String billCode;
	
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 商品单价
	 */
	private double price;
	
	/**
	 * 商品数量
	 */
	private int quantity;
	
	/**
	 * 商品总价
	 */
	private double amount;
	
	/**
	 * 供应商Id
	 */
	private String providerId;
	
	/**
	 * 是否付款
	 */
	private int paid;
	
	/**
	 * 创建日期
	 */
	private String createDate;
	
	/**
	 * 无参构造器
	 */
	public Bill() {
	}
	
	/**
	 * 有参构造器
	 */
	public Bill(String id, String billCode, String goodsName, double price, int quantity, double amount,
			String providerId, int paid, String createDate) {
		this.id = id;
		this.billCode = billCode;
		this.goodsName = goodsName;
		this.price = price;
		this.quantity = quantity;
		this.amount = amount;
		this.providerId = providerId;
		this.paid = paid;
		this.createDate = createDate;
	}

	
	 // getter/setter
	 
	public String getId() {
		return id;
	}
	public String getBillCode() {
		return billCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getAmount() {
		return amount;
	}
	public String getProviderId() {
		return providerId;
	}
	public int getPaid() {
		return paid;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public void setPaid(int paid) {
		this.paid = paid;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
