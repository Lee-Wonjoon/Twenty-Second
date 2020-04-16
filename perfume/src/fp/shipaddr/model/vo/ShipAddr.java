package fp.shipaddr.model.vo;

public class ShipAddr {
	private int shipAddrNo;
	private int shipAddrMemberNo;
	private String shipAddrAddr;
	private String shipAddrPhone;
	private String shipAddrName;
	public ShipAddr() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShipAddr(int shipAddrNo, int shipAddrMemberNo, String shipAddrAddr, String shipAddrPhone,
			String shipAddrName) {
		super();
		this.shipAddrNo = shipAddrNo;
		this.shipAddrMemberNo = shipAddrMemberNo;
		this.shipAddrAddr = shipAddrAddr;
		this.shipAddrPhone = shipAddrPhone;
		this.shipAddrName = shipAddrName;
	}
	public int getShipAddrNo() {
		return shipAddrNo;
	}
	public void setShipAddrNo(int shipAddrNo) {
		this.shipAddrNo = shipAddrNo;
	}
	public int getShipAddrMemberNo() {
		return shipAddrMemberNo;
	}
	public void setShipAddrMemberNo(int shipAddrMemberNo) {
		this.shipAddrMemberNo = shipAddrMemberNo;
	}
	public String getShipAddrAddr() {
		return shipAddrAddr;
	}
	public void setShipAddrAddr(String shipAddrAddr) {
		this.shipAddrAddr = shipAddrAddr;
	}
	public String getShipAddrPhone() {
		return shipAddrPhone;
	}
	public void setShipAddrPhone(String shipAddrPhone) {
		this.shipAddrPhone = shipAddrPhone;
	}
	public String getShipAddrName() {
		return shipAddrName;
	}
	public void setShipAddrName(String shipAddrName) {
		this.shipAddrName = shipAddrName;
	}
	
}
