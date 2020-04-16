package fp.payment.models.vo;

public class PaymentInfo {
	private int paymentInfoNo;
	private int paymentInfoPaymentNo;
	private int paymentInfoPerfumeNo;
	private String paymentInfoPerfumePhotopath;
	private String paymentInfoPerfumeName;
	private int paymentInfoPerfumeVolume;
	private int paymentInfoBasketAmount;
	private int paymentInfoBasketPrice;
	public PaymentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PaymentInfo(int paymentInfoNo, int paymentInfoPaymentNo, int paymentInfoPerfumeNo,
			String paymentInfoPerfumePhotopath, String paymentInfoPerfumeName, int paymentInfoPerfumeVolume,
			int paymentInfoBasketAmount, int paymentInfoBasketPrice) {
		super();
		this.paymentInfoNo = paymentInfoNo;
		this.paymentInfoPaymentNo = paymentInfoPaymentNo;
		this.paymentInfoPerfumeNo = paymentInfoPerfumeNo;
		this.paymentInfoPerfumePhotopath = paymentInfoPerfumePhotopath;
		this.paymentInfoPerfumeName = paymentInfoPerfumeName;
		this.paymentInfoPerfumeVolume = paymentInfoPerfumeVolume;
		this.paymentInfoBasketAmount = paymentInfoBasketAmount;
		this.paymentInfoBasketPrice = paymentInfoBasketPrice;
	}

	public String getPaymentInfoPerfumePhotopath() {
		return paymentInfoPerfumePhotopath;
	}

	public void setPaymentInfoPerfumePhotopath(String paymentInfoPerfumePhotopath) {
		this.paymentInfoPerfumePhotopath = paymentInfoPerfumePhotopath;
	}

	public String getPaymentInfoPerfumeName() {
		return paymentInfoPerfumeName;
	}

	public void setPaymentInfoPerfumeName(String paymentInfoPerfumeName) {
		this.paymentInfoPerfumeName = paymentInfoPerfumeName;
	}

	public int getPaymentInfoPerfumeVolume() {
		return paymentInfoPerfumeVolume;
	}

	public void setPaymentInfoPerfumeVolume(int paymentInfoPerfumeVolume) {
		this.paymentInfoPerfumeVolume = paymentInfoPerfumeVolume;
	}

	public int getPaymentInfoNo() {
		return paymentInfoNo;
	}

	public void setPaymentInfoNo(int paymentInfoNo) {
		this.paymentInfoNo = paymentInfoNo;
	}

	public int getPaymentInfoPaymentNo() {
		return paymentInfoPaymentNo;
	}

	public void setPaymentInfoPaymentNo(int paymentInfoPaymentNo) {
		this.paymentInfoPaymentNo = paymentInfoPaymentNo;
	}

	public int getPaymentInfoPerfumeNo() {
		return paymentInfoPerfumeNo;
	}
	public void setPaymentInfoPerfumeNo(int paymentInfoPerfumeNo) {
		this.paymentInfoPerfumeNo = paymentInfoPerfumeNo;
	}
	public int getPaymentInfoBasketAmount() {
		return paymentInfoBasketAmount;
	}
	public void setPaymentInfoBasketAmount(int paymentInfoBasketAmount) {
		this.paymentInfoBasketAmount = paymentInfoBasketAmount;
	}
	public int getPaymentInfoBasketPrice() {
		return paymentInfoBasketPrice;
	}
	public void setPaymentInfoBasketPrice(int paymentInfoBasketPrice) {
		this.paymentInfoBasketPrice = paymentInfoBasketPrice;
	}
	
}
