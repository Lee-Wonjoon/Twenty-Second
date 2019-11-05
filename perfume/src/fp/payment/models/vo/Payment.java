package fp.payment.models.vo;

import java.sql.Date;

public class Payment {
	private int paymentNo;
	private int paymentMemberNo;
	private String paymentProductName;
	private String paymentShipName;
	private String paymentShipPhone;
	private String paymentShipAddr;
	private String paymentShipMsg;
	private String paymentMerchantUid;
	private String paymentStatus;
	private int paymentPrice;
	private Date paymentDate;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Payment(int paymentNo, int paymentMemberNo, String paymentProductName, String paymentShipName,
			String paymentShipPhone, String paymentShipAddr, String paymentShipMsg, String paymentMerchantUid,
			String paymentStatus, int paymentPrice, Date paymentDate) {
		super();
		this.paymentNo = paymentNo;
		this.paymentMemberNo = paymentMemberNo;
		this.paymentProductName = paymentProductName;
		this.paymentShipName = paymentShipName;
		this.paymentShipPhone = paymentShipPhone;
		this.paymentShipAddr = paymentShipAddr;
		this.paymentShipMsg = paymentShipMsg;
		this.paymentMerchantUid = paymentMerchantUid;
		this.paymentStatus = paymentStatus;
		this.paymentPrice = paymentPrice;
		this.paymentDate = paymentDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public int getPaymentMemberNo() {
		return paymentMemberNo;
	}
	public void setPaymentMemberNo(int paymentMemberNo) {
		this.paymentMemberNo = paymentMemberNo;
	}
	public String getPaymentProductName() {
		return paymentProductName;
	}
	public void setPaymentProductName(String paymentProductName) {
		this.paymentProductName = paymentProductName;
	}
	public String getPaymentShipName() {
		return paymentShipName;
	}
	public void setPaymentShipName(String paymentShipName) {
		this.paymentShipName = paymentShipName;
	}
	public String getPaymentShipPhone() {
		return paymentShipPhone;
	}
	public void setPaymentShipPhone(String paymentShipPhone) {
		this.paymentShipPhone = paymentShipPhone;
	}
	public String getPaymentShipAddr() {
		return paymentShipAddr;
	}
	public void setPaymentShipAddr(String paymentShipAddr) {
		this.paymentShipAddr = paymentShipAddr;
	}
	public String getPaymentShipMsg() {
		return paymentShipMsg;
	}
	public void setPaymentShipMsg(String paymentShipMsg) {
		this.paymentShipMsg = paymentShipMsg;
	}
	public String getPaymentMerchantUid() {
		return paymentMerchantUid;
	}
	public void setPaymentMerchantUid(String paymentMerchantUid) {
		this.paymentMerchantUid = paymentMerchantUid;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public int getPaymentPrice() {
		return paymentPrice;
	}
	public void setPaymentPrice(int paymentPrice) {
		this.paymentPrice = paymentPrice;
	}
	
}
