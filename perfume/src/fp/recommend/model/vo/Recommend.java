package fp.recommend.model.vo;

import java.sql.Date;

public class Recommend {
	private int recommendNo;
	private int recommendMemberNo;
	private int recommendPerfumeNo;
	private Date recommend_date;
	public Recommend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recommend(int recommendNo, int recommendMemberNo, int recommendPerfumeNo, Date recommend_date) {
		super();
		this.recommendNo = recommendNo;
		this.recommendMemberNo = recommendMemberNo;
		this.recommendPerfumeNo = recommendPerfumeNo;
		this.recommend_date = recommend_date;
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
	public Date getRecommend_date() {
		return recommend_date;
	}
	public void setRecommend_date(Date recommend_date) {
		this.recommend_date = recommend_date;
	}
	
}
