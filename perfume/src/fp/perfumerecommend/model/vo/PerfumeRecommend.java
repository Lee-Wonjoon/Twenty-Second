package fp.perfumerecommend.model.vo;

import java.sql.Date;

public class PerfumeRecommend {
	private int perfumeRecommendNo;
	private int memberNo;
	private int perfumeNo;
	private Date perfumeRecommendDate;
	public PerfumeRecommend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PerfumeRecommend(int perfumeRecommendNo, int memberNo, int perfumeNo, Date perfumeRecommendDate) {
		super();
		this.perfumeRecommendNo = perfumeRecommendNo;
		this.memberNo = memberNo;
		this.perfumeNo = perfumeNo;
		this.perfumeRecommendDate = perfumeRecommendDate;
	}
	public int getPerfumeRecommendNo() {
		return perfumeRecommendNo;
	}
	public void setPerfumeRecommendNo(int perfumeRecommendNo) {
		this.perfumeRecommendNo = perfumeRecommendNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getPerfumeNo() {
		return perfumeNo;
	}
	public void setPerfumeNo(int perfumeNo) {
		this.perfumeNo = perfumeNo;
	}
	public Date getPerfumeRecommendDate() {
		return perfumeRecommendDate;
	}
	public void setPerfumeRecommendDate(Date perfumeRecommendDate) {
		this.perfumeRecommendDate = perfumeRecommendDate;
	}
}
