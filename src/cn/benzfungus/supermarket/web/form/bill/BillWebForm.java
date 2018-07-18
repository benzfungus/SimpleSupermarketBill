package cn.benzfungus.supermarket.web.form.bill;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.benzfungus.supermarket.bill.dao.BillDAO;
import cn.benzfungus.supermarket.bill.dao.impl.BillDAOImpl;
import cn.benzfungus.supermarket.web.form.WebForm;

public abstract class BillWebForm extends WebForm {
	/**
	 * 账单DAO
	 */
	private BillDAO bdao = new BillDAOImpl();
	
	private String id;
	/**
	 * 账单编号
	 */
	private String billCode;
	
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 价格
	 */
	private double price;
	
	/**
	 * 数量
	 */
	private int quantity;
	
	/**
	 * 总金额
	 */
	private double amount;
	
	/**
	 * 供应商ID
	 */
	private String providerId;
	
	/**
	 * 是否支付
	 */
	private int paid;
	@Override
	public boolean validate() {
		boolean isValidate = true;
		// 判断商品名称是否合法
		if (!validateGoodsName()) {
			System.out.println("商品名称不合法");
			this.getErrorAlertMessageMap().put("goodsName", "商品名称不合法");
			isValidate = false;
		}
		// 判断账单编码是否合法
		if (!validateBillCode()) {
			System.out.println("账单编码不合法");
			this.getErrorAlertMessageMap().put("price", "账单编码不合法");
			isValidate = false;
		}
		
		// 判断商品价格是否合法
		if (!validatePrice()) {
			System.out.println("商品价格不合法");
			this.getErrorAlertMessageMap().put("price", "商品价格不合法, 小数点后两位, 总位数不大于10位");
			isValidate = false;
		}
		
		// 判断商品数量是否合法
		if(!validateQuantity()) {
			this.getErrorAlertMessageMap().put("quantity", "商品数量不合法");
			isValidate = false;
		}
		
		// 判断总金额是否合法
		if (!validateAmount()) {
			this.getErrorAlertMessageMap().put("amount", "总金额不合法, 小数点后两位, 总位数不大于10位");
			isValidate = false;
		}
		
		// 判断供应商是否合法
		if (!validateProvider()) {
			this.getErrorAlertMessageMap().put("provider", "请选择供应商");
			isValidate = false;
		}
		return isValidate;
	}
	
	/**
	 * 判断商品价格是否合法
	 * @return
	 */
	private boolean validatePrice() {
		if (price > 0 && new Double(price).toString().length() <= 11) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断商品编码是否合法
	 * @return
	 */
	private boolean validateBillCode() {
		if (billCode.length() > 0 && billCode != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断商品名称是否合法
	 * @return
	 */
	private boolean validateGoodsName() {
		if (goodsName.length() > 0 && goodsName != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断总金额是否合法
	 * @return
	 */
	private boolean validateAmount() {
		if (amount > 0 && new Double(amount).toString().length() <= 11) {
			return true;
		}
		return false;
	}

	/**
	 * 判断商品数量是否合法
	 * @return
	 */
	private boolean validateQuantity() {
		if (quantity > 0 && new Integer(quantity).toString().length() <= 10) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断供应商是否合法
	 * @return
	 */
	private boolean validateProvider() {
		if (!providerId.equals("") && providerId != null) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 生成创建时间
	 * @return Date对象
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
	public BillDAO getBdao() {
		return bdao;
	}
	public void setBdao(BillDAO bdao) {
		this.bdao = bdao;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public int getPaid() {
		return paid;
	}
	public void setPaid(int paid) {
		this.paid = paid;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
