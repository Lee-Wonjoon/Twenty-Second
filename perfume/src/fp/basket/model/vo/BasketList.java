package fp.basket.model.vo;

public class BasketList {
	private Basket b;
	private String perfumePhotopath;
	private String perfumeName;
	private int perfumeVolume;
	public BasketList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BasketList(Basket b, String perfumePhotopath, String perfumeName, int perfumeVolume) {
		super();
		this.b = b;
		this.perfumePhotopath = perfumePhotopath;
		this.perfumeName = perfumeName;
		this.perfumeVolume = perfumeVolume;
	}
	
	public String getPerfumePhotopath() {
		return perfumePhotopath;
	}

	public void setPerfumePhotopath(String perfumePhotopath) {
		this.perfumePhotopath = perfumePhotopath;
	}

	public String getPerfumeName() {
		return perfumeName;
	}

	public void setPerfumeName(String perfumeName) {
		this.perfumeName = perfumeName;
	}

	public int getPerfumeVolume() {
		return perfumeVolume;
	}

	public void setPerfumeVolume(int perfumeVolume) {
		this.perfumeVolume = perfumeVolume;
	}

	public Basket getB() {
		return b;
	}
	public void setB(Basket b) {
		this.b = b;
	}
}
