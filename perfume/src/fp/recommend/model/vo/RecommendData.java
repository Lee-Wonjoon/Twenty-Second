package fp.recommend.model.vo;

import java.sql.Date;

public class RecommendData {
	private int recommendNo;
	private int recommendMemberNo;
	private int recommendPerfumeNo;
	private Date recommendDate;
	private String recommendPerfumeName;
	private String recommendPerfumePhotopath;
	private int recommendPerfumeVolume;
	public int getRecommendPerfumeVolume() {
		return recommendPerfumeVolume;
	}
	public void setRecommendPerfumeVolume(int recommendPerfumeVolume) {
		this.recommendPerfumeVolume = recommendPerfumeVolume;
	}
	public RecommendData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecommendData(int recommendNo, int recommendMemberNo, int recommendPerfumeNo, Date recommendDate,
			String recommendPerfumeName, String recommendPerfumePhotopath, int recommendPerfumeVolume) {
		super();
		this.recommendNo = recommendNo;
		this.recommendMemberNo = recommendMemberNo;
		this.recommendPerfumeNo = recommendPerfumeNo;
		this.recommendDate = recommendDate;
		this.recommendPerfumeName = recommendPerfumeName;
		this.recommendPerfumePhotopath = recommendPerfumePhotopath;
		this.recommendPerfumeVolume = recommendPerfumeVolume;
	}
	public int getRecommendNo() {
		return recommendNo;
	}
	public void setRecommendNo(int recommendNo) {
		this.recommendNo = recommendNo;
	}
	public int getRecommendMemberNo() {
		return recommendMemberNo;
	}
	public void setRecommendMemberNo(int recommendMemberNo) {
		this.recommendMemberNo = recommendMemberNo;
	}
	public int getRecommendPerfumeNo() {
		return recommendPerfumeNo;
	}
	public void setRecommendPerfumeNo(int recommendPerfumeNo) {
		this.recommendPerfumeNo = recommendPerfumeNo;
	}
	public Date getRecommendDate() {
		return recommendDate;
	}
	public void setRecommendDate(Date recommendDate) {
		this.recommendDate = recommendDate;
	}
	public String getRecommendPerfumeName() {
		return recommendPerfumeName;
	}
	public void setRecommendPerfumeName(String recommendPerfumeName) {
		this.recommendPerfumeName = recommendPerfumeName;
	}
	public String getRecommendPerfumePhotopath() {
		return recommendPerfumePhotopath;
	}
	public void setRecommendPerfumePhotopath(String recommendPerfumePhotopath) {
		this.recommendPerfumePhotopath = recommendPerfumePhotopath;
	}
	
}
