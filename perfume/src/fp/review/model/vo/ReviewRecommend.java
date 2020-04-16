package fp.review.model.vo;

import java.sql.Date;

public class ReviewRecommend {
	private int reviewNo;
	private int memberNo;
	private Date recommendDate;
	public ReviewRecommend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewRecommend(int reviewNo, int memberNo, Date recommendDate) {
		super();
		this.reviewNo = reviewNo;
		this.memberNo = memberNo;
		this.recommendDate = recommendDate;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public Date getRecommendDate() {
		return recommendDate;
	}
	public void setRecommendDate(Date recommendDate) {
		this.recommendDate = recommendDate;
	}
	
	
}
