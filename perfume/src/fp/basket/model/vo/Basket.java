package fp.basket.model.vo;

public class Basket {
	private int basketNo;
	private int basketPerfumeNo;
	private int basketAmount;
	private int basketMemberNo;
	private int basketPrice;
	public Basket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Basket(int basketNo, int basketPerfumeNo, int basketAmount, int basketMemberNo, int basketPrice) {
		super();
		this.basketNo = basketNo;
		this.basketPerfumeNo = basketPerfumeNo;
		this.basketAmount = basketAmount;
		this.basketMemberNo = basketMemberNo;
		this.basketPrice = basketPrice;
	}

	public int getBasketMemberNo() {
		return basketMemberNo;
	}

	public void setBasketMemberNo(int basketMemberNo) {
		this.basketMemberNo = basketMemberNo;
	}

	public int getBasketNo() {
		return basketNo;
	}
	public void setBasketNo(int basketNo) {
		this.basketNo = basketNo;
	}
	public int getBasketPerfumeNo() {
		return basketPerfumeNo;
	}
	public void setBasketPerfumeNo(int basketPerfumeNo) {
		this.basketPerfumeNo = basketPerfumeNo;
	}
	public int getBasketAmount() {
		return basketAmount;
	}
	public void setBasketAmount(int basketAmount) {
		this.basketAmount = basketAmount;
	}
	
	public int getBasketPrice() {
		return basketPrice;
	}
	public void setBasketPrice(int basketPrice) {
		this.basketPrice = basketPrice;
	}
	
}
